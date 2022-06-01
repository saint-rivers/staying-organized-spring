package com.stayingorganized.api.fileupload;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class FileUploadResponse {

    private String fileDisplayName;
    private String generatedFileName;
}
