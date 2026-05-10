package com.caneda.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "users")
public class User_Caneda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private int userAge;
    private String userName;
    private String userCountry;
    private String userEmail;
    private String userRole;


    //Default Constructor if no user input
    public User_Caneda() {
        setUserName("Default");
        setUserAge(1);
        setUserEmail("noEmail@gmail.com");
        setUserCountry("Antarctica");
        setUserRole("Guest");
    }

    //Parameterized Constructor if user has inputed some data
    public User_Caneda(String userName, int userAge, String userEmail, String userCountry, String userRole) {
        setUserName(userName);
        setUserAge(userAge);
        setUserEmail(userEmail);
        setUserCountry(userCountry);
        setUserRole(userRole);
    }

    //Getters

    //Gets id
    public long getUserId(){
        return id;
    }

    //Gets userName
    public String getUserName(){
        return userName;
    }

    //Gets userAge
    public int getUserAge() {
        return userAge;
    }

    //Gets userEmail
    public String getUserEmail() {
        return userEmail;
    }

    //Gets userCountry
    public String getUserCountry() {
        return userCountry;
    }

    //Gets userRole
    public String getUserRole() {
        return userRole;
    }

    //Setters

    //Sets Id
    public void setId(long id) {
        this.id = id;
    }

    //Sets User name if empty then no name
    public void setUserName(String userName) {
        if(userName == null || userName.isEmpty()) {
            this.userName = "No Name";
        }
        else {
            this.userName = userName;
        }
    }

    //Sets User age if below 1 user gets 1 as a default response
    public void setUserAge(int userAge) {
        if(userAge <= 0){
            this.userAge = 1;
        }
        else{
            this.userAge = userAge;
        }
    }

    //Sets user Email if none its no email
    public void setUserEmail(String userEmail) {
        if(userEmail == null || userEmail.isEmpty()) {
            this.userEmail = "No Email";
        }
        else {
            this.userEmail = userEmail;
        }
    }

    //Sets user country if none its no country
    public void setUserCountry(String userCountry) {
        if(userCountry == null || userCountry.isEmpty()){
            this.userCountry = "No Country";
        }
        else {
            this.userCountry = userCountry;
        }
    }

    //Sets user role if none defaults to Guest
    public void setUserRole(String userRole) {
        if(userRole == null || userRole.isEmpty()){
            this.userRole = "Guest";
        }
        else {
            this.userRole = userRole;
        }
    }
}
