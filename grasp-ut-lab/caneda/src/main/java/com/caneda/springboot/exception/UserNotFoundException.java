package com.caneda.springboot.exception;

// GRASP: Protected Variations - isolates how "not found" is handled
// if error format changes, only this class changes
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(long id) {
        super("User not found with id: " + id);
    }
}