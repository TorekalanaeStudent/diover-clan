package com.caneda.app.exception;

public class ProductException_Caneda extends RuntimeException {

    //Exception if product is not found
    public static class ProductNotFoundException extends ProductException_Caneda {
        public ProductNotFoundException(String productName) {
            super("Product not found: " + productName);
        }
    }

    //Exception if product price is invalid
    public static class InvalidProductPriceException extends ProductException_Caneda {
        public InvalidProductPriceException(Double price) {
            super("Invalid price: " + price + ". Price must be greater than 0.");
        }
    }

    //Exception if product quantity is invalid
    public static class InvalidProductQuantityException extends ProductException_Caneda {
        public InvalidProductQuantityException(int quantity) {
            super("Invalid quantity: " + quantity + ". Quantity cannot be negative.");
        }
    }

    //Exception if product name is invalid
    public static class InvalidProductNameException extends ProductException_Caneda {
        public InvalidProductNameException(String productName) {
            super("Invalid product name: " + productName + ". Name cannot be empty.");
        }
    }

    //Exception if product already exists
    public static class ProductAlreadyExistsException extends ProductException_Caneda {
        public ProductAlreadyExistsException(String productName) {
            super("Product already exists: " + productName);
        }
    }

    //Base constructor
    public ProductException_Caneda(String message) {
        super(message);
    }
}
