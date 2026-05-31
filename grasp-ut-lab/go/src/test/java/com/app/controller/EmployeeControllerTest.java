package com.app.controller;

import com.app.dto.EmployeeDTO;
import com.app.dto.EmployeeResponseDTO;
import com.app.service.EmployeeService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// I need more imports sir, need more imports, they will not know my power. i need more boolets, bigger weapons, bigger weapons, thanks for the protein sir

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    @Test
    void shouldCreateEmployee() throws Exception {

        EmployeeResponseDTO response =
                new EmployeeResponseDTO(1L, "Seth", 5000);

        when(service.createEmployee(any(EmployeeDTO.class)))
                .thenReturn(response);

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                          "name": "Seth",
                          "baseSalary": 5000,
                          "bonus": 1000
                        }
                        """))
                .andExpect(status().isOk());
    }
}