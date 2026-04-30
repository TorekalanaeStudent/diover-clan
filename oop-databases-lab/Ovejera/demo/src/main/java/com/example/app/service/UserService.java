package com.example.app.service;

import com.example.app.Entity.User;
import com.example.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // GET all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // CREATE user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // UPDATE user
    public User updateUser(Long id, User updatedUser) {
        if (userRepository.existsById(id)) {
            updatedUser.setId(id);
            return userRepository.save(updatedUser);
        }
        return null;
    }

    // DELETE user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}