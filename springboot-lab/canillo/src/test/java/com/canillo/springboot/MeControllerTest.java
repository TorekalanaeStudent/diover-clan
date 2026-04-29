package com.canillo.springboot;

import com.canillo.springboot.controller.MeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureWebMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

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

@SpringBootTest
@AutoConfigureWebMvc
public class MeControllerTest {

    @Autowired
    private MeController controller;

    private MockMvc mockMvc = standaloneSetup(controller).build();

    @Test
    public void testGetMe() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").exists());
    }
}
