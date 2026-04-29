package com.go.springboot.controller;

/* Code-Based Analysis
 *
 *  @author Go, Sean Ethan
 *  @sethplaysbadly
 *
 * 1. How did you create your Spring Boot project?
 * A: I created the project using Spring Initializr (start.spring.io), selecting Gradle, Java 21, and the Spring Web dependency.
 *
 * 2. What is the purpose of the @RestController annotation?
 * A: The @RestController annotation is used to build RESTful web services by combining @Controller and @ResponseBody in one annotation.
 *
 * 3. What does the @GetMapping("/me") annotation do?
 * A: The @GetMapping("/me") annotation maps HTTP GET requests to the /me endpoint.
 *
 * 4. Why did you change from returning a String to a Map?
 * A: I changed it from returning a String to a Map because Task 6 required a structured JSON response instead of plain text.
 *
 * 5. How does Spring Boot handle JSON responses automatically?
 * A: Spring Boot uses the Jackson library by default to automatically convert Java objects and maps into JSON format.
 *
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Sean Ethan G. Go");
        response.put("studentId", "2025-1024028");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");

        return response;
    }
}
// ILY STR