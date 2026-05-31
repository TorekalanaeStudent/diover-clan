package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeDTO {

    // SOLID: Immutable DTO
    private final String name;
    private final double baseSalary;
    private final double bonus;
}