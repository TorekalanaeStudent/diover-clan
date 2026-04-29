package com.navarro.springboot.service;
// Reflection
/**
 *  @author Navarro, Vince Justine
 *  @StillLizard0106
 *
 * 1. What changed from previous lab?
 * A: This lab replaced that with a real database persistence using User and Product entities,
 *    repositories, services, and CRUD endpoints.
 *
 * 2. Why database is better?
 * A: You can easily store, update, and delete records easily without touching the source code
 *    and multiple users can read/write data at the same time.
 *
 * 3. How JPA helped?
 * A: Switching databases required zero changes to your Java code and makes complex SQL
 *    into simple Java interfaces,
 *
 * 4.WWhat changed when switching DB?
 * A: Only application.properties is changed. To change it just comment out the H2 line
 *    and uncomment PostgreSQL lines.
 *
 */
import com.navarro.springboot.entity.User;
import com.navarro.springboot.exception.ResourceNotFoundException;
import com.navarro.springboot.repository.UserRepository;
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