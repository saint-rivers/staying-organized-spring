package com.stayingorganized.api.folder.model.response;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.stayingorganized.api.content.Content;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FolderResponse {

    private UUID id;
    private UUID parentId;
    private String name;
    private List<Content> content;

    private List<FolderResponse> subFolders;

    private Date createdAt;
    private Date lastUpdated;
}
