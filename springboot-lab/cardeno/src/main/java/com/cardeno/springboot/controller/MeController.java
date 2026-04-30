package com.cardeno.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cardeño, Faye L.
 * @flcardeno
 *
 * - Code-based Analysis -
 * 1. How did you create your Spring Boot project?
 *  - I created my Spring Boot project using Spring Initializr.
 * 2. What is the purpose of the @RestController annotation?
 *  - It means that this class is used for handling API requests and sending responses back.
 * 3. What does the @GetMapping("/me") annotation do?
 *  - It means that when someone sends a GET request to /me, it will run the getMe() method and return its result.
 * 4. Why did you change from returning a String to a Map?
 *  - I switched from String to Map to return structured data instead of plain text.
 * 5. How does Spring Boot handle JSON responses automatically?
 *  - Spring Boot automatically turns Java objects like Map into JSON using Jackson, so I don’t have to manually convert it myself.
 *
 */

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
