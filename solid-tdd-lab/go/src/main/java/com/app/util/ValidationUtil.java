package com.app.util;

import com.app.dto.EmployeeDTO;

public class ValidationUtil {

    private ValidationUtil() {
    }

    public static void validateEmployee(EmployeeDTO dto) {

        if (dto == null) {
            throw new IllegalArgumentException("Employee DTO cannot be null");
        }

        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new IllegalArgumentException("Employee name is required");
        }
    }
}