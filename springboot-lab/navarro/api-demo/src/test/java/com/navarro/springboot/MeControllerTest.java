package com.navarro.springboot;

// Code-Based Analysis
/**
 *  @author Navarro, Vince Justine
 *  @StillLizard0106
 *
 * 1. How did you create your Spring Boot project?
 * A: I created it by using Spring Initializr (start.spring.io) with Gradle and Java 21 using the Spring Web Dependency.
 *
 * 2. What is the purpose of the @RestController annotation?
 * A: It's used to create RESTful web services by combining @Controller and @ResponseBody.
 *
 * 3. What does the @GetMapping("/me") annotation do?
 * A:  It's used in REST controllers to map HTTP GET requests specifically for the path /me
 *
 * 4.Why did you change from returning a String to a Map?
 * A: Because in Task 6, I was required to return structured JSON instead of plain text.
 *
 * 5. How does Spring Boot handle JSON responses automatically?
 * A: Spring Boot includes Jackson Library by default, which basically converts Java objects and maps into JSON format.
 *
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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