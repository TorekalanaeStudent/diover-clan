package com.caneda.springboot;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
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



@SpringBootTest
@AutoConfigureMockMvc
public class MeController {

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


