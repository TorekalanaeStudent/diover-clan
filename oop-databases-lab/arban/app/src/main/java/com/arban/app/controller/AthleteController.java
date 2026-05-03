package com.arban.app.controller;

import com.arban.app.entity.Athlete;
import com.arban.app.service.AthleteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/athletes")
@RequiredArgsConstructor
public class AthleteController {

    private final AthleteService athleteService;

    @GetMapping
    public ResponseEntity<List<Athlete>> findAll() {
        return ResponseEntity.ok(athleteService.getAllAthletes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Athlete> getAthlete(@PathVariable Long id) {
        return ResponseEntity.ok(athleteService.getAthleteById(id));
    }

    @PostMapping
    public ResponseEntity<Athlete> createAthlete(@Valid @RequestBody Athlete athlete) {
        return ResponseEntity.status(HttpStatus.CREATED).body(athleteService.createAthlete(athlete));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Athlete> updateAthlete(@PathVariable Long id, @Valid @RequestBody Athlete athlete) {
        return ResponseEntity.ok(athleteService.updateAthlete(id, athlete));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAthlete(@PathVariable Long id) {
        athleteService.deleteAthlete(id);
        return ResponseEntity.noContent().build(); // 204
    }
}