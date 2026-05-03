package com.go.springboot;

/* Code-Based Analysis
 *
 *  @author Go, Sean Ethan
 *  @sethplaysbadly
 *
 * 1. How did you create your Spring Boot project?
 * A: I created the project using Spring Initializr (start.spring.io), selecting Gradle, Java 21, and the Spring Web dependency.
 *
 * 2. What is the purpose of the @RestController annotation?
 * A: The @RestController annotation is used to build RESTful web services by combining @Controller and @ResponseBody in one annotation.
 *
 * 3. What does the @GetMapping("/me") annotation do?
 * A: The @GetMapping("/me") annotation maps HTTP GET requests to the /me endpoint.
 *
 * 4. Why did you change from returning a String to a Map?
 * A: I changed it from returning a String to a Map because Task 6 required a structured JSON response instead of plain text.
 *
 * 5. How does Spring Boot handle JSON responses automatically?
 * A: Spring Boot uses the Jackson library by default to automatically convert Java objects and maps into JSON format.
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