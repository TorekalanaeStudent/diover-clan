package com.caneda.springboot.service.interfaces;

// GRASP: Polymorphism - defines common behavior for all wallet operations
// GRASP: Protected Variations - new operations can be added without changing existing code
public interface WalletOperation {
    float execute(float currentAmount);
}