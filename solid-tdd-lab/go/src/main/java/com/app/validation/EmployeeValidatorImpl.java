package com.app.validation;

import com.app.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidatorImpl implements EmployeeValidator {

    // SOLID: SRP
    // Handles ONLY validation

    @Override
    public void validate(EmployeeDTO dto) {

        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new IllegalArgumentException("Employee name is required");
        }

        if (dto.getBaseSalary() < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
    }
}