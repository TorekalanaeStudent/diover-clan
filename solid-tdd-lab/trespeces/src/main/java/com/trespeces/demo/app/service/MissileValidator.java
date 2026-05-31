package com.trespeces.demo.app.service;

// SOLID: SRP - Handles only validation logic
// SOLID: OCP - New validation rules can be added without modifying existing ones
// DRY: Centralized validation, no duplicate checks across classes
public class MissileValidator {

    public void validate(String name, double price, int quantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Missile name cannot be empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
    }
}