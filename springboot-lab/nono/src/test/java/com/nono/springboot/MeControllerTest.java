package com.nono.springboot;

import com.nono.springboot.controller.MeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

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

@SpringBootTest
@AutoConfigureWebMvc
public class MeControllerTest {

    @Autowired
    private MeController Controller;

    private MockMvc mockMvc = standaloneSetup(Controller).build();

    @Test
    public void testGetMe() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").exists());
    }
}
