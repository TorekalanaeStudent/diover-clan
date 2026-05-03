package com.go.springboot.service;
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
import com.go.springboot.exception.ResourceNotFoundException;
import com.go.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Business logic layer — separates concerns from controller
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User updated) {
        User user = getById(id);
        // Only update fields that are provided
        if (updated.getName() != null) user.setName(updated.getName());
        if (updated.getEmail() != null) user.setEmail(updated.getEmail());
        if (updated.getPhoneNumber() != null) user.setPhoneNumber(updated.getPhoneNumber());
        if (updated.getRole() != null) user.setRole(updated.getRole());
        user.setRegular(updated.isRegular());
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(getById(id));
    }
}