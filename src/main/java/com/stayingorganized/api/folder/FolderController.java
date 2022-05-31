package com.stayingorganized.api.folder;

import java.util.UUID;

import com.stayingorganized.api.folder.model.request.FolderRequest;
import com.stayingorganized.api.folder.model.response.FolderResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/folders")
@RequiredArgsConstructor
public class FolderController {

    private final FolderService folderService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getHello(@PathVariable("id") String folderId) {
        FolderResponse folder = folderService.findById(UUID.fromString(folderId));
        return ResponseEntity
                .ok()
                .body(folder);
    }

    @PostMapping
    public ResponseEntity<?> createFolder(@RequestBody FolderRequest folderRequest) {

        FolderResponse folder = folderService.createFolder(folderRequest);
        return ResponseEntity
                .ok()
                .body(folder);
    }
}
