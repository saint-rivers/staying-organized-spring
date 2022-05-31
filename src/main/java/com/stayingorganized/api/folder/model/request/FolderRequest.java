package com.stayingorganized.api.folder.model.request;

import java.time.LocalDateTime;
import java.util.UUID;

import com.stayingorganized.api.utils.DateModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class FolderRequest extends DateModel {
    private UUID parentId;
    private String name;
    // private LocalDateTime createdAt;
    // private LocalDateTime lastUpdated;
}
