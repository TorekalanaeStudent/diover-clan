package com.trespeces.backend.controller;

import com.trespeces.backend.entity.Idol;
import com.trespeces.backend.service.IdolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/idols")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class IdolController {

    private final IdolService idolService;

    @GetMapping
    public List<Idol> getAllIdols() {
        return idolService.getAllIdols();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Idol> getIdolById(@PathVariable Long id) {
        return ResponseEntity.ok(idolService.getIdolById(id));
    }

    @PostMapping
    public ResponseEntity<Idol> createIdol(@RequestBody Idol idol) {
        return ResponseEntity.ok(idolService.createIdol(idol));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Idol> updateIdol(@PathVariable Long id, @RequestBody Idol idol) {
        return ResponseEntity.ok(idolService.updateIdol(id, idol));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIdol(@PathVariable Long id) {
        idolService.deleteIdol(id);
        return ResponseEntity.noContent().build();
    }
}