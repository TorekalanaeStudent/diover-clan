package com.caneda.springboot.service;

import com.caneda.springboot.service.interfaces.WalletOperation;

// GRASP: Polymorphism - concrete implementation for deducting from wallet
public class DeductWalletOperation implements WalletOperation {

    private float amount;

    public DeductWalletOperation(float amount) {
        this.amount = amount;
    }

    @Override
    public float execute(float currentAmount) {
        if (amount > currentAmount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        return currentAmount - amount;
    }
}