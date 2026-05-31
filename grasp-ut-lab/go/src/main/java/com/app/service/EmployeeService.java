package com.app.service;

import com.app.dto.EmployeeDTO;
import com.app.dto.EmployeeResponseDTO;
import com.app.entity.Employee;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.EmployeeRepository;
import com.app.util.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    // GRASP: Low Coupling
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // GRASP: Creator
    // GRASP: Pure Fabrication
    public EmployeeResponseDTO createEmployee(EmployeeDTO dto) {

        ValidationUtil.validateEmployee(dto);

        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setBaseSalary(dto.getBaseSalary());
        employee.setBonus(dto.getBonus());

        Employee savedEmployee = repository.save(employee);

        return new EmployeeResponseDTO(
                savedEmployee.getId(),
                savedEmployee.getName(),
                savedEmployee.calculateTotalSalary()
        );
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found"));
    }

    public void deleteEmployee(Long id) {

        Employee employee = getEmployeeById(id);

        repository.delete(employee);
    }
}