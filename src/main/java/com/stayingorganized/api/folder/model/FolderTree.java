package com.stayingorganized.api.folder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FolderTree {
    private UUID id;
    private String name;
    private List<Content> content;
    private List<FolderTree> subFolders;
}

