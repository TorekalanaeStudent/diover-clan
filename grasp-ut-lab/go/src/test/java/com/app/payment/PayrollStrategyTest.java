package com.app.payment;

import com.app.entity.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayrollStrategyTest {

    @Test
    void monthlyPayrollShouldReturnBaseSalary() {

        PayrollStrategy strategy =
                new MonthlyPayroll();

        Employee employee = new Employee();
        employee.setBaseSalary(5000);

        double result =
                strategy.computeSalary(employee);

        assertEquals(5000, result);
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
    }
    // bomboclat
}