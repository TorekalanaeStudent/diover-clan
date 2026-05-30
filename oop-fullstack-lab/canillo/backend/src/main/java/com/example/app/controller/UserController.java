package com.example.app.controller;

import com.example.app.entity.User;
import com.example.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestParam String username, @RequestParam String password, @RequestParam String email, @RequestParam String phoneNumber, @RequestParam boolean isAdmin) {
        return ResponseEntity.ok(userService.createStudent(username, password, email, phoneNumber, isAdmin));
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateStudent(@RequestParam Long id, @RequestParam String username, @RequestParam String password, @RequestParam String email, @RequestParam String phoneNumber, @RequestParam boolean isAdmin) {
        return ResponseEntity.ok(userService.updateStudent(id, username, password, email, phoneNumber, isAdmin));
    }

    @DeleteMapping("/")
    public ResponseEntity.BodyBuilder deleteStudent(@RequestBody Long id) {
        userService.deleteStudent(id);
        return ResponseEntity.accepted();
    }
}