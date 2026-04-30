package com.cardeno.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cardeño, Faye L.
 * @flcardeno
 *
 * - Reflection -
 * 1. What changed from previous lab?
 *  - The biggest change was moving from a temporary database (H2) to a permanent one (PostgreSQL).
 *  In the previous lab, the data disappeared every time I restart the h2 console; now, it is saved permanently
 *  on your computer.
 *
 * 2. Why database is better?
 *  - A database like PostgreSQL is better because it saves data permanently even after the app is closed.
 * It also allows me to use tools like pgAdmin 4 to manage and see my data outside of IntelliJ.
 *
 * 3. How JPA helped?
 *  - JPA made it easier by handling database operations for me, so I didn’t need to write SQL manually.
 *
 * 4. What changed when switching DB?
 *  - I changed the config (H2 to PostgreSQL), while the code stayed the same because JPA handled it.
 *  - I also had to update the database URL and login in application.properties. Then, add the PostgreSQL driver
 *  to my build.gradle so the app could connect to the new database.
 **/

@ControllerAdvice
public class GlobalExceptionHandler {

    // this method catches the "ResourceNotFoundException" you just made
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("error", "Not Found");
        errorDetails.put("message", ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // this method catches any other random errors so your app doesn't crash messy
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("message", "An unexpected error occurred");
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}