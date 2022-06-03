package com.stayingorganized.api.folder;

import java.util.UUID;

import com.stayingorganized.api.folder.model.FolderTree;
import com.stayingorganized.api.folder.model.request.FolderRequest;
import com.stayingorganized.api.folder.model.response.FolderResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/folders")
@RequiredArgsConstructor
@CrossOrigin
public class FolderController {

    private final FolderService folderService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getHello(@PathVariable("id") String folderId) {
        FolderResponse folder = folderService.findById(UUID.fromString(folderId));
        return ResponseEntity
                .ok()
                .body(folder);
    }

    @GetMapping("/tree/{id}")
    public ResponseEntity<?> getFolderTree(@PathVariable("id") String folderId) {
        FolderTree folder = folderService.getFolderTree(UUID.fromString(folderId));
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
