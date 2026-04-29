package com.gedoria.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Rajan Kurt O. Gedoria");
        response.put("id", "2025-1021948");
        response.put("course", "CS");
        response.put("message", "omg");
        return response;

        }
    }


