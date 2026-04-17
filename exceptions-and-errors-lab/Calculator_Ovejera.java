package Calculator_Class;

/**
 * Calculator System Class
 * Ovejera, Ziggy
 * @author Ovejera
 */
import exceptions.InvalidInputException_Ovejera;
import exceptions.NegativeNumberException_Ovejera;

public class Calculator_Ovejera {

    private final String name;
    private int operationCount;

    // Constructor (must match class name)
    public Calculator_Ovejera() {
        this.name = "Advanced Calculator";
        this.operationCount = 0;
    }

    // ================== ADD ==================
    public int add(int a, int b) {
        operationCount++;
        return a + b;
    }

    public double add(double a, double b) {
        operationCount++;
        return a + b;
    }

    // ================== SUBTRACT ==================
    public int subtract(int a, int b) {
        operationCount++;
        return a - b;
    }

    public double subtract(double a, double b) {
        operationCount++;
        return a - b;
    }

    // ================== MULTIPLY ==================
    public int multiply(int a, int b) {
        operationCount++;
        return a * b;
    }

    public double multiply(double a, double b) {
        operationCount++;
        return a * b;
    }

    // ================== DIVIDE ==================
    public int divide(int a, int b) throws InvalidInputException_Ovejera {
        if (b == 0) {
            throw new InvalidInputException_Ovejera("Error: Integer division by zero.");
        }

        if (a < 0 || b < 0) {
            throw new NegativeNumberException_Ovejera("Error: Negative numbers not allowed.");
        }

        operationCount++;
        return a / b;
    }

    public double divide(double a, double b) throws InvalidInputException_Ovejera {
        if (b == 0) {
            throw new InvalidInputException_Ovejera("Error: Double division by zero.");
        }

        if (a < 0 || b < 0) {
            throw new NegativeNumberException_Ovejera("Error: Negative numbers not allowed.");
        }

        operationCount++;
        return a / b;
    }

    // ================== GETTERS ==================
    public String getName() {
        return name;
    }

    public int getOperationCount() {
        return operationCount;
    }
}