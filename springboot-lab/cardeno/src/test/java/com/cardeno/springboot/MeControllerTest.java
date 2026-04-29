package com.cardeno.springboot;

import com.cardeno.springboot.controller.MeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureWebMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * @author Cardeño, Faye L.
 * @flcardeno
 *
 * - Code-based Analysis -
 *
 * 1. How did you create your Spring Boot project?
 *  - I created my Spring Boot project using Spring Initializr.
 *
 * 2. What is the purpose of the @RestController annotation?
 *  - It means that this class is used for handling API requests and sending responses back.
 *
 * 3. What does the @GetMapping("/me") annotation do?
 *  - It means that when someone sends a GET request to /me, it will run the getMe() method and return its result.
 *
 * 4. Why did you change from returning a String to a Map?
 *  - I switched from String to Map to return structured data instead of plain text.
 *
 * 5. How does Spring Boot handle JSON responses automatically?
 *  - Spring Boot automatically turns Java objects like Map into JSON using Jackson, so I don’t have to manually convert it myself.
 *
 */
@SpringBootTest
@AutoConfigureWebMvc
public class MeControllerTest {

    @Autowired
    private MeController meController;

    private MockMvc mockMvc = standaloneSetup(meController).build();

    @Test
    public void testGetMe() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").exists());
    }
}
