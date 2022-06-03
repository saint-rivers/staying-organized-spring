package com.stayingorganized.api.folder.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.stayingorganized.api.content.Content;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FolderTree {
    @JsonPropertyOrder(value = "1")
    private UUID id;
    @JsonPropertyOrder(value = "3")
    private String name;
    @JsonPropertyOrder(value = "4")
    private List<Content> content;
    @JsonPropertyOrder(value = "5")
    private List<FolderTree> subFolders;
    @JsonPropertyOrder(value = "2")
    private Integer nodeLevel;
    private Integer deepestNodeLevel;
    private Date dateCreated;
    private Date lastUpdated;
}

