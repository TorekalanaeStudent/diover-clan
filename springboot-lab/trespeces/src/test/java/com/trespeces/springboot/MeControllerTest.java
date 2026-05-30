package com.trespeces.springboot;

import com.trespeces.springboot.controller.MeController;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Trespeces, Guillermo II O.
 * @willj067
 *
 * 1. How did you create your Spring Boot project?
 *    I used Spring Initializr at start.spring.io to generate the project,
 *    added Spring Web as a dependency, downloaded the ZIP and extracted it.
 *
 * 2. What is the purpose of the @RestController annotation?
 *    @RestController tells Spring that this class will handle web requests
 *    and return data directly, not a webpage.
 *
 * 3. What does the @GetMapping("/me") annotation do?
 *    @GetMapping("/me") means when someone does a GET request to /me,
 *    this method will run and return the response.
 *
 * 4. Why did you change from returning a String to a Map?
 *    I switched to Map because it lets Spring automatically format the
 *    response as JSON, which is more useful than plain text.
 *
 * 5. How does Spring Boot handle JSON responses automatically?
 *    Spring Boot automatically converts the Map into JSON when it sees
 *    that the method returns an object. I didn't have to do anything extra.
 */

public class MeControllerTest {

    private MeController meController = new MeController();
    private MockMvc mockMvc = standaloneSetup(meController).build();

    @Test
    public void testGetMe() throws Exception {
        mockMvc.perform(get("/me"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").exists());
    }
}