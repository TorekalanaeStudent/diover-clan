package com.example.app.service;

import com.example.app.entity.User;
import com.example.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User createStudent(String username, String password, String email, String phoneNumber, boolean isAdmin) {
        return userRepository.save(User.builder().username(username).password(password).email(email).phone(phoneNumber).isAdmin(isAdmin).build());
    }

    public User updateStudent(Long id, String username, String password, String email, String phoneNumber, boolean isAdmin) {
        Optional<User> u = userRepository.findById(id);
        User user = null;
        if(u.isPresent()) {
            user = u.get();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhone(phoneNumber);
            user.setAdmin(isAdmin);
        }
        assert user != null;
        return userRepository.save(user);
    }

    public void deleteStudent(Long id) {
        userRepository.deleteById(id);
    }
}
