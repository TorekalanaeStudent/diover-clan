package com.learning.appl.service;

import com.learning.appl.dto.request.UserRequest;
import com.learning.appl.dto.responses.UserResponse;
import com.learning.appl.entity.User;
import com.learning.appl.exceptions.UserNotFoundException;
import com.learning.appl.mapper.UserMapper;
import com.learning.appl.repository.UserRepository;
import com.learning.appl.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserMapper userMapper;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void shouldCreateSigmaUser(){

        // Arrange
        UserRequest req = new UserRequest("sigma", "sigmaPassword", "sigma@male.com");

        User user = new User();
        user.setUsername("sigma");
        user.setPassword("sigmaPassword");
        user.setEmail("sigma@male.com");

        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setUsername("sigma");
        savedUser.setEmail("sigma@male.com");

        when(userMapper.toEntity(req)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(savedUser);
        when(userMapper.toResponse(savedUser)).thenReturn(new UserResponse(1L, "sigma", "sigma@male.com"));

        // Act
        UserResponse response = userService.createUser(req);

        // Assert
        assertEquals(1L, response.id());
        assertEquals("sigma", response.username());
        assertEquals("sigma@male.com", response.email());
    }

    @Test
    void shouldReturnEmptyList() {
        when(userRepository.findAll()).thenReturn(List.of());

        List<UserResponse> result = userService.getUsers();

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldThrowWhenUserNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class,() -> userService.getUserById(1L));
    }

    @Test
    void shouldUpdateUserToSigmaUpdated() {

        // Arrange
        Long id = 1L;

        User existingUser = new User();
        existingUser.setId(id);
        existingUser.setUsername("old");
        existingUser.setEmail("old@mail.com");

        UserRequest req = new UserRequest("SigmaUpdated", "newpass","sigma@updated.com");

        User savedUser = new User();
        savedUser.setId(id);
        savedUser.setUsername("SigmaUpdated");
        savedUser.setEmail("sigma@updated.com");

        when(userRepository.findById(id)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        when(userMapper.toResponse(savedUser)).thenReturn(new UserResponse(id, "SigmaUpdated", "sigma@updated.com"));

        // Act
        UserResponse result = userService.updateUser(id, req);

        // Assert
        assertEquals("SigmaUpdated", result.username());
        assertEquals("sigma@updated.com", result.email());
    }

    @Test
    void shouldDeleteUser() {
        Long id = 1L;

        User user = new User();
        user.setId(id);

        when(userRepository.findById(id))
                .thenReturn(Optional.of(user));

        doNothing().when(userRepository).delete(user);

        userService.deleteUser(id);

        verify(userRepository).delete(user);
    }

}
