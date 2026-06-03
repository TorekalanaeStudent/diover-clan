package com.caneda.springboot.service;

import com.caneda.springboot.dto.UserRequestDTO;
import com.caneda.springboot.dto.UserResponseDTO;
import com.caneda.springboot.entity.User;
import com.caneda.springboot.exception.UserNotFoundException;
import com.caneda.springboot.repository.UserRepository;
import com.caneda.springboot.util.UserMapper;
import com.caneda.springboot.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// SOLID: SRP - only handles user CRUD business logic
// SOLID: DIP - implements IUserService abstraction
// SOLID: OCP - new behavior added via new implementations not modifying this
// GRASP: Pure Fabrication - exists purely for business logic
// GRASP: High Cohesion - only user related operations
// GRASP: Low Coupling - depends on repository interface not implementation
@Service
public class UserService implements IUserService {

    // SOLID: DIP - depends on repository interface not implementation
    // GRASP: Indirection - repository acts as layer between service and DB
    @Autowired
    private UserRepository userRepository;

    // SOLID: SRP - validation delegated to UserValidationService
    // DRY: reusing validation instead of duplicating checks
    @Autowired
    private UserValidationService validator;

    // SOLID: OCP - creating users without modifying existing logic
    // GRASP: Creator - service creates and returns user data
    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        // DRY: reusing validation
        validator.validateUserRequest(dto);
        User saved = userRepository.save(UserMapper.toEntity(dto));
        return UserMapper.toResponseDTO(saved);
    }

    // SOLID: SRP - only retrieves user data
    // GRASP: Information Expert - delegates to user who owns the data
    @Override
    public UserResponseDTO getUserById(long id) {
        // DRY: reusing validation
        validator.validateId(id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return UserMapper.toResponseDTO(user);
    }

    // SOLID: SRP - only handles user update logic
    // GRASP: Information Expert - updates only what user owns
    @Override
    public UserResponseDTO setUser(long id, UserRequestDTO dto) {
        // DRY: reusing validation
        validator.validateId(id);
        validator.validateUserRequest(dto);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        user.setUserName(dto.getUserName());
        user.setUserEmail(dto.getUserEmail());
        user.setUserAge(dto.getUserAge());
        return UserMapper.toResponseDTO(userRepository.save(user));
    }

    // SOLID: SRP - only handles deletion
    @Override
    public void deleteUser(long id) {
        // DRY: reusing validation
        validator.validateId(id);
        userRepository.deleteById(id);
    }
}