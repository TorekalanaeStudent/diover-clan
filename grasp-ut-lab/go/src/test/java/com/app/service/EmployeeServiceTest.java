package com.app.service;

import com.app.exception.ResourceNotFoundException;
import com.app.dto.EmployeeDTO;
import com.app.entity.Employee;
import com.app.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @Test
    void shouldCreateEmployee() {
        EmployeeDTO dto = new EmployeeDTO("Seth", 5000, 1000);

        Employee saved = new Employee(1L, "Seth", 5000, 1000, 0, 0);

        when(repository.save(any(Employee.class))).thenReturn(saved);

        var result = service.createEmployee(dto);

        assertNotNull(result);
        verify(repository, times(1)).save(any(Employee.class));
    }

    @Test
    void shouldReturnEmployeeById() {
        Employee emp = new Employee(1L, "Seth", 5000, 1000, 0, 0);

        when(repository.findById(1L)).thenReturn(Optional.of(emp));

        var result = service.getEmployeeById(1L);

        assertEquals("Seth", result.getName());

    }

    @Test
    void shouldDeleteEmployee() {

        Employee emp = new Employee(1L, "Seth", 5000, 1000, 0, 0);

        when(repository.findById(1L)).thenReturn(Optional.of(emp));
        doNothing().when(repository).delete(emp);

        service.deleteEmployee(1L);

        verify(repository).delete(emp);

    }

    @Test
    void shouldThrowWhenEmployeeNotFound() {

        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> service.deleteEmployee(1L));
    }

}
// if you see this sir, thank you for being patient :)