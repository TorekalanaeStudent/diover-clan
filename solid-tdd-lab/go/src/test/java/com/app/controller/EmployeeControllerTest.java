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
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// SOLID: SRP - Controller is tested in isolation, only responsible for HTTP request mapping
// GRASP: Controller role - handles request routing only, no business logic

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // SOLID: DIP - Service layer is mocked to avoid dependency on real business logic or database
    @MockBean
    private EmployeeService service;

    // -----------------------------------
    // CREATE EMPLOYEE SUCCESS
    // -----------------------------------
    @Test
    void shouldCreateEmployee() throws Exception {

        EmployeeResponseDTO response =
                new EmployeeResponseDTO(
                        1L,
                        "Seth",
                        6000
                );

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
                .andExpect(status().isOk())

                // OCP: Controller output format is independent of service implementation changes
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Seth"))
                .andExpect(jsonPath("$.salary").value(6000));

        verify(service, times(1))
                .createEmployee(any(EmployeeDTO.class));

        // DIP: Interaction verified through abstraction (EmployeeService)
    }

    // -----------------------------------
    // INVALID REQUEST TEST
    // -----------------------------------
    @Test
    void shouldReturnBadRequestForInvalidInput() throws Exception {

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                          "name": "",
                          "baseSalary": -5000,
                          "bonus": -1000
                        }
                        """))
                .andExpect(status().isBadRequest());

        // SRP: Controller only validates request structure, not business rules
        verify(service, never())
                .createEmployee(any(EmployeeDTO.class));

        // DIP: Ensures service is not invoked when input is invalid
    }

    // -----------------------------------
    // MISSING BODY TEST
    // -----------------------------------
    @Test
    void shouldReturnBadRequestWhenBodyMissing() throws Exception {

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isBadRequest());

        // EDGE CASE: Empty request body handling
        verify(service, never())
                .createEmployee(any(EmployeeDTO.class));

        // SRP: Controller rejects invalid HTTP request before reaching service layer
    }
}