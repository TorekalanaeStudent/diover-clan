package com.app.payment;

import com.app.entity.Employee;

// GRASP: Protected Variations
public interface PayrollStrategy {

    double computeSalary(Employee employee);
}