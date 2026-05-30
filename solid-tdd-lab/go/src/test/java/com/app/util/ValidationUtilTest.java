package com.app.util;

import com.app.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilTest {

    // SOLID: SRP - Testing only validation logic, not service or persistence layers
    // GRASP: Low Coupling - Validation is tested independently of business logic

    @Test
    void shouldThrowWhenDtoIsNull() {

        assertThrows(
                IllegalArgumentException.class,
                () -> ValidationUtil.validateEmployee(null)
        );

        // SRP: ValidationUtil is responsible for input validation only
        // EDGE CASE: Null object handling
    }

    @Test
    void shouldThrowWhenNameIsBlank() {

        EmployeeDTO dto =
                new EmployeeDTO("", 5000, 1000);

        assertThrows(
                IllegalArgumentException.class,
                () -> ValidationUtil.validateEmployee(dto)
        );

        // DRY: Validation logic is centralized inside ValidationUtil
        // SRP: Ensures name validation is handled in one place
    }

    @Test
    void shouldPassValidation() {

        EmployeeDTO dto =
                new EmployeeDTO("John", 5000, 1000);

        assertDoesNotThrow(
                () -> ValidationUtil.validateEmployee(dto)
        );

        // KISS: Simple validation rule with minimal logic
        // EDGE CASE COVERAGE: Valid input path ensures full branch coverage
    }
}