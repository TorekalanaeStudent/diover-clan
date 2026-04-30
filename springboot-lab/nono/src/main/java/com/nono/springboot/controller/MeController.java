package com.nono.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Author Mary Angeline Nono
 *
 * Q1: How did you create your Spring Boot project?
 * A1: I created my Spring Boot project using Spring Initializr by selecting Gradle as the project type,
 * Java as the language, adding the Spring Web dependency, and generating the project structure automatically.
 *
 * Q2: What is the purpose of the @RestController annotation?
 * A2: The @RestController annotation tells Spring that this class will handle REST API requests
 * and automatically converts returned Java objects into JSON responses.
 *
 * Q3: What does the @GetMapping("/me") annotation do?
 * A3: The @GetMapping("/me") annotation maps HTTP GET requests to the /me endpoint,
 * allowing clients to retrieve data from this specific URL.
 *
 * Q4: Why did you change from returning a String to a Map?
 * A4: I changed from returning a String to a Map to provide structured data in JSON format,
 * which is more useful and standard for REST APIs.
 *
 * Q5: How does Spring Boot handle JSON responses automatically?
 * A5: Spring Boot uses the Jackson library to automatically convert Java objects
 * like Map or classes into JSON format when returning responses from a REST controller.
 */

@RestController
public class MeController {

   // @GetMapping("/me")
    //public String getMe(){
      //  return "Hello! I am Mary Angeline B.Nono, a good student!";
    //}

    @GetMapping("/me")
    public Map<String,Object> getMe(){
        Map<String,Object> response = new HashMap<>();
        response.put("name", "Mary Angeline B. Nono");
        response.put("studentId", "2025-1022691");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}
