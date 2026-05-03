package com.obedoza.app.obedoza.service;

import com.obedoza.app.obedoza.entity.User;
import com.obedoza.app.obedoza.exception.ResourceNotFoundException;
import com.obedoza.app.obedoza.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        User existing = getUserById(id);
        if (updatedUser.getName() != null) existing.setName(updatedUser.getName());
        if (updatedUser.getEmail() != null) existing.setEmail(updatedUser.getEmail());
        if (updatedUser.getPhoneNumber() != null) existing.setPhoneNumber(updatedUser.getPhoneNumber());
        if (updatedUser.getRole() != null) existing.setRole(updatedUser.getRole());
        existing.setRegular(updatedUser.isRegular());
        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        getUserById(id);
        userRepository.deleteById(id);
    }
}
