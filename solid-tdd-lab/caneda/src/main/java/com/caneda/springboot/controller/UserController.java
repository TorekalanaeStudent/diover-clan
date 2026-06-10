package com.caneda.springboot.controller;

import com.caneda.springboot.dto.UserRequestDTO;
import com.caneda.springboot.dto.UserResponseDTO;
import com.caneda.springboot.service.AddWalletOperation;
import com.caneda.springboot.service.DeductWalletOperation;
import com.caneda.springboot.service.interfaces.IUserService;
import com.caneda.springboot.service.interfaces.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// SOLID: SRP - only handles HTTP request/response mapping
// SOLID: DIP - depends on IUserService and IWalletService abstractions
// GRASP: Controller - handles HTTP requests only
// GRASP: Low Coupling - depends on interfaces not concrete classes
@RestController
public class UserController {

    // SOLID: DIP - depends on interface not concrete UserService
    // DIP: Depends on abstraction instead of implementation
    @Autowired
    private IUserService userService;

    // SOLID: DIP - depends on interface not concrete WalletService
    @Autowired
    private IWalletService walletService;

    // GRASP: Controller - delegates to service, no logic here
    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable long id) {
        UserResponseDTO user = userService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // GRASP: Creator - controller initiates user creation via service
    @PostMapping("/New/User")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @PutMapping("/Modify/User/{id}")
    public ResponseEntity<UserResponseDTO> setUser(
            @PathVariable long id,
            @RequestBody UserRequestDTO dto) {
        UserResponseDTO updated = userService.setUser(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // SOLID: OCP - new wallet operations added without modifying controller
    // SOLID: LSP - AddWalletOperation substitutes WalletOperation correctly
    // GRASP: Polymorphism - controller decides which operation to pass
    @PutMapping("/user/{id}/wallet/add")
    public ResponseEntity<UserResponseDTO> addWallet(
            @PathVariable long id,
            @RequestParam float amount) {
        UserResponseDTO updated = walletService.processWallet(
                id, amount, new AddWalletOperation(amount)
        );
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // SOLID: LSP - DeductWalletOperation substitutes WalletOperation correctly
    @PutMapping("/user/{id}/wallet/deduct")
    public ResponseEntity<UserResponseDTO> deductWallet(
            @PathVariable long id,
            @RequestParam float amount) {
        UserResponseDTO updated = walletService.processWallet(
                id, amount, new DeductWalletOperation(amount)
        );
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
}