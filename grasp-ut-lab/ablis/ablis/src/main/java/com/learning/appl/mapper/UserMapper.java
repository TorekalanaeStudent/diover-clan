package com.learning.appl.mapper;

import com.learning.appl.dto.request.UserRequest;
import com.learning.appl.dto.responses.UserResponse;
import com.learning.appl.entity.User;
import org.springframework.stereotype.Component;

// this mapper handles the transferring of the data
@Component
public class UserMapper {

    // dto to entity - request
    public User toEntity(UserRequest request) {
        User user = new User();
        user.setUsername(request.username());
        user.setPassword(request.password());
        user.setEmail(request.email());
        return user;
    }

    // entity to dto - response
    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}
