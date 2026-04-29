package com.gedoria.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        response.put("name", "Rajan Kurt O. Gedoria");
        response.put("id", "2025-1021948");
        response.put("course", "CS");
        response.put("message", "omg");
        return response;

        }
    }


