package Calculator_Class;

/**
 * Calculator System Class
 * Ovejera, Ziggy
 */

class InvalidInputException_Ovejera extends Exception {
    public InvalidInputException_Ovejera(String message) {
        super(message);
    }
}

class NegativeNumberException_Ovejera extends RuntimeException {
    public NegativeNumberException_Ovejera(String message) {
        super(message);
    }
}

public class Calculator_Ovejera {

    private final String name;
    private int operationCount;

    public Calculator_Ovejera() {
        this.name = "Calculator";
        this.operationCount = 0;
    }

    public int add(int a, int b) {
        operationCount++;
        return a + b;
    }

    public double add(double a, double b) {
        operationCount++;
        return a + b;
    }

    public int subtract(int a, int b) {
        operationCount++;
        return a - b;
    }

    public double subtract(double a, double b) {
        operationCount++;
        return a - b;
    }

    public int multiply(int a, int b) {
        operationCount++;
        return a * b;
    }

    public double multiply(double a, double b) {
        operationCount++;
        return a * b;
    }

    // ================= EXCEPTION HANDLING =================
    public int divide(int a, int b) throws InvalidInputException_Ovejera {
        if (b == 0)
            throw new InvalidInputException_Ovejera("Integer division by zero");

        if (a < 0 || b < 0)
            throw new NegativeNumberException_Ovejera("Negative numbers not allowed");

        operationCount++;
        return a / b;
    }

    public double divide(double a, double b) throws InvalidInputException_Ovejera {
        if (b == 0)
            throw new InvalidInputException_Ovejera("Double division by zero");

        if (a < 0 || b < 0)
            throw new NegativeNumberException_Ovejera("Negative numbers not allowed");

        operationCount++;
        return a / b;
    }

    public String getName() {
        return name;
    }

    public int getOperationCount() {
        return operationCount;
    }

    /*
     * ================= CODE ANALYSIS =================
     * Exceptions Created:
     * - InvalidInputException_Ovejera (Checked)
     * - NegativeNumberException_Ovejera (Unchecked)
     *
     * Where thrown:
     * - Inside divide() methods
     *
     * Propagation:
     * - divide() uses "throws", passes error to caller
     *
     * OOP Concepts:
     * - Encapsulation: private fields
     * - Polymorphism: method overloading
     * ================================================
     */
}