package com.learning.appl.service;

import com.learning.appl.dto.request.UserRequest;
import com.learning.appl.dto.responses.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> getUsers();

    UserResponse getUserById(long id);

    UserResponse createUser(UserRequest req);

    List<UserResponse> createUsers(List<UserRequest> reqs);

    UserResponse updateUser(Long id, UserRequest req);

    void deleteUser(Long id);
}
