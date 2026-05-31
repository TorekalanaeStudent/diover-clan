package com.app.service;

import com.app.dto.EmployeeDTO;
import com.app.dto.EmployeeResponseDTO;
import com.app.entity.Employee;

import java.util.List;

// SOLID: DIP
public interface EmployeeService {

    EmployeeResponseDTO createEmployee(EmployeeDTO dto);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    void deleteEmployee(Long id);
}