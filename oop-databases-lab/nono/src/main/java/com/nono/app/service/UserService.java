package com.nono.app.service;

import com.nono.app.entity.User;
import com.nono.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

/**
* Author Mary Angeline B. Nono
* 
* 1.What changed from previous lab?
* -I moved from simple file handling or basic code to working with real databases. I learned how to connect our Spring Boot application to store and retrieve data properly, instead of just using variables or temporary memory.
* 
* 2. Why database is better?
* - Data stays forever: Data is saved permanently even if I close the program.
* - Organized: Information is stored in neat tables with rows and columns, making it easy to find.
* - Safe & Secure: I can control who accesses the data and prevent mistakes.
* - Handles large amounts: It can store thousands or millions of records easily without slowing down.
*
* 3.How JPA helped?
*  -JPA (Java Persistence API) made our work much easier. Instead of writing long and complicated SQL queries manually, I just used Java code and annotations. It automatically created tables, inserted data, and handled connections for us. It saved a lot of time and reduced errors.
*
* 4.What changed when switching DB?
* -When I switched from H2 to PostgreSQL:
* -I had to change the URL, username, and password in  application.properties .
*- I added the correct PostgreSQL Driver dependency.
*- The way I write code stayed almost the same because JPA works with many databases. Only the configuration part changed.
**/

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
