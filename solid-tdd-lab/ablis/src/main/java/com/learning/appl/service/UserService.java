package com.learning.appl.service;

import com.learning.appl.dto.request.UserRequest;
import com.learning.appl.dto.responses.UserResponse;

import java.util.List;

// Interface Segregation : focused interface
// This class shows their own responsibilities/tasks
public interface UserService {

    List<UserResponse> getUsers();

    UserResponse getUserById(long id);

    UserResponse createUser(UserRequest req);

    List<UserResponse> createUsers(List<UserRequest> reqs);

    UserResponse updateUser(Long id, UserRequest req);

    void deleteUser(Long id);
}