//Created by Cantela, Chris Nelson B.

// Test class for MeController using MockMvc

package com.ovejera.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Integration test for the Spring Boot app
@SpringBootTest
@AutoConfigureMockMvc
public class MeControllerTest {

    @Autowired
    private MockMvc mockMvc; // Mock MVC for testing endpoints

    @Test
    public void testGetMe() throws Exception {
        // Perform GET request to /me and verify response
        mockMvc.perform(get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").exists());
    }
}
