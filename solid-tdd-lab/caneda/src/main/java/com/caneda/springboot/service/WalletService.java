package com.caneda.springboot.service;

import com.caneda.springboot.dto.UserResponseDTO;
import com.caneda.springboot.entity.User;
import com.caneda.springboot.exception.UserNotFoundException;
import com.caneda.springboot.repository.UserRepository;
import com.caneda.springboot.util.UserMapper;
import com.caneda.springboot.service.interfaces.IWalletService;
import com.caneda.springboot.service.interfaces.WalletOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// SOLID: SRP - only handles wallet operations
// SOLID: DIP - implements IWalletService abstraction
// SOLID: OCP - new wallet operations added without modifying this class
// GRASP: Pure Fabrication - exists purely for wallet business logic
// GRASP: High Cohesion - only wallet related operations
@Service
public class WalletService implements IWalletService {

    // SOLID: DIP - depends on repository interface not implementation
    // GRASP: Indirection - repository acts as layer between service and DB
    @Autowired
    private UserRepository userRepository;

    // SOLID: SRP - validation delegated to UserValidationService
    @Autowired
    private UserValidationService validator;

    // SOLID: OCP - new operations added without modifying this method
    // SOLID: LSP - any WalletOperation implementation can substitute another
    // GRASP: Polymorphism - accepts any WalletOperation implementation
    // OOP: Composition Over Inheritance - uses WalletOperation via HAS-A not IS-A
    @Override
    public UserResponseDTO processWallet(long id, float amount, WalletOperation operation) {
        // DRY: reusing validation
        validator.validateId(id);
        validator.validateAmount(amount);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        // GRASP: Information Expert - user applies its own wallet update
        float newAmount = operation.execute(user.getUserWalletAmount());
        user.applyWalletAmount(newAmount);

        return UserMapper.toResponseDTO(userRepository.save(user));
    }
}