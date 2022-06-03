package com.stayingorganized.api.content;

//import java.time.Date;
//import java.time.DateTime;
import java.util.Date;
import java.util.UUID;

import com.stayingorganized.api.folder.model.enums.ContentType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Content {

    private UUID id;
    private UUID folderId;
    private String displayName;
    private String resourceLocation;
    private ContentType type;
    
    private Date createdAt;
    private Date lastUpdated;
}
