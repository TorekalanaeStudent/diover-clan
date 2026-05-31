package com.app.service;

import com.app.dto.EmployeeDTO;
import com.app.dto.EmployeeResponseDTO;
import com.app.entity.Employee;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.EmployeeRepository;
import com.app.service.impl.EmployeeServiceImpl;
import com.app.validation.EmployeeValidator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @Mock
    private EmployeeValidator validator;

    @InjectMocks
    private EmployeeServiceImpl service;

    // SOLID: DIP - Dependencies (Repository, Validator) are mocked to avoid concrete implementation coupling
    // GRASP: Low Coupling - Service is tested in isolation without database or external dependencies

    // ------------------------------------------------
    // CREATE EMPLOYEE SUCCESS
    // ------------------------------------------------
    @Test
    void shouldCreateEmployee() {

        EmployeeDTO dto =
                new EmployeeDTO("Seth", 5000, 1000);

        Employee saved =
                new Employee(1L, "Seth", 5000, 1000, 0, 0);

        doNothing().when(validator).validate(dto);

        when(repository.save(any(Employee.class)))
                .thenReturn(saved);

        EmployeeResponseDTO result =
                service.createEmployee(dto);

        assertNotNull(result);

        assertEquals(1L, result.getId());
        assertEquals("Seth", result.getName());

        // SOLID: SRP - Service delegates validation responsibility to EmployeeValidator
        // DIP: Repository interaction is verified through abstraction

        assertEquals(6000, result.getTotalSalary());

        verify(validator, times(1))
                .validate(dto);

        verify(repository, times(1))
                .save(any(Employee.class));
    }

    // ------------------------------------------------
    // GET EMPLOYEE BY ID SUCCESS
    // ------------------------------------------------
    @Test
    void shouldReturnEmployeeById() {

        Employee employee =
                new Employee(1L, "Seth", 5000, 1000, 0, 0);

        when(repository.findById(1L))
                .thenReturn(Optional.of(employee));

        Employee result =
                service.getEmployeeById(1L);

        assertNotNull(result);

        assertEquals("Seth", result.getName());
        assertEquals(5000, result.getBaseSalary());
        assertEquals(1000, result.getBonus());

        // GRASP: Information Expert - Service delegates retrieval to repository

        verify(repository, times(1))
                .findById(1L);
    }

    // ------------------------------------------------
    // GET EMPLOYEE BY ID FAILURE
    // ------------------------------------------------
    @Test
    void shouldThrowWhenEmployeeNotFound() {

        when(repository.findById(99L))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> service.getEmployeeById(99L)
        );

        // SOLID: SRP - Service handles exception responsibility
        verify(repository, times(1))
                .findById(99L);
    }

    // ------------------------------------------------
    // GET ALL EMPLOYEES SUCCESS
    // ------------------------------------------------
    @Test
    void shouldReturnAllEmployees() {

        List<Employee> employees = List.of(
                new Employee(1L, "Seth", 5000, 1000, 0, 0),
                new Employee(2L, "John", 4000, 500, 0, 0)
        );

        when(repository.findAll())
                .thenReturn(employees);

        List<Employee> result =
                service.getAllEmployees();

        assertEquals(2, result.size());

        assertEquals("Seth",
                result.get(0).getName());

        assertEquals("John",
                result.get(1).getName());

        // OCP: Adding more employees does not require service modification

        verify(repository, times(1))
                .findAll();
    }

    // ------------------------------------------------
    // GET ALL EMPLOYEES EMPTY LIST
    // ------------------------------------------------
    @Test
    void shouldReturnEmptyEmployeeList() {

        when(repository.findAll())
                .thenReturn(List.of());

        List<Employee> result =
                service.getAllEmployees();

        assertTrue(result.isEmpty());

        // EDGE CASE: Validates correct handling of empty collection

        verify(repository, times(1))
                .findAll();
    }

    // ------------------------------------------------
    // DELETE EMPLOYEE SUCCESS
    // ------------------------------------------------
    @Test
    void shouldDeleteEmployee() {

        Employee employee =
                new Employee(1L, "Seth", 5000, 1000, 0, 0);

        when(repository.findById(1L))
                .thenReturn(Optional.of(employee));

        doNothing().when(repository)
                .delete(employee);

        service.deleteEmployee(1L);

        verify(repository, times(1))
                .findById(1L);

        verify(repository, times(1))
                .delete(employee);

        // DIP: Service depends on repository abstraction, not concrete implementation
    }

    // ------------------------------------------------
    // DELETE EMPLOYEE FAILURE
    // ------------------------------------------------
    @Test
    void shouldThrowWhenDeletingEmployeeNotFound() {

        when(repository.findById(99L))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> service.deleteEmployee(99L)
        );

        verify(repository, never())
                .delete(any(Employee.class));

        // SRP: Service ensures deletion only happens if entity exists
    }

    // ------------------------------------------------
    // VALIDATION FAILURE
    // ------------------------------------------------
    @Test
    void shouldThrowWhenValidatorFails() {

        EmployeeDTO dto =
                new EmployeeDTO("", -5000, -1000);

        doThrow(new IllegalArgumentException(
                "Invalid employee"))
                .when(validator)
                .validate(dto);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.createEmployee(dto)
        );

        verify(repository, never())
                .save(any(Employee.class));

        // DRY: Validation logic centralized in EmployeeValidator
    }
}
// this is unbearable T~T I'm gonna die.