package com.caneda.springboot.util;

import com.caneda.springboot.dto.UserRequestDTO;
import com.caneda.springboot.dto.UserResponseDTO;
import com.caneda.springboot.entity.User;

// GRASP: Pure Fabrication - doesn't represent a real world object
// exists purely to handle DTO conversion logic
// GRASP: Indirection - acts as layer between entity and DTO
public class UserMapper {

    // GRASP: Information Expert - mapper knows how to convert entity to DTO
    public static UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getUserName(),
                user.getUserEmail(),
                user.getUserAge(),
                user.getUserWalletAmount()
        );
    }

    // GRASP: Information Expert - mapper knows how to convert DTO to entity
    public static User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setUserEmail(dto.getUserEmail());
        user.setUserAge(dto.getUserAge());
        return user;
    }
}