package com.caneda.app.service;

import com.caneda.app.entities.User_Caneda;
import com.caneda.app.repository.UserRepository_Caneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Greetings_Caneda {

    @Autowired
    private UserRepository_Caneda userRepository_Caneda;

    public User_Caneda getUserName(String userName) {
        return userRepository_Caneda.findByUserName(userName);
    }

    public User_Caneda getUserCountry(String userCountry) {
        return userRepository_Caneda.findByUserCountry(userCountry);
    }

    public void userGreeting(String userName, String userCountry) {
        User_Caneda user = getUserName(userName);
        System.out.println("Greetings " + user.getUserName() + " from " + user.getUserCountry() + " | Role: " + user.getUserRole());
    }
}
