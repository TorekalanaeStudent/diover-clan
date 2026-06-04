package com.learning.appl.service;

import com.learning.appl.dto.request.UserRequest;
import com.learning.appl.dto.responses.UserResponse;
import com.learning.appl.entity.User;
import com.learning.appl.exceptions.UserNotFoundException;
import com.learning.appl.mapper.UserMapper;
import com.learning.appl.repository.UserRepository;
import com.learning.appl.service.Impl.UserServiceImpl;
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

    // create user using builder
    @Test
    void shouldCreateUser() {
        UserRequest req = new UserRequest("ambatukam", "pass2kam", "sussy@mail.com");

        User user = User.builder()
                .username("ambatukam")
                .password("pass2kam")
                .email("sussy@mail.com")
                .build();

        User saved = User.builder()
                .id(1L)
                .username("ambatukam")
                .email("sussy@mail.com")
                .build();

        when(userMapper.toEntity(req)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(saved);
        when(userMapper.toResponse(saved))
                .thenReturn(new UserResponse(1L, "ambatukam", "sussy@mail.com"));

        UserResponse result = userService.createUser(req);

        assertEquals("ambatukam", result.username());
    }

    // reads all list
    @Test
    void shouldReturnEmptyList() {
        when(userRepository.findAll()).thenReturn(List.of());

        List<UserResponse> result = userService.getUsers();

        assertTrue(result.isEmpty());
    }

    // reads by id
    @Test
    void shouldReturnUserById() {
        Long id = 1L;

        User user = User.builder()
                .id(id)
                .username("ambatukam")
                .email("sussy@mail.com")
                .build();

        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        when(userMapper.toResponse(user))
                .thenReturn(new UserResponse(id, "ambatukam", "sussy@mail.com"));

        UserResponse result = userService.getUserById(id);

        assertEquals("ambatukam", result.username());
    }

    // update user
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

    // bye bye user
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

    // exceptoon test
    @Test
    void shouldThrowWhenUserNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class,
                () -> userService.getUserById(1L));
    }

    // edge case
    @Test
    void shouldCreateEmptyList() {
        when(userRepository.saveAll(List.of())).thenReturn(List.of());

        List<UserResponse> result = userService.createUsers(List.of());

        assertTrue(result.isEmpty());
    }
}