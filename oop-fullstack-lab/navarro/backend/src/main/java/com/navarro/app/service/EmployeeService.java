package com.navarro.app.service;

import com.navarro.app.model.Employee;
import com.navarro.app.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllUser() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updated) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setUsername(updated.getUsername());
                    employee.setPassword(updated.getPassword());
                    employee.setEmail(updated.getEmail());
                    employee.setPhoneNumber(updated.getPhoneNumber());
                    employee.setIsAdmin(updated.getIsAdmin());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id: " + id)
                );
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}