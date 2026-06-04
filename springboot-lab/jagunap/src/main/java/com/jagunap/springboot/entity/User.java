package com.jagunap.springboot.entity;

import jakarta.persistence.*;

// Encapsulation: fields are private with getters/setters
// Persistence mapping: @Entity maps this class to a database table
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String email;
    private boolean isRegular;
    private String role;

    public User() {}

    public User(String name, String phoneNumber, String email, boolean isRegular, String role) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isRegular = isRegular;
        this.role = role;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public boolean isRegular() { return isRegular; }
    public void setRegular(boolean regular) { isRegular = regular; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}