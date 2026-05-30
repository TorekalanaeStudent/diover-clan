package com.app.repository;

import com.app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// GRASP: Indirection
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}