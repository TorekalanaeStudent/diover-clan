package com.app.service.impl;

import com.app.dto.EmployeeDTO;
import com.app.dto.EmployeeResponseDTO;
import com.app.entity.Employee;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.EmployeeRepository;
import com.app.service.EmployeeService;
import com.app.validation.EmployeeValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeValidator validator;

    // SOLID: Dependency Injection
    // DIP: Depends on abstractions
    public EmployeeServiceImpl(
            EmployeeRepository repository,
            EmployeeValidator validator
    ) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeDTO dto) {

        validator.validate(dto);

        // GRASP: Creator
        Employee employee = new Employee();

        employee.setName(dto.getName());
        employee.setBaseSalary(dto.getBaseSalary());
        employee.setBonus(dto.getBonus());

        Employee saved = repository.save(employee);

        return new EmployeeResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.calculateTotalSalary()
        );
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found"));
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee = getEmployeeById(id);

        repository.delete(employee);
    }
}
