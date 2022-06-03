package com.stayingorganized.api.folder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stayingorganized.api.content.Content;
import com.stayingorganized.api.content.ContentResponse;
import com.stayingorganized.api.content.ContentUploadRequest;
import com.stayingorganized.api.folder.model.FolderTree;
import com.stayingorganized.api.folder.model.exception.CircularFolderReferenceException;
import com.stayingorganized.api.folder.model.request.FolderRequest;
import com.stayingorganized.api.folder.model.Folder;
import com.stayingorganized.api.folder.model.response.FolderResponse;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {

    private final FolderRepository folderRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper jsonMapper;

    @Override
    public FolderResponse findById(UUID id) {
        Folder folder = folderRepository.findById(id.toString());
        return modelMapper.map(folder, FolderResponse.class);
    }

    @Override
    public FolderTree getFolderTree(UUID rootFolderId) {
        Folder folder = this.getFolderTreeRecursive(rootFolderId, 0);
        return modelMapper.map(folder, FolderTree.class);
    }

    private Folder getFolderTreeRecursive(UUID folderId, int nodeLevel) {
        Folder folder = folderRepository.findById(folderId.toString());
        if (folder.getSubFolders() != null) {
            List<Folder> subFolders = new ArrayList<>();
            folder.getSubFolders().forEach(f -> {
                if (f.getId() == folderId) throw new CircularFolderReferenceException();
                Folder tmp = this.getFolderTreeRecursive(f.getId(), nodeLevel + 1);
                tmp.setNodeLevel(nodeLevel);
                subFolders.add(tmp);
            });
            folder.setSubFolders(subFolders);
        }
        return folder;
    }

    @Override
    public FolderResponse createFolder(FolderRequest folderRequest) {
        folderRequest.setDateCreated(new Date());

        Folder folder = folderRepository.insert(folderRequest, true);
        return modelMapper.map(folder, FolderResponse.class);
    }

    @Override
    public List<ContentResponse> insertContentToFile(ContentUploadRequest content) throws JsonProcessingException {
        String contentAsString = jsonMapper.writeValueAsString(content);
        String id = folderRepository.insertContentToFolder(contentAsString, content.getFolderId());
        List<Content> contents = folderRepository.getContentsOfFolder(id);
        return contents.stream().map(c -> modelMapper.map(c, ContentResponse.class)).collect(Collectors.toList());
    }

}
