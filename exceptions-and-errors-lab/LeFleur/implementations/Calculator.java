package implementations;

import abstract_classes.AbstractCalculator;
import exceptions.DivisionByZeroException;
import exceptions.InvalidInputException;
import interfaces.CalculatorOperations;

/**Group Members:
 * Arban, Jhave P.
 * De Juras, Clint Norbert P.
 * @author @jhavearban-ctrl @cdejuras
 *
 * Encapsulation: all fields are private, accessed via getters
 * Abstraction: extends AbstractCalculator, implements CalculatorOperations
 * Inheritance: inherits from AbstractCalculator
 * Polymorphism: methods overloaded for int and double
 */

public class Calculator extends AbstractCalculator implements CalculatorSystem {

    private double lastResult;
    private int operationCount;

    // Default Constructor
    public Calculator() {
        super("Standard Calculator");
        this.lastResult = 0.0;
        this.operationCount = 0;
    }

    // Parameterized Constructor
    public Calculator(String calculatorName) {
        super(calculatorName);
        this.lastResult = 0.0;
        this.operationCount = 0;
    }

    // ========================
    // int overloads (interface)
    // ========================

    @Override
    public int add(int a, int b) {
        int result = a + b;
        lastResult = result;
        operationCount++;
        System.out.println("[INT] " + a + " + " + b + " = " + result);
        return result;
    }

    @Override
    public int subtract(int a, int b) {
        int result = a - b;
        lastResult = result;
        operationCount++;
        System.out.println("[INT] " + a + " - " + b + " = " + result);
        return result;
    }

    @Override
    public int multiply(int a, int b) {
        int result = a * b;
        lastResult = result;
        operationCount++;
        System.out.println("[INT] " + a + " * " + b + " = " + result);
        return result;
    }

    // Checked exception — declared with throws
    @Override
    public int divide(int a, int b) throws InvalidInputException {
        if (b == 0) {
            throw new InvalidInputException("Cannot divide " + a + " by zero.");
        }
        int result = a / b;
        lastResult = result;
        operationCount++;
        System.out.println("[INT] " + a + " / " + b + " = " + result);
        return result;
    }

    // ========================
    // double overloads (abstract class)
    // ========================

    @Override
    public double add(double a, double b) {
        double result = a + b;
        lastResult = result;
        operationCount++;
        System.out.println("[DOUBLE] " + a + " + " + b + " = " + result);
        return result;
    }

    @Override
    public double subtract(double a, double b) {
        double result = a - b;
        lastResult = result;
        operationCount++;
        System.out.println("[DOUBLE] " + a + " - " + b + " = " + result);
        return result;
    }

    @Override
    public double multiply(double a, double b) {
        double result = a * b;
        lastResult = result;
        operationCount++;
        System.out.println("[DOUBLE] " + a + " * " + b + " = " + result);
        return result;
    }

    // Unchecked exception — no throws needed in signature
    @Override
    public double divide(double a, double b) {
        if (b == 0) {
            throw new DivisionByZeroException("Cannot divide " + a + " by zero.");
        }
        double result = a / b;
        lastResult = result;
        operationCount++;
        System.out.println("[DOUBLE] " + a + " / " + b + " = " + result);
        return result;
    }

    // Getters
    public double getLastResult() {
        return lastResult;
    }

    public int getOperationCount() {
        return operationCount;
    }
}