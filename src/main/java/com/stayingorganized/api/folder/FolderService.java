package com.stayingorganized.api.folder;

import java.util.UUID;

import com.stayingorganized.api.folder.model.FolderTree;
import com.stayingorganized.api.folder.model.request.FolderRequest;
import com.stayingorganized.api.folder.model.response.FolderResponse;

public interface FolderService {

    FolderResponse findById(UUID id);

    FolderTree getFolderTree(UUID rootFolderId);

    FolderResponse createFolder(FolderRequest folderRequest);

}
