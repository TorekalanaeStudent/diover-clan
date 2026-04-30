package com.trespeces.demo.controller;

import com.trespeces.demo.entity.Album;
import com.trespeces.demo.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Trespeces, Guillermo II O.
 * @willj067
 *
 * Step 10: Reflection
 *
 * 1. What changed from previous lab?
 *    The previous lab only had a simple GET endpoint with hardcoded data.
 *    Now we have full CRUD operations with real database persistence.
 *
 * 2. Why is database better?
 *    Data is saved even after the app restarts, unlike hardcoded data
 *    which disappears every time.
 *
 * 3. How did JPA help?
 *    JPA handled all the SQL automatically. I didn't have to write any
 *    SQL queries manually — just defined the entity and repository.
 *
 * 4. What changed when switching DB?
 *    Just changed the application.properties config. The actual Java code
 *    didn't change at all, which shows how powerful JPA abstraction is.
 */

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        return ResponseEntity.ok(albumService.getAlbumById(id));
    }

    @PostMapping
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        return ResponseEntity.ok(albumService.createAlbum(album));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable Long id, @RequestBody Album album) {
        return ResponseEntity.ok(albumService.updateAlbum(id, album));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return ResponseEntity.noContent().build();
    }
}