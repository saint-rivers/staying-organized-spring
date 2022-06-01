package com.stayingorganized.api.fileupload;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    FileUploadResponse save(MultipartFile file) throws IOException;
}
