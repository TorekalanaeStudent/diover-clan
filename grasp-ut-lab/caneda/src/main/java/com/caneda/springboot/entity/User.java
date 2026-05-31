package com.caneda.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// GRASP: Information Expert - User owns its own data and logic
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String userName;
    String userEmail;
    int userAge;
    private float userWalletAmount;

    // GRASP: Information Expert - User knows its own wallet state
    public void applyWalletAmount(float newAmount) {
        this.userWalletAmount = newAmount;
    }

    // GRASP: Information Expert - User validates its own wallet balance
    public boolean hasSufficientBalance(float amount) {
        return this.userWalletAmount >= amount;
    }

    // GRASP: Information Expert - User knows if it is active
    public boolean isValidUser() {
        return this.userName != null && this.userEmail != null;
    }
}