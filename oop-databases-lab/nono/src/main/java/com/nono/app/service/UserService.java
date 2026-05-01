package com.nono.app.service;

import com.nono.app.entity.User;
import com.nono.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * C - Create
     * R - Read
     * U - Update
     * D - Delete
     */

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Gamer not found wit id: " +id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existing = getUserById(id);
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setPhoneNumber(user.getPhoneNumber());
        existing.setIsRegular(user.getIsRegular());
        existing.setRank(user.getRank());

        return userRepository.save(existing);
    }
    public void deleteUser(Long id){
        getUserById(id);
        userRepository.deleteById(id);

    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
