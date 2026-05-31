package com.caneda.springboot.service;

// GRASP: Polymorphism - concrete implementation for adding to wallet
public class AddWalletOperation implements WalletOperation {

    private float amount;

    public AddWalletOperation(float amount) {
        this.amount = amount;
    }

    @Override
    public float execute(float currentAmount) {
        return currentAmount + amount;
    }
}