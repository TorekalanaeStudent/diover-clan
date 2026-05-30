package com.obedoza.springboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 Answer inside your code comments:
 1. How did you create your Spring Boot project?
 Answer: I created it by downloading the Spring Initializr with the specified configuration, and used maven
 alongside java 17 with the spring web dependency.

 2. What is the purpose of the @RestController annotation?
 Answer: It tells Spring that this class will handle web requests and return data (like JSON).
 Without it, Spring won't know this class is meant to respond to HTTP requests.

 3. What does the @GetMapping("/me") annotation do?
 Answer: It listend to the GET request on the URL of "/me". When someone visits http://localhost:8080/me, this method runs.

 4. Why did you change from returning a String to a Map?
 Answer: A string only retuns plain text, while a map return proper JSON, which is easier
 for other apps to read.

 5. How does Spring Boot handle JSON responses automatically?
 Answer: Springboot has a built-in library called Jackson and this converts Java objects into JSON.

 */


@SpringBootTest
@AutoConfigureMockMvc
public class MeControllerTest {

    // Spring injects MockMvc bean automatically
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetMe() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").exists());
    }
}
