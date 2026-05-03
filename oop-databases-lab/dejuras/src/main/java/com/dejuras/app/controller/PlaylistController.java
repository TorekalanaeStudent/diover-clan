package com.dejuras.app.controller;

import com.dejuras.app.entity.Playlist;
import com.dejuras.app.service.PlaylistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlists")
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    @GetMapping
    public ResponseEntity<List<Playlist>> findAll() {
        return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylist(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.getPlaylist(id));
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@Valid @RequestBody Playlist playlist) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(playlistService.createPlaylist(playlist));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable Long id,
                                                   @Valid @RequestBody Playlist playlist) {
        return ResponseEntity.ok(playlistService.updatePlaylist(id, playlist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }
}