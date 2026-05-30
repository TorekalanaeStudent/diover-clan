package com.ablis.app.service;

import com.ablis.app.entity.User;
import com.ablis.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> update(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedUser.getName());
                    existing.setEmail(updatedUser.getEmail());
                    existing.setAge(updatedUser.getAge());
                    existing.setAddress(updatedUser.getAddress());
                    existing.setPhone(updatedUser.getPhone());
                    return userRepository.save(existing);
                });
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}