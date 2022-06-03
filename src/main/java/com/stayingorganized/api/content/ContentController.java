package com.stayingorganized.api.content;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stayingorganized.api.folder.FolderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/content")
@AllArgsConstructor
@CrossOrigin
public class ContentController {

    private final FolderService folderService;

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size
    ) {
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(null);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody ContentUploadRequest contentUploadRequest) throws JsonProcessingException {
        List<ContentResponse> contentResponses = folderService.insertContentToFile(contentUploadRequest);
        return ResponseEntity.ok().body(contentResponses);
    }

    @PutMapping
    public ResponseEntity<?> put() {
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping
    public ResponseEntity<?> delete() {
        return ResponseEntity.ok().body(null);
    }

}



