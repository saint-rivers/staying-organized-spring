package com.stayingorganized.api.folder;

import java.util.UUID;

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
    public FolderResponse createFolder(FolderRequest folderRequest) {
        Folder folder = folderRepository.insert(folderRequest, false);
        return modelMapper.map(folder, FolderResponse.class);
    }

}
