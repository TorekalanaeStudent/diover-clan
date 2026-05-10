package com.caneda.fullstack.controller;

import com.caneda.fullstack.entity.User;
import com.caneda.fullstack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // Handles HTTP requests and returns JSON
@RequestMapping("/api/users") // Base URL for all user endpoints
@CrossOrigin(origins = "http://localhost:5173") // Allow requests from React frontend
public class UserController {

    @Autowired // Injects the service automatically
    private UserService userService;

    // fetch all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // fetch one user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //  create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    //  update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.updateUser(id, user));
        } catch (RuntimeException e) {
            // Returns 404 if user not found
            return ResponseEntity.notFound().build();
        }
    }

    //  delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // get summary of one user
    @GetMapping("/{id}/summary")
    public Map<String, Object> getUserSummary(@PathVariable Long id) {
        return userService.getUserSummary(id);
    }

    // gets all users
    @GetMapping("/summaries")
    public List<Map<String, Object>> getAllUserSummaries() {
        return userService.getAllUserSummaries();
    }
}