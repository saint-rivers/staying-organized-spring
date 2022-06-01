package com.stayingorganized.api.fileupload;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileStorageRestController {

    private final FileService fileService;

    @Operation(summary = "Upload multiple Files")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createFolder(@RequestPart MultipartFile[] files) throws IOException {

        List<FileUploadResponse> fileNames = new ArrayList<>();
        for (MultipartFile file : files) {
            fileNames.add(fileService.save(file));
        }

        return ResponseEntity
                .ok()
                .body(fileNames);
    }
}
