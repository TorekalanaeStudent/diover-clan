package com.app.payment;

import com.app.entity.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayrollStrategyTest {

    // SOLID: LSP - Different implementations of PayrollStrategy are interchangeable
    // SOLID: OCP - New payroll types can be added without modifying existing tests or logic
    // OOP: Polymorphism - Same interface, different behavior per implementation

    @Test
    void monthlyPayrollShouldReturnBaseSalary() {

        PayrollStrategy strategy =
                new MonthlyPayroll();

        Employee employee = new Employee();
        employee.setBaseSalary(5000);

        double result =
                strategy.computeSalary(employee);

        assertEquals(5000, result);

        // POLYMORPHISM: MonthlyPayroll correctly implements PayrollStrategy contract
    }

    @Test
    void hourlyPayrollShouldComputeHours() {

        PayrollStrategy strategy =
                new HourlyPayroll();

        Employee employee = new Employee();
        employee.setHoursWorked(40);
        employee.setHourlyRate(100);

        double result =
                strategy.computeSalary(employee);

        assertEquals(4000, result);

        // POLYMORPHISM: HourlyPayroll provides different behavior under same interface
    }
}