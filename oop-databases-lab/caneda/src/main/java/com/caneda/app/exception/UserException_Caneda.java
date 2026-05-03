package com.caneda.app.exception;

public class UserException_Caneda extends RuntimeException {

    //Exception if user is not found
    public static class UserNotFoundException extends UserException_Caneda {
        public UserNotFoundException(String userName) {
            super("User not found: " + userName);
        }
    }

    //Exception if user age is invalid
    public static class InvalidUserAgeException extends UserException_Caneda {
        public InvalidUserAgeException(int userAge) {
            super("Invalid age: " + userAge + ". Age must be greater than 0.");
        }
    }

    //Exception if user email is invalid
    public static class InvalidUserEmailException extends UserException_Caneda {
        public InvalidUserEmailException(String userEmail) {
            super("Invalid email: " + userEmail);
        }
    }

    //Exception if user role is invalid
    public static class InvalidUserRoleException extends UserException_Caneda {
        public InvalidUserRoleException(String userRole) {
            super("Invalid role: " + userRole + ". Role cannot be empty.");
        }
    }

    //Exception if user already exists
    public static class UserAlreadyExistsException extends UserException_Caneda {
        public UserAlreadyExistsException(String userName) {
            super("User already exists: " + userName);
        }
    }

    //Base constructor
    public UserException_Caneda(String message) {
        super(message);
    }
}
