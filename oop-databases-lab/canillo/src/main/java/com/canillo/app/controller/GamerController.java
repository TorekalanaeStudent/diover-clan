package com.canillo.app.controller;

import com.canillo.app.entity.Gamer;
import com.canillo.app.repository.GamerRepository;
import com.canillo.app.service.GamerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gamers")
@RequiredArgsConstructor
public class GamerController {

    private final GamerService gamerService;

    @GetMapping
    public ResponseEntity<List<Gamer>> findAll() {
        return ResponseEntity.ok(gamerService.getAllGamers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gamer> getGamer(@PathVariable Long id) {
        return ResponseEntity.ok(gamerService.getGamerById(id));
    }

    @PostMapping
    public ResponseEntity<Gamer> createGamer(@Valid @RequestBody Gamer gamer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gamerService.createGamer(gamer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gamer> updateGamer(@PathVariable Long id, @Valid @RequestBody Gamer gamer) {
        return ResponseEntity.ok(gamerService.updateGamer(id, gamer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGamer(@PathVariable Long id) {
        gamerService.deleteGamer(id);
        return ResponseEntity.noContent().build(); // 204 error
    }
}
