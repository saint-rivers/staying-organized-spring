package com.stayingorganized.api.fileupload;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@Slf4j
@PropertySource("classpath:/file-storage-dev.properties")
public class FileServiceImpl implements FileService {

    @Value("file.storage.location")
    String fileStorageLocation;

    public String save(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new NullPointerException("File is empty");
        }
        Path uploadDirectory = Paths.get(fileStorageLocation);

        if (!uploadDirectory.toFile().exists()) {
            boolean createdDirectorySuccessfully = uploadDirectory.toFile().mkdir();
            log.info(createdDirectorySuccessfully ? "Created UPLOADS folder successfully." : "Unable to create uploads folder.");
        }

        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        String extension = originalFilename.split("\\.")[1];

        String newFilename = UUID.randomUUID() + "." + extension;
        Path targetFilename = uploadDirectory.resolve(newFilename);
        Files.copy(file.getInputStream(), targetFilename, StandardCopyOption.REPLACE_EXISTING);
        return newFilename;
    }
}
