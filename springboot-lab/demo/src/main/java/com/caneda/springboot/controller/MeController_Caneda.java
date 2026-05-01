package com.caneda.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;

/**
 * @Author Rcaneda
 *
 * Q1 How did you create your Spring Boot project?
 * - I used Spring intializer to start the forefront of the projects, that gave me the file structure and layout
 *
 * Q2 What is the purpose of the @RestController annotation?
 * - It is used to tell that it is first a restcontroller, and its used for handling HTTP request that process the controller request, and gives the after business logic has happened
 *
 * Q3 What does the @GetMapping("/me") annotation do?
 * -It acts as a sign to tell the system where to find the information using that endpoint
 *
 * Q4 Why did you change from returning a String to a Map?
 * -Map works well by showing a fully written structure that can be moddified with JSON properties, while string itself would just return a plain text version
 *
 * Q5 How does Spring Boot handle JSON responses automatically?
 * -It's due to the default Jackson Library acting as a near middle man between spring boot and JSON responses
 */


@RestController
public class MeController_Caneda {

  //  @GetMapping("/me")
   // public String getMe() {
    //    return "hello! i am Ramil Caneda Jr";
    //}

    @GetMapping("/me")
    public Map<String,Object> getMe() {
        Map<String,Object> response = new HashMap<>();
        response.put("Name", "Ramil m Caneda Jr");
        response.put("Student Id", "2025-1020773");
        response.put("Course", "BSCS");
        response.put("Message", "Learning this a few hours before deadline");
        return response;
    }
}


