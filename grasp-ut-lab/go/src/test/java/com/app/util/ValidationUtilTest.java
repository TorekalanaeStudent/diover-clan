package com.app.util;

import com.app.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilTest {

    @Test
    void shouldThrowWhenDtoIsNull() {

        assertThrows(
                IllegalArgumentException.class,
                () -> ValidationUtil.validateEmployee(null)
        );
    }

    @Test
    void shouldThrowWhenNameIsBlank() {

        EmployeeDTO dto =
                new EmployeeDTO("", 5000, 1000);

        assertThrows(
                IllegalArgumentException.class,
                () -> ValidationUtil.validateEmployee(dto)
        );
    }

    @Test
    void shouldPassValidation() {

        EmployeeDTO dto =
                new EmployeeDTO("John", 5000, 1000);

        assertDoesNotThrow(
                () -> ValidationUtil.validateEmployee(dto)
        );
    }
}