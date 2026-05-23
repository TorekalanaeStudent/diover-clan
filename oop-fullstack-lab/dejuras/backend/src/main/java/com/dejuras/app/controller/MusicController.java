package com.dejuras.app.controller;

import com.dejuras.app.model.Music;
import com.dejuras.app.service.MusicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/music")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class MusicController {

    private final MusicService musicService;

    // GET /api/music
    @GetMapping
    public ResponseEntity<List<Music>> getAllMusic() {
        return ResponseEntity.ok(musicService.getAllMusic());
    }

    // GET /api/music/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Music> getMusicById(@PathVariable Long id) {
        return ResponseEntity.ok(musicService.getMusicById(id));
    }

    // POST /api/music → 201 Created
    @PostMapping
    public ResponseEntity<Music> createMusic(@Valid @RequestBody Music music) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(musicService.createMusic(music));
    }

    // PUT /api/music/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Music> updateMusic(
            @PathVariable Long id,
            @Valid @RequestBody Music music
    ) {
        return ResponseEntity.ok(musicService.updateMusic(id, music));
    }

    // DELETE /api/music/{id} → 204 No Content
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusic(@PathVariable Long id) {
        musicService.deleteMusic(id);
        return ResponseEntity.noContent().build();
    }
}
