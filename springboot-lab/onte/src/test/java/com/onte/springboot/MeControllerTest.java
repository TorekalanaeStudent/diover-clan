package com.onte.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureWebMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * How did you create your Spring Boot project?
 * - I created the springboot project using the Spring Iniatializr to generate the gradle structure and dependencies.
 *
 * What is the purpose of the @RestController annotation?
 * - The purpose of the @RestController annotation is to identify the class as a web handler that automattically
 * return objects directly as HTTP.
 *
 * What does the @GetMapping("/me") annotation do?
 * - It maps the HTTP("/me") get request.
 *
 * Why did you change from returning a String to a Map?
 * - It allows the API to return structured key value rather than a simple unorganized string.
 *
 * How does Spring Boot handle JSON responses automatically?
 *  - Springboot uses the JSON library to automatically convert Java into JSON format.
 */

@SpringBootTest
@AutoConfigureWebMvc
public class MeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetMe() throws Exception {
        mockMvc.perform(get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").exists());
    }
}
