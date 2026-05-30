package com.caneda.fullstack.service;

import com.caneda.fullstack.entity.CoinFlip;
import com.caneda.fullstack.entity.User;
import com.caneda.fullstack.repository.UserRepository;
import com.caneda.fullstack.repository.CoinFlipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service // Marks this as a Spring service (business logic layer)
public class UserService {

    @Autowired // Injects the repository automatically
    private UserRepository userRepository;

    // Get all users from the database
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a single user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Create a new user and save to database
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Update an existing user by ID
    public User updateUser(Long id, User updatedUser) {
        // Find the existing user first
        User existing = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        //add or remove fields here as needed
        existing.setName(updatedUser.getName());
        existing.setEmail(updatedUser.getEmail());
        existing.setRole(updatedUser.getRole());

        // Save and return the updated user
        return userRepository.save(existing);
    }

    // Delete a user by ID
    @Transactional
    public void deleteUser(Long id) {
        coinFlipRepository.deleteByUserId(id);
        userRepository.deleteById(id);
    }


    // Gets the summary of one specific user
    @Autowired
    private CoinFlipRepository coinFlipRepository;
    public Map<String, Object> getUserSummary(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<CoinFlip> flips = coinFlipRepository.findByUserId(userId);
        long wins = flips.stream().filter(CoinFlip::isWinOrNo).count();
        long losses = flips.size() - wins;

        Map<String, Object> summary = new HashMap<>();
        summary.put("username", user.getName());
        summary.put("Email", user.getEmail());
        summary.put("Role", user.getRole());
        summary.put("wins", wins);
        summary.put("losses", losses);
        summary.put("totalFlips", flips.size());
        return summary;
    }

    // Gets the summary of ALL users
    public List<Map<String, Object>> getAllUserSummaries() {
        List<User> users = userRepository.findAll();
        List<Map<String, Object>> summaries = new ArrayList<>();

        for (User user : users) {
            List<CoinFlip> flips = coinFlipRepository.findByUserId(user.getId());
            long wins = flips.stream().filter(CoinFlip::isWinOrNo).count();
            long losses = flips.size() - wins;

            Map<String, Object> summary = new HashMap<>();
            summary.put("username", user.getName());
            summary.put("wins", wins);
            summary.put("losses", losses);
            summary.put("totalFlips", flips.size());
            summaries.add(summary);
        }

        return summaries;
    }
}
