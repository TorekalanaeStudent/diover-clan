package com.caneda.springboot.controller;

import com.caneda.springboot.dto.UserRequestDTO;
import com.caneda.springboot.dto.UserResponseDTO;
import com.caneda.springboot.service.AddWalletOperation;
import com.caneda.springboot.service.DeductWalletOperation;
import com.caneda.springboot.service.UserService;
import com.caneda.springboot.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// GRASP: Controller - handles incoming HTTP requests only
// delegates all business logic to service layer
// GRASP: Low Coupling - depends on service interfaces not implementations
@RestController
public class UserController {

    // GRASP: Low Coupling - injected via interface
    @Autowired
    private UserService userService;

    @Autowired
    private WalletService walletService;

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

    // GRASP: Polymorphism - controller decides which wallet operation to pass
    @PutMapping("/user/{id}/wallet/add")
    public ResponseEntity<UserResponseDTO> addWallet(
            @PathVariable long id,
            @RequestParam float amount) {
        UserResponseDTO updated = walletService.processWallet(id, amount, new AddWalletOperation(amount));
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // GRASP: Polymorphism - different operation, same method call
    @PutMapping("/user/{id}/wallet/deduct")
    public ResponseEntity<UserResponseDTO> deductWallet(
            @PathVariable long id,
            @RequestParam float amount) {
        UserResponseDTO updated = walletService.processWallet(id, amount, new DeductWalletOperation(amount));
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
}