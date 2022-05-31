package com.stayingorganized.api.folder.model.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.stayingorganized.api.folder.model.Content;

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
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;
}
