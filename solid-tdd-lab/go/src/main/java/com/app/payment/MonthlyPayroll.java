package com.app.payment;

import com.app.entity.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MonthlyPayroll implements PayrollStrategy {

    @Override
    public double computeSalary(Employee employee) {
        return employee.getBaseSalary() + employee.getBonus();
    }
}