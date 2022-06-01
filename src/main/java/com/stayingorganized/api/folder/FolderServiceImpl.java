package com.stayingorganized.api.folder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Override
    public FolderResponse findById(UUID id) {
        Folder folder = folderRepository.findById(id.toString());
        return modelMapper.map(folder, FolderResponse.class);
    }

    @Override
    public FolderTree getFolderTree(UUID rootFolderId) {
        Folder folder = this.getFolderTreeRecursive(rootFolderId);
        return modelMapper.map(folder, FolderTree.class);
    }

    private Folder getFolderTreeRecursive(UUID rootFolderId) {
        Folder folder = folderRepository.findById(rootFolderId.toString());
        if (folder.getSubFolders() != null) {
            List<Folder> subFolders = new ArrayList<>();
            folder.getSubFolders().forEach(f -> {
                if (f.getId() == rootFolderId) throw new CircularFolderReferenceException();
                Folder tmp = this.getFolderTreeRecursive(f.getId());
                subFolders.add(tmp);
            });
            folder.setSubFolders(subFolders);
        }
        return folder;
    }

    @Override
    public FolderResponse createFolder(FolderRequest folderRequest) {
        folderRequest.setDateCreated(LocalDateTime.now());

        Folder folder = folderRepository.insert(folderRequest, true);
        return modelMapper.map(folder, FolderResponse.class);
    }

}
