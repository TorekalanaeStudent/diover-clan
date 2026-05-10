package com.caneda.fullstack.controller;

import com.caneda.fullstack.entity.CoinFlip;
import com.caneda.fullstack.service.CoinFlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/flips")
@CrossOrigin(origins = "http://localhost:5173")
public class CoinFlipController {

    @Autowired
    private CoinFlipService coinFlipService;

    // POST /api/users/{userId}/flips?choice=heads
    @PostMapping
    public CoinFlip flip(@PathVariable Long userId, @RequestParam String choice) {
        return coinFlipService.flip(userId, choice);
    }

    // GET /api/users/{userId}/flips
    @GetMapping
    public List<CoinFlip> getFlips(@PathVariable Long userId) {
        return coinFlipService.getFlipsByUser(userId);
    }

}