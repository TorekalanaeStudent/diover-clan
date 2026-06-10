package com.caneda.springboot.service;

import com.caneda.springboot.dto.UserRequestDTO;
import com.caneda.springboot.dto.UserResponseDTO;
import com.caneda.springboot.entity.User;
import com.caneda.springboot.exception.UserNotFoundException;
import com.caneda.springboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    // SOLID: DIP - mocking repository interface not implementation
    @Mock
    private UserRepository userRepository;

    // SOLID: DIP - mocking validation service
    @Mock
    private UserValidationService validator;

    // SOLID: DIP - testing through IUserService abstraction
    @InjectMocks
    private UserService userService;

    @Test
    void shouldCreateUser() {
        // Arrange
        UserRequestDTO dto = new UserRequestDTO("John", "john@email.com", 20);
        User savedUser = new User(1L, "John", "john@email.com", 20, 0f);
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        // Act
        UserResponseDTO result = userService.createUser(dto);

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getUserName());
        assertEquals("john@email.com", result.getUserEmail());
        assertEquals(20, result.getUserAge());

        // DIP proof: verify validation was called
        verify(validator, times(1)).validateUserRequest(dto);
    }

    @Test
    void shouldGetUserById() {
        // Arrange
        User user = new User(1L, "John", "john@email.com", 20, 0f);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Act
        UserResponseDTO result = userService.getUserById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getUserName());

        // DIP proof: verify validation was called
        verify(validator, times(1)).validateId(1L);
    }

    @Test
    void shouldThrowWhenUserNotFound() {
        // Arrange
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserNotFoundException.class, () ->
                userService.getUserById(99L)
        );
    }

    @Test
    void shouldUpdateUser() {
        // Arrange
        User existing = new User(1L, "John", "john@email.com", 20, 0f);
        User updated = new User(1L, "Jane", "jane@email.com", 21, 0f);
        UserRequestDTO dto = new UserRequestDTO("Jane", "jane@email.com", 21);

        when(userRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(userRepository.save(any(User.class))).thenReturn(updated);

        // Act
        UserResponseDTO result = userService.setUser(1L, dto);

        // Assert
        assertNotNull(result);
        assertEquals("Jane", result.getUserName());

        // DIP proof: verify both validations were called
        verify(validator, times(1)).validateId(1L);
        verify(validator, times(1)).validateUserRequest(dto);
    }

    @Test
    void shouldDeleteUser() {
        // Arrange
        doNothing().when(userRepository).deleteById(1L);

        // Act
        userService.deleteUser(1L);

        // Assert
        verify(userRepository, times(1)).deleteById(1L);

        // DIP proof: verify validation was called
        verify(validator, times(1)).validateId(1L);
    }
}