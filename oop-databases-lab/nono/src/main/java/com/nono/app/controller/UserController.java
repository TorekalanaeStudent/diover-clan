package com.nono.app.controller;

import com.nono.app.entity.User;
import com.nono.app.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Author Mary Angeline B. Nono
* 
* 1.What changed from previous lab?
* -I moved from simple file handling or basic code to working with real databases. We learned how to connect our Spring Boot application to store and retrieve data properly, instead of just using variables or temporary memory.
* 
* 2. Why database is better?
* - Data stays forever: Data is saved permanently even if we close the program.
* - Organized: Information is stored in neat tables with rows and columns, making it easy to find.
* - Safe & Secure: We can control who accesses the data and prevent mistakes.
* - Handles large amounts: It can store thousands or millions of records easily without slowing down.
*
* 3.How JPA helped?
*  -JPA (Java Persistence API) made our work much easier. Instead of writing long and complicated SQL queries manually, we just used Java code and annotations. It automatically created tables, inserted data, and handled connections for us. It saved a lot of time and reduced errors.
*
* 4.What changed when switching DB?
*-When we switched from H2 to PostgreSQL:
* - We had to change the URL, username, and password in  application.properties .
*- We added the correct PostgreSQL Driver dependency.
*- The way we write code stayed almost the same because JPA works with many databases. Only the configuration part changed.
**/

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getGamer(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> createGamer(@Valid @RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateGamer(@PathVariable Long id, @Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGamer(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build(); // 204 error
    }
}
