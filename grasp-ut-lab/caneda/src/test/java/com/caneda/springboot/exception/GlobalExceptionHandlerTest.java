package com.caneda.springboot.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void shouldHandleUserNotFoundException() {
        UserNotFoundException ex = new UserNotFoundException(1L);
        ResponseEntity<String> response = handler.handleUserNotFound(ex);

        assertEquals(404, response.getStatusCode().value());
        assertTrue(response.getBody().contains("1"));
    }

    @Test
    void shouldHandleInsufficientBalanceException() {
        InsufficientBalanceException ex = new InsufficientBalanceException(100f);
        ResponseEntity<String> response = handler.handleInsufficientBalance(ex);

        assertEquals(400, response.getStatusCode().value());
        assertTrue(response.getBody().contains("100"));
    }

    @Test
    void shouldHandleIllegalArgumentException() {
        IllegalArgumentException ex = new IllegalArgumentException("Invalid ID");
        ResponseEntity<String> response = handler.handleIllegalArgument(ex);

        assertEquals(400, response.getStatusCode().value());
        assertEquals("Invalid ID", response.getBody());
    }
}