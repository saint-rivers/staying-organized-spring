package com.stayingorganized.api.folder.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.stayingorganized.api.folder.model.enums.ContentType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Content {

    private UUID id;
    private String displayName;
    private String resourceLocation;
    private ContentType type;
    
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;
}
