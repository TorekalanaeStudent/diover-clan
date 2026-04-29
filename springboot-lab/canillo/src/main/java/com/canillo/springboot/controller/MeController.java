package com.canillo.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author TorekalanaeStudent
 *
 * Q1: How did you create your Spring Boot project?
 * A1: I created my Spring Boot project using the spring initializr
 *
 * Q2: What is the purpose of the @RestController annotation?
 * A2: The purpose of RestController annotation is that so the class knows that it is a rest controller that will contain rest apis
 *
 * Q3: What does the @GetMapping("/me") annotation do?
 * A3: The GetMapping("/me") annotation basically means that it will return a value and will be accessible inside the "/me" method
 *
 * Q4: Why did you change from returning a String to a Map?
 * A4: Because the Map specifically the HashMap has Keys and Values that will be useful in calling the @GetMapping("/me"), makes it easier to read and also you know what the key and values are
 *
 * Q5: How does Spring Boot handle JSON responses automatically?
 * A5: Spring Boot handles JSON because it includes Jackson Library by default
 */

@RestController
public class MeController {

//    @GetMapping("/me")
//    public String getMe(){
//        return "Hello! I am Diover Vincent L. Canillo, a gamer!";
//    }

    @GetMapping("/me")
    public Map<String,Object> getMe(){
        Map<String,Object> response = new HashMap<>();
        response.put("name", "Diover Vincent L. Canillo");
        response.put("studentId", "2025-1023980");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}

