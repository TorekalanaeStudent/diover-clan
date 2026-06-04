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
        UserRequest req = new UserRequest("bonnie", "Only@100", "BonnieAsul@gmail.com");

        User user = mapper.toEntity(req);

        assertEquals("bonnie", user.getUsername());
        assertEquals("BonnieAsul@gmail.com", user.getEmail());
    }

    @Test
    void shouldMapToResponse() {
        User user = User.builder()
                .id(1L)
                .username("bonnie")
                .email("BonnieAsul@gmail.com")
                .build();

        UserResponse res = mapper.toResponse(user);

        assertEquals("bonnie", res.username());
    }
}