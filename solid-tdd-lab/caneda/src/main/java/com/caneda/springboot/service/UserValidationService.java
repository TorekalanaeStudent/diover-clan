package com.caneda.springboot.service;

import com.caneda.springboot.dto.UserRequestDTO;
import org.springframework.stereotype.Service;

// SOLID: SRP - only handles validation logic, nothing else
// DRY: centralized validation — no duplicate checks across services
// KISS: simple, focused, single-purpose methods
@Service
public class UserValidationService {

    // DRY: reusable ID validation used by both UserService and WalletService
    public void validateId(long id) {
       if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
          }

    // DRY: reusable request body validation
    public void validateUserRequest(UserRequestDTO dto) {
        // Edge case: null DTO
        if (dto == null) {
            throw new IllegalArgumentException("User data cannot be null");
        }
        // Edge case: empty username
        if (dto.getUserName() == null || dto.getUserName().isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        // Edge case: empty email
        if (dto.getUserEmail() == null || dto.getUserEmail().isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        // Edge case: invalid age
        if (dto.getUserAge() <= 0) {
            throw new IllegalArgumentException("Age must be positive");
        }
    }

    // DRY: reusable amount validation used by WalletService
    public void validateAmount(float amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }
}