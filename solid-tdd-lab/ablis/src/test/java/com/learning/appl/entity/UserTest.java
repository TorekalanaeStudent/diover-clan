package com.learning.appl.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldCreateUserWithBuilder() {
        User user = User.builder()
                .id(1L)
                .username("freddy")
                .email("fnaf@mail.com")
                .password("mic")
                .build();

        assertEquals("freddy", user.getUsername());
    }
}