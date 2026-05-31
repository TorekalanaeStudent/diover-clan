package com.learning.appl.service.Impl;

import com.learning.appl.dto.request.UserRequest;
import com.learning.appl.dto.responses.UserResponse;
import com.learning.appl.entity.User;
import com.learning.appl.exceptions.UserNotFoundException;
import com.learning.appl.mapper.UserMapper;
import com.learning.appl.repository.UserRepository;
import com.learning.appl.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private User getUserOrThrow(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map(userMapper::toResponse).toList();
    }

    @Override
    public UserResponse getUserById(long id) {
        User user = getUserOrThrow(id);
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse createUser(UserRequest req){
        User user = userMapper.toEntity(req);
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    @Override
    public List<UserResponse> createUsers(@Valid List<UserRequest> reqs) {
        List<User> users = reqs.stream().map(userMapper::toEntity).toList();
        List<User> savedUsers = userRepository.saveAll(users);
        return savedUsers.stream().map(userMapper::toResponse).toList();
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest req) {
        User user = getUserOrThrow(id);

        user.updateDetails(req);

        User savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserOrThrow(id);
        userRepository.delete(user);
    }

}