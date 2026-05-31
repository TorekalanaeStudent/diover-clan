package com.learning.appl.controller;

import com.learning.appl.dto.request.UserRequest;
import com.learning.appl.dto.responses.UserResponse;
import com.learning.appl.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
@RequiredArgsConstructor
@RestController
public class UserController {

    // controller only handles HTTP 

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUser() {
        List<UserResponse> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<UserResponse>> createUsers(@RequestBody @Valid List<UserRequest> reqs) {
        List<UserResponse> responses = userService.createUsers(reqs);
        return ResponseEntity.status(201).body(responses);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest req) {
        UserResponse response = userService.createUser(req);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequest req) {
        UserResponse response = userService.updateUser(id, req);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
