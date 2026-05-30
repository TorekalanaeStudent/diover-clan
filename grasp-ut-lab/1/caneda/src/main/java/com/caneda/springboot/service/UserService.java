package com.caneda.springboot.service;

import com.caneda.springboot.dto.UserRequestDTO;
import com.caneda.springboot.dto.UserResponseDTO;
import com.caneda.springboot.entity.User;
import com.caneda.springboot.exception.UserNotFoundException;
import com.caneda.springboot.repository.UserRepository;
import com.caneda.springboot.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// GRASP: Pure Fabrication - doesn't represent a real world object
// exists purely to handle user business logic
// GRASP: High Cohesion - only handles user CRUD operations
// GRASP: Low Coupling - depends on repository interface not implementation
@Service
public class UserService {

    // GRASP: Indirection - repository acts as layer between service and DB
    @Autowired
    private UserRepository userRepository;

    // GRASP: Creator - service creates and returns user data
    public UserResponseDTO createUser(UserRequestDTO dto) {
        User saved = userRepository.save(UserMapper.toEntity(dto));
        return UserMapper.toResponseDTO(saved);
    }

    // GRASP: Information Expert - service delegates to user who owns the data
    public UserResponseDTO getUserById(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return UserMapper.toResponseDTO(user);
    }

    // GRASP: Information Expert - updates only what user owns
    public UserResponseDTO setUser(long id, UserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        user.setUserName(dto.getUserName());
        user.setUserEmail(dto.getUserEmail());
        user.setUserAge(dto.getUserAge());
        return UserMapper.toResponseDTO(userRepository.save(user));
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}