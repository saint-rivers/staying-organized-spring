package com.stayingorganized.api.fileupload;

import com.stayingorganized.api.content.ContentUploadRequest;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@SuperBuilder
public class FileUploadResponse extends ContentUploadRequest {

//    private String fileDisplayName;
//    private String generatedFileName;
}
