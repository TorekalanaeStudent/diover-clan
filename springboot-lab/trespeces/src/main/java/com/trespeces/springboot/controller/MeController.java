package com.trespeces.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Trespeces, Guillermo II O.
 * @willj067
 *
 * 1. How did you create your Spring Boot project?
 *    I used Spring Initializr at start.spring.io to generate the project,
 *    added Spring Web as a dependency, downloaded the ZIP and extracted it.
 *
 * 2. What is the purpose of the @RestController annotation?
 *    @RestController tells Spring that this class will handle web requests
 *    and return data directly, not a webpage.
 *
 * 3. What does the @GetMapping("/me") annotation do?
 *    @GetMapping("/me") means when someone does a GET request to /me,
 *    this method will run and return the response.
 *
 * 4. Why did you change from returning a String to a Map?
 *    I switched to Map because it lets Spring automatically format the
 *    response as JSON, which is more useful than plain text.
 *
 * 5. How does Spring Boot handle JSON responses automatically?
 *    Spring Boot automatically converts the Map into JSON when it sees
 *    that the method returns an object. I didn't have to do anything extra.
 */

@RestController
public class MeController {

//    @GetMapping("/me")
//    public String getMe() {
//        return "Hello! I am Guillermo II O. Trespeces, a student learning Spring Boot!";
//    }

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Guillermo II O. Trespeces");
        response.put("studentId", "2025-1025412");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}

