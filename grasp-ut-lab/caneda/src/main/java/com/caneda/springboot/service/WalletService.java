package com.caneda.springboot.service;

import com.caneda.springboot.dto.UserResponseDTO;
import com.caneda.springboot.entity.User;
import com.caneda.springboot.exception.UserNotFoundException;
import com.caneda.springboot.repository.UserRepository;
import com.caneda.springboot.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// GRASP: Pure Fabrication - exists purely for wallet business logic
// GRASP: High Cohesion - only handles wallet related operations
// GRASP: Low Coupling - depends on repository interface not implementation
@Service
public class WalletService {

    // GRASP: Indirection - repository acts as layer between service and DB
    @Autowired
    private UserRepository userRepository;

    // GRASP: Polymorphism - accepts any WalletOperation implementation
    // GRASP: Indirection - acts as layer between controller and wallet operations
    public UserResponseDTO processWallet(long id, float amount, WalletOperation operation) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        // GRASP: Information Expert - user validates its own balance
        float newAmount = operation.execute(user.getUserWalletAmount());

        // GRASP: Information Expert - user applies its own wallet update
        user.applyWalletAmount(newAmount);

        return UserMapper.toResponseDTO(userRepository.save(user));
    }
}