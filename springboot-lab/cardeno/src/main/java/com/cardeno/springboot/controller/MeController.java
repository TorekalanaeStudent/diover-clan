package com.cardeno.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
    public class MeController {

/*
        @GetMapping("/me")
        public String getMe() {
            return "Hello! I am Faye L. Cardeño, a student learning Spring Boot!";
 */
        @GetMapping("/me")
        public Map<String, Object> getMe() {
            Map<String, Object> response = new HashMap<>();
            response.put("name", "Faye L. Cardeño");
            response.put("studentId", "2025-1025317");
            response.put("course", "Java Programming");
            response.put("message", "Learning Spring Boot REST APIs!");
            return response;
    }
}
