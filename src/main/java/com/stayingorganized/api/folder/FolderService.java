package com.stayingorganized.api.folder;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stayingorganized.api.content.ContentResponse;
import com.stayingorganized.api.content.ContentUploadRequest;
import com.stayingorganized.api.folder.model.Folder;
import com.stayingorganized.api.folder.model.FolderTree;
import com.stayingorganized.api.folder.model.request.FolderRequest;
import com.stayingorganized.api.folder.model.response.FolderResponse;

public interface FolderService {

    FolderResponse findById(UUID id);

    FolderTree getFolderTree(UUID rootFolderId);

    FolderResponse createFolder(FolderRequest folderRequest);

    List<ContentResponse> insertContentToFile(ContentUploadRequest content) throws JsonProcessingException;

}
