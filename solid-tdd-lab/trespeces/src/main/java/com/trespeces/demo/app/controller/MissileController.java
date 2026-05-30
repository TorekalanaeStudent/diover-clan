package com.trespeces.demo.app.controller;

import com.trespeces.demo.app.dto.MissileDTO;
import com.trespeces.demo.app.service.MissileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// GRASP: Controller - handles HTTP requests only, delegates ALL logic to Service
// GRASP: Low Coupling - only depends on MissileService
@RestController
@RequestMapping("/api/missiles")
@RequiredArgsConstructor
public class MissileController {

    private final MissileService missileService;

    @PostMapping
    public ResponseEntity<MissileDTO> createMissile(@RequestBody Map<String, Object> request) {
        String name = (String) request.get("name");
        String type = (String) request.get("type");
        double price = ((Number) request.get("price")).doubleValue();
        int quantity = ((Number) request.get("quantity")).intValue();
        return ResponseEntity.ok(missileService.createMissile(name, type, price, quantity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissileDTO> getMissile(@PathVariable Long id) {
        return ResponseEntity.ok(missileService.getMissile(id));
    }

    @GetMapping
    public ResponseEntity<List<MissileDTO>> getAllMissiles() {
        return ResponseEntity.ok(missileService.getAllMissiles());
    }

    @PatchMapping("/{id}/launch")
    public ResponseEntity<MissileDTO> launchMissile(@PathVariable Long id,
                                                    @RequestParam String launchType) {
        return ResponseEntity.ok(missileService.launchMissile(id, launchType));
    }

    @PatchMapping("/{id}/destroy")
    public ResponseEntity<MissileDTO> destroyMissile(@PathVariable Long id) {
        return ResponseEntity.ok(missileService.destroyMissile(id));
    }
}