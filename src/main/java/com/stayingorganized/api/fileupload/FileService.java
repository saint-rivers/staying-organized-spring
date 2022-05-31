package com.stayingorganized.api.fileupload;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    String save(MultipartFile file) throws IOException;
}
