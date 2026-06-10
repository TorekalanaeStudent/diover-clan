package com.caneda.springboot.controller;

import com.caneda.springboot.dto.UserRequestDTO;
import com.caneda.springboot.dto.UserResponseDTO;
import com.caneda.springboot.service.interfaces.IUserService;
import com.caneda.springboot.service.interfaces.IWalletService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext context;

    @MockitoBean
    private IUserService userService;

    @MockitoBean
    private IWalletService walletService;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void shouldGetUserById() throws Exception {
        UserResponseDTO response = new UserResponseDTO(1L, "John", "john@email.com", 20, 0f);
        when(userService.getUserById(1L)).thenReturn(response);

        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").value("John"));
    }

    @Test
    void shouldReturn404WhenUserNotFound() throws Exception {
        when(userService.getUserById(99L)).thenReturn(null);

        mockMvc.perform(get("/user/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldCreateUser() throws Exception {
        UserRequestDTO request = new UserRequestDTO("John", "john@email.com", 20);
        UserResponseDTO response = new UserResponseDTO(1L, "John", "john@email.com", 20, 0f);
        when(userService.createUser(any())).thenReturn(response);

        mockMvc.perform(post("/New/User")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").value("John"));
    }

    @Test
    void shouldUpdateUser() throws Exception {
        UserRequestDTO request = new UserRequestDTO("Jane", "jane@email.com", 21);
        UserResponseDTO response = new UserResponseDTO(1L, "Jane", "jane@email.com", 21, 0f);
        when(userService.setUser(eq(1L), any())).thenReturn(response);

        mockMvc.perform(put("/Modify/User/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").value("Jane"));
    }

    @Test
    void shouldReturn404WhenUpdateUserNotFound() throws Exception {
        UserRequestDTO request = new UserRequestDTO("Jane", "jane@email.com", 21);
        when(userService.setUser(eq(99L), any())).thenReturn(null);

        mockMvc.perform(put("/Modify/User/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldDeleteUser() throws Exception {
        doNothing().when(userService).deleteUser(1L);

        mockMvc.perform(delete("/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldAddWallet() throws Exception {
        UserResponseDTO response = new UserResponseDTO(1L, "John", "john@email.com", 20, 150f);
        when(walletService.processWallet(eq(1L), eq(50f), any())).thenReturn(response);

        mockMvc.perform(put("/user/1/wallet/add")
                        .param("amount", "50"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userWalletAmount").value(150f));
    }

    @Test
    void shouldDeductWallet() throws Exception {
        UserResponseDTO response = new UserResponseDTO(1L, "John", "john@email.com", 20, 50f);
        when(walletService.processWallet(eq(1L), eq(50f), any())).thenReturn(response);

        mockMvc.perform(put("/user/1/wallet/deduct")
                        .param("amount", "50"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userWalletAmount").value(50f));
    }

    @Test
    void shouldReturn404WhenWalletUserNotFound() throws Exception {
        when(walletService.processWallet(eq(99L), eq(50f), any())).thenReturn(null);

        mockMvc.perform(put("/user/99/wallet/add")
                        .param("amount", "50"))
                .andExpect(status().isNotFound());
    }
}