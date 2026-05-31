package com.app.payment;

import com.app.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class MonthlyPayroll implements PayrollStrategy {

    // GRASP: Polymorphism
    @Override
    public double computeSalary(Employee employee) {
        return employee.getBaseSalary();
    }
}