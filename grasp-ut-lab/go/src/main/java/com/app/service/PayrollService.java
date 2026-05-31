package com.app.service;

import com.app.entity.Employee;
import com.app.payment.PayrollStrategy;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class PayrollService {

    private final PayrollStrategy payrollStrategy;

    public PayrollService(@Qualifier("hourlyPayroll") PayrollStrategy payrollStrategy) {
        this.payrollStrategy = payrollStrategy;
    }

    public double processSalary(Employee employee) {
        return payrollStrategy.computeSalary(employee);
    }
}