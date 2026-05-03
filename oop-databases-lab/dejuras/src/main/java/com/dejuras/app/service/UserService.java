package com.dejuras.app.service;

import com.dejuras.app.entity.User;
import com.dejuras.app.exception.ResourceNotFoundException;
import com.dejuras.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public User getUserID(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found : " + id));
    }

    // CREATE
    public User makeUser(User user) {
        return userRepository.save(user);
    }

    // UPDATE
    public User updateUser(Long id, User user) {
        User existing = getUserID(id);

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setPhoneNumber(user.getPhoneNumber());

        return userRepository.save(existing);
    }

    // DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}