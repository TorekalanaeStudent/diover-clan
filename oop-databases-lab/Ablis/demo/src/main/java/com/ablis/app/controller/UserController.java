package com.ablis.app.controller;

import com.ablis.app.entity.User;
import com.ablis.app.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // get all users
    @GetMapping
    public List<User> listUsers() {
        return userService.listAllUsers();
    }
    // get by id
    @GetMapping("/{id}")
    public ResponseEntity<User> readUser(@PathVariable Long id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // create user
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }
    // update user
    @PutMapping("/{id}")
    public ResponseEntity<User> modifyUser(@PathVariable Long id, @RequestBody User userData) {
        return userService.update(id, userData)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}