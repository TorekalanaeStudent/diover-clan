package com.go.springboot.controller;

/*  Reflection
 *
 *  @author Go, Sean Ethan
 *  @sethplaysbadly
 *
 * 1. What changed from previous lab?
 * A: This lab replaced the prior lab with an actual database persistence with additional User/Product entities,
 *    repositories, services, and CRUD endpoints.
 *
 * 2. Why database is better?
 * A: You have the ability to easily store, update, and delete records without tampering with the source code,
 *    multiple users can read/write data at the same time; like an actual app with a server backend.
 *
 * 3. How JPA helped?
 * A: Switching databases required zero changes to your Java code and aides complex SQL
 *    into simple Java interfaces,
 *
 * 4. What changed when switching DB?
 * A: Only application.properties changed. To change it just comment out the H2 line
 *    and uncomment PostgreSQL lines.
 *
 */
import com.go.springboot.entity.User;
import com.go.springboot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET /api/users — fetch all users
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    // GET /api/users/{id} — fetch single user
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    // POST /api/users — create new user
    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }

    // PUT /api/users/{id} — update existing user
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.update(id, user));
    }

    // DELETE /api/users/{id} — delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}