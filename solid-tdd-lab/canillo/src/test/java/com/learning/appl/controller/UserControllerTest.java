package com.learning.appl.controller;

import com.learning.appl.dto.request.UserRequest;
import com.learning.appl.dto.responses.UserResponse;
import com.learning.appl.service.UserService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class UserControllerTest {

    private final UserService userService = mock(UserService.class);
    private final UserController userController = new UserController(userService);

    @Test
    void shouldReturnAllUsers() {

        // Arrange
        List<UserResponse> expected =
                List.of(new UserResponse(1L, "sigma", "sigma@mail.com"));

        when(userService.getUsers()).thenReturn(expected);

        // Act
        List<UserResponse> result = userController.getUser().getBody();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("sigma", result.getFirst().username());
        assertEquals("sigma@mail.com", result.getFirst().email());

        verify(userService).getUsers();
    }

    @Test
    void shouldCreateUserSigma() {

        // Arrange
        UserRequest req =
                new UserRequest("sigma", "password123", "sigma@mail.com");

        UserResponse expected =
                new UserResponse(1L, "sigma", "sigma@mail.com");

        when(userService.createUser(req)).thenReturn(expected);

        // Act
        UserResponse result = userController.createUser(req).getBody();

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.id());
        assertEquals("sigma", result.username());
        assertEquals("sigma@mail.com", result.email());

        verify(userService).createUser(req);
    }

    @Test
    void shouldUpdateUser() {

        // Arrange
        Long id = 1L;

        UserRequest req =
                new UserRequest("updated", "newpass", "updated@mail.com");

        UserResponse expected =
                new UserResponse(id, "updated", "updated@mail.com");

        when(userService.updateUser(id, req)).thenReturn(expected);

        // Act
        UserResponse result = userController.updateUser(id, req).getBody();

        // Assert
        assertNotNull(result);
        assertEquals("updated", result.username());
        assertEquals("updated@mail.com", result.email());

        verify(userService).updateUser(id, req);
    }

    @Test
    void shouldDeleteUser() {

        // Arrange
        Long id = 1L;

        doNothing().when(userService).deleteUser(id);

        // Act
        userController.deleteUser(id);

        // Assert
        verify(userService).deleteUser(id);
    }
}