package com.arban.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
/**
 * MeController — Spring Boot REST Controller
 * Author: Arban, Jhave P.
 *
 * ============================================================
 * REFLECTION QUESTIONS
 * ============================================================
 *
 * 1. HOW DID YOU CREATE YOUR SPRING BOOT PROJECT?
 *    I created the project using Spring Initializr (https://start.spring.io).
 *    I selected Gradle as the build tool, Java as the language,
 *    and added the "Spring Web" dependency. After generating and
 *    downloading the ZIP, I extracted it and opened it in IntelliJ IDEA,
 *    which automatically recognized it as a Gradle project.
 *
 * 2. WHAT IS THE PURPOSE OF THE @RestController ANNOTATION?
 *    @RestController is a convenience annotation that combines
 *    @Controller and @ResponseBody. It tells Spring that this class
 *    handles incoming HTTP requests and that the return value of each
 *    method should be written directly to the HTTP response body
 *    (as JSON or plain text), rather than being resolved as a view name.
 *
 * 3. WHAT DOES THE @GetMapping("/me") ANNOTATION DO?
 *    @GetMapping("/me") maps HTTP GET requests made to the "/me"
 *    endpoint to the getMe() method. When a client accesses
 *    http://localhost:8080/me in a browser or API tool like Postman,
 *    Spring routes that request here and returns the method's output
 *    as the HTTP response.
 *
 * 4. WHY DID YOU CHANGE FROM RETURNING A STRING TO A MAP?
 *    Returning a plain String only sends raw unstructured text.
 *    By returning a Map<String, Object>, the response becomes
 *    structured key-value data that Spring Boot automatically
 *    serializes into proper JSON format. This is the standard
 *    expected by frontend applications, mobile clients, and
 *    any REST API consumer.
 *
 * 5. HOW DOES SPRING BOOT HANDLE JSON RESPONSES AUTOMATICALLY?
 *    Spring Boot includes the Jackson library by default via the
 *    spring-boot-starter-web dependency. When a @RestController
 *    method returns an object (like a Map or a custom class),
 *    Jackson automatically serializes it into a JSON string and
 *    sets the response Content-Type to "application/json".
 *    This is handled internally by Spring's HttpMessageConverter
 *    — no manual conversion code is needed.
 *
 * ============================================================
 */

@RestController
public class MeController {
    //@GetMapping("/me")
   // public String getMe(){
      //  return "Hello! I am Jhave P. Arban, a Basketball player!";
   // }
//}

    @GetMapping("/me")
    public Map<String,Object> getMe(){
        Map<String,Object> response = new HashMap<>();
        response.put("name", "Jhave P. Arban");
        response.put("studentId", "2025-1028156");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}