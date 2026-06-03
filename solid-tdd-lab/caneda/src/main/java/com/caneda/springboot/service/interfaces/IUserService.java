package com.caneda.springboot.service.interfaces;

import com.caneda.springboot.dto.UserRequestDTO;
import com.caneda.springboot.dto.UserResponseDTO;

// SOLID: DIP - controllers depend on this abstraction not concrete class
// SOLID: ISP - contains only user related operations, not wallet
// SOLID: OCP - new behavior can be added via new implementations
public interface IUserService {
    UserResponseDTO createUser(UserRequestDTO dto);
    UserResponseDTO getUserById(long id);
    UserResponseDTO setUser(long id, UserRequestDTO dto);
    void deleteUser(long id);
}