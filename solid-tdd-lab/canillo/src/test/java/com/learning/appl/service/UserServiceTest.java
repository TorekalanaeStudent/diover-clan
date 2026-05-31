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
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    // CREATE
    @Test
    void shouldCreateUser() {
        UserRequest req = new UserRequest("sigma", "pass", "s@mail.com");

        User user = User.builder()
                .username("sigma")
                .password("pass")
                .email("s@mail.com")
                .build();

        User saved = User.builder()
                .id(1L)
                .username("sigma")
                .email("s@mail.com")
                .build();

        when(userMapper.toEntity(req)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(saved);
        when(userMapper.toResponse(saved))
                .thenReturn(new UserResponse(1L, "sigma", "s@mail.com"));

        UserResponse result = userService.createUser(req);

        assertEquals("sigma", result.username());
    }

    // READ ALL
    @Test
    void shouldReturnEmptyList() {
        when(userRepository.findAll()).thenReturn(List.of());

        List<UserResponse> result = userService.getUsers();

        assertTrue(result.isEmpty());
    }

    // READ BY ID
    @Test
    void shouldReturnUserById() {
        Long id = 1L;

        User user = User.builder()
                .id(id)
                .username("sigma")
                .email("s@mail.com")
                .build();

        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        when(userMapper.toResponse(user))
                .thenReturn(new UserResponse(id, "sigma", "s@mail.com"));

        UserResponse result = userService.getUserById(id);

        assertEquals("sigma", result.username());
    }

    // UPDATE
    @Test
    void shouldUpdateUser() {
        Long id = 1L;

        User user = User.builder()
                .id(id)
                .username("old")
                .email("old@mail.com")
                .password("oldpass")
                .build();

        UserRequest req = new UserRequest("new", "newpass", "new@mail.com");

        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        when(userRepository.save(any())).thenReturn(user);
        when(userMapper.toResponse(any()))
                .thenReturn(new UserResponse(id, "new", "new@mail.com"));

        UserResponse result = userService.updateUser(id, req);

        assertEquals("new", result.username());
    }

    // DELETE
    @Test
    void shouldDeleteUser() {
        Long id = 1L;

        User user = User.builder()
                .id(id)
                .build();

        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        doNothing().when(userRepository).delete(user);

        userService.deleteUser(id);

        verify(userRepository).delete(user);
    }

    // EXCEPTION TEST
    @Test
    void shouldThrowWhenUserNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class,
                () -> userService.getUserById(1L));
    }

    // EDGE CASE
    @Test
    void shouldCreateEmptyList() {
        when(userRepository.saveAll(List.of())).thenReturn(List.of());

        List<UserResponse> result = userService.createUsers(List.of());

        assertTrue(result.isEmpty());
    }
}