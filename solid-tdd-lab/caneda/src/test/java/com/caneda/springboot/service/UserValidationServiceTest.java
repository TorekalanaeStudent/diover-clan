package com.caneda.springboot.service;

import com.caneda.springboot.dto.UserRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

// TDD: tests written first to prove validation behavior
// SOLID: SRP - only tests UserValidationService
class UserValidationServiceTest {

    // SOLID: DIP - testing through the service directly
    private final UserValidationService validator = new UserValidationService();

    // TDD RED: null DTO edge case
    @Test
    void shouldThrowWhenDtoIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                validator.validateUserRequest(null)
        );
    }

    // TDD RED: empty username edge case
    @Test
    void shouldThrowWhenUserNameIsEmpty() {
        UserRequestDTO dto = new UserRequestDTO("", "john@email.com", 20);
        assertThrows(IllegalArgumentException.class, () ->
                validator.validateUserRequest(dto)
        );
    }

    // TDD RED: blank username edge case
    @Test
    void shouldThrowWhenUserNameIsBlank() {
        UserRequestDTO dto = new UserRequestDTO("   ", "john@email.com", 20);
        assertThrows(IllegalArgumentException.class, () ->
                validator.validateUserRequest(dto)
        );
    }

    // TDD RED: empty email edge case
    @Test
    void shouldThrowWhenEmailIsEmpty() {
        UserRequestDTO dto = new UserRequestDTO("John", "", 20);
        assertThrows(IllegalArgumentException.class, () ->
                validator.validateUserRequest(dto)
        );
    }

    // TDD RED: zero age edge case
    @Test
    void shouldThrowWhenAgeIsZero() {
        UserRequestDTO dto = new UserRequestDTO("John", "john@email.com", 0);
        assertThrows(IllegalArgumentException.class, () ->
                validator.validateUserRequest(dto)
        );
    }

    // TDD RED: negative age edge case
    @Test
    void shouldThrowWhenAgeIsNegative() {
        UserRequestDTO dto = new UserRequestDTO("John", "john@email.com", -1);
        assertThrows(IllegalArgumentException.class, () ->
                validator.validateUserRequest(dto)
        );
    }

    // TDD GREEN: valid request passes
    @Test
    void shouldPassWhenRequestIsValid() {
        UserRequestDTO dto = new UserRequestDTO("John", "john@email.com", 20);
        assertDoesNotThrow(() -> validator.validateUserRequest(dto));
    }

    // Parameterized test - bonus points
    // TDD RED: multiple invalid IDs
    @ParameterizedTest
    @ValueSource(longs = {0, -1, -5, -100})
    void shouldThrowWhenIdIsInvalid(long id) {
        assertThrows(IllegalArgumentException.class, () ->
                validator.validateId(id)
        );
    }

    // TDD GREEN: valid ID passes
    @Test
    void shouldPassWhenIdIsValid() {
        assertDoesNotThrow(() -> validator.validateId(1L));
    }

    // Parameterized test - bonus points
    // TDD RED: multiple invalid amounts
    @ParameterizedTest
    @ValueSource(floats = {0f, -1f, -100f})
    void shouldThrowWhenAmountIsInvalid(float amount) {
        assertThrows(IllegalArgumentException.class, () ->
                validator.validateAmount(amount)
        );
    }

    // TDD GREEN: valid amount passes
    @Test
    void shouldPassWhenAmountIsValid() {
        assertDoesNotThrow(() -> validator.validateAmount(50f));
    }
}