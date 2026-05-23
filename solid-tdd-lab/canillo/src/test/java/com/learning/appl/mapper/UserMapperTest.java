package com.learning.appl.mapper;

import com.learning.appl.dto.request.UserRequest;
import com.learning.appl.dto.responses.UserResponse;
import com.learning.appl.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private final UserMapper mapper = new UserMapper();

    @Test
    void shouldMapToEntity() {
        UserRequest req = new UserRequest("a", "b", "c");

        User user = mapper.toEntity(req);

        assertEquals("a", user.getUsername());
        assertEquals("c", user.getEmail());
    }

    @Test
    void shouldMapToResponse() {
        User user = User.builder()
                .id(1L)
                .username("a")
                .email("b")
                .build();

        UserResponse res = mapper.toResponse(user);

        assertEquals("a", res.username());
    }
}