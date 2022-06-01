package com.stayingorganized.api.fileupload;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
@PropertySource("classpath:/file-storage-dev.properties")
public class FileServiceImpl implements FileService {

    @Value("${file.storage.location}")
    String FILE_STORAGE_LOCATION;

    public FileUploadResponse save(MultipartFile file) throws IOException {
        String fileExtension = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
        String uuidFileName = UUID.randomUUID() + "." + fileExtension;
        Path targetPath = Paths.get(FILE_STORAGE_LOCATION);
//        String filename = Objects.requireNonNull(file.getOriginalFilename());

        Path targetFile = targetPath.resolve(uuidFileName);
        Files.copy(file.getInputStream(), targetFile, StandardCopyOption.REPLACE_EXISTING);

        return FileUploadResponse.builder()
                .fileDisplayName(file.getOriginalFilename())
                .generatedFileName(uuidFileName)
                .build();
    }

}
