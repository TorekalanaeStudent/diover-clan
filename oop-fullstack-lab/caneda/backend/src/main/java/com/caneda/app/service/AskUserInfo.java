package com.caneda.app.service;

import java.util.List;
import com.caneda.app.entities.User_Caneda;
import com.caneda.app.repository.UserRepository_Caneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AskUserInfo {

    @Autowired
    private UserRepository_Caneda userRepository_Caneda;

    public User_Caneda createUser(String userName, int userAge, String userEmail, String userCountry, String userRole) {
        User_Caneda newUser = new User_Caneda(userName, userAge, userEmail, userCountry, userRole);
        return userRepository_Caneda.save(newUser);
    }
    public List<User_Caneda> getAllUsers() {
        return userRepository_Caneda.findAll();
    }

    public User_Caneda getUserById(long id) {
        return userRepository_Caneda.findById(id).orElse(null);
    }

    public User_Caneda updateUser(long id, User_Caneda updatedUser) {
        User_Caneda user = getUserById(id);
        if (user != null) {
            user.setUserName(updatedUser.getUserName());
            user.setUserAge(updatedUser.getUserAge());
            user.setUserEmail(updatedUser.getUserEmail());
            user.setUserCountry(updatedUser.getUserCountry());
            user.setUserRole(updatedUser.getUserRole());
            return userRepository_Caneda.save(user);
        }
        return null;
    }

    public void deleteUser(long id) {
        userRepository_Caneda.deleteById(id);
    }
}
