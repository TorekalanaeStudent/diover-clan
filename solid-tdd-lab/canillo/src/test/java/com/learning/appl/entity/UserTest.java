package com.learning.appl.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldCreateUserWithBuilder() {
        User user = User.builder()
                .id(1L)
                .username("sigma")
                .email("s@mail.com")
                .password("pass")
                .build();

        assertEquals("sigma", user.getUsername());
    }
}