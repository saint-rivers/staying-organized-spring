package com.stayingorganized.api.folder.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Folder  {

    private UUID id;
    private UUID parentId;
    private String name;
    private List<Content> content;

    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;
}
