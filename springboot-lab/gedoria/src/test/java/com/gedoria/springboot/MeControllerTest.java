package com.gedoria.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureWebMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MeControllerTest {

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
/*
 *
 *
 * @Author rajangedoria-ctrl
 *
 * How did you create your Spring Boot project?
 * Using spring initializr
 * What is the purpose of the @RestController annotation?
 * Tells the class it is meant to handle HTTP requests and return data (shortcut to @Controller and @ResponseBody)
 * What does the @GetMapping("/me") annotation do?
 * When a client sends a GET request to /me, this will run
 * Why did you change from returning a String to a Map?
 * It is easier and allows multiple fields instead of just one string
 * How does Spring Boot handle JSON responses automatically?
 * When a method returns a Java object, it converts that object into a JSON when it sees the @RestController annotation
 */
