package com.jagunap.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Jagunap, Janelle
 *
 * 1.How did you create your Spring Boot project?
 * Answer: I created my Spring Boot project using Gradle in IntelliJ IDEA.
 * The project includes the Spring Web dependency so I can build REST APIs.
 * 2.What is the purpose of the @RestController annotation?
 * Answer: @RestController is used to tell Spring Boot that a class is a REST controller.
 *  Its purpose is to mark the class as a controller that handles HTTP requests
 *  and automatically return data (like JSON or text) instead of HTML pages
 * 3.What does the @GetMapping("/me") annotation do?
 * Answer: @GetMapping("/me") maps an HTTP GET request to a specific method.
 * 4.Why did you change from returning a String to a Map?
 * aNSWER: I first returned a String to test if the endpoint was working: (return "Hello, I am Janelle Jagunap";)
 * 5.How does Spring Boot handle JSON responses automatically?
 * Answer:Spring Boot automatically converts Java objects to JSON using Jackson, which is included in spring-boot-starter-web.
 */

@RestController
public class MeController {

  //   @GetMapping("/me")
 // public String me() {
 //       return "Hello, I am Janelle Jagunap. I love cats :)";
 //}
  @GetMapping("/me")
  public Map<String, Object> getMe() {
      Map<String, Object> response = new HashMap<>();
      response.put("name", "Jagunap Janelle");
      response.put("studentId", "2025-1025460");
      response.put("course", "Object-Oriented Programming");
      response.put("message", "Learning Spring Boot REST APIs!");
      return response;
  }
}