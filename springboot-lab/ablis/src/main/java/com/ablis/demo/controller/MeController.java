package com.ablis.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author matidagreat
 *
 * Q1: How did you create your Spring Boot project?
 * A1: I generated the project using Spring Initializr.
 *
 * Q2: What is the purpose of the @RestController annotation?
 * A2: It tells Spring that this class is a REST controller that will expose REST API endpoints.
 *
 * Q3: What does the @GetMapping("/me") annotation do?
 * A3: It maps HTTP GET requests for "/me" to this method.
 *
 * Q4: Why did you change from returning a String to a Map?
 * A4: Returning a Map allows structured key/value data, making the response easier to read and serialize as JSON.
 *
 * Q5: How does Spring Boot handle JSON responses automatically?
 * A5: Spring Boot uses Jackson by default to convert response objects into JSON.
 */

@RestController
public class MeController {

//    @GetMapping("/me")
//    public String getMe(){
//        return "Hello! I am weird";
//    }

    @GetMapping("/me")
    public Map<String,Object> getMe(){
        Map<String,Object> response = new HashMap<>();
        response.put("name", "Ablis, Margreleigne M.");
        response.put("studentId", "2025-1020011");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}
