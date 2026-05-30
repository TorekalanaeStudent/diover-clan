package com.learning.appl.mapper;

import com.learning.appl.dto.request.UserRequest;
import com.learning.appl.dto.responses.UserResponse;
import com.learning.appl.entity.User;
import org.springframework.stereotype.Component;

// GRASP: Creator - UserMapper class is responsible for creating User objects
// Dependency Inversion
// Open/Closed Principle: can be extended without modifying service
@Component
public class UserMapper {

    // dto to entity
    public User toEntity(UserRequest request) {
        return User.builder()
                .username(request.username())
                .password(request.password())
                .email(request.email())
                .build();
    }

    // entity to dto
    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}
