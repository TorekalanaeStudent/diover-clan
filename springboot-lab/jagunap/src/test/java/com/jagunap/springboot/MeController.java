package com.jagunap.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureWebMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

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
@SpringBootTest
@AutoConfigureWebMvc
public class MeController {

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
