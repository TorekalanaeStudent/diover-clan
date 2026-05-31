package com.grasp.cardeno.exception;

import org.junit.jupiter.api.Test;
import com.grasp.cardeno.exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void testHandleNotFound() {
        // Arrange: Pass a Long ID, not a String
        TaskNotFoundException ex = new TaskNotFoundException(1L);

        // Act
        ResponseEntity<String> response = handler.handleNotFound(ex);

        // Assert: Your TaskNotFoundException code creates the message "Task not found: " + id
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Task not found: 1", response.getBody()); // Ensure this matches your class logic
    }

    @Test
    void testHandleValidation() {
        IllegalArgumentException ex = new IllegalArgumentException("Invalid input");
        ResponseEntity<String> response = handler.handleValidation(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid input", response.getBody());
    }

    @Test
    void testHandleGeneralException() {
        Exception ex = new Exception("Something went wrong");
        ResponseEntity<String> response = handler.handleGeneralException(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertTrue(response.getBody().contains("An internal error occurred"));
    }
}