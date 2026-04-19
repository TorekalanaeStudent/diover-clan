package TeamJina;

/**
 * Calculator Class
 * Group Members:
 * Ovejera, Ziggy - @ziggyovejera
 * Ablis, Margreleigne - @matidagreat
 * Gedoria, Rajan - @rajangedoria-ctrl
 * 
 * @author: Ovejera, Ziggy
 */

class InvalidInputException_TeamJina extends Exception {
    public InvalidInputException_TeamJina(String message) {
        super(message);
    }
}

class NegativeNumberException_TeamJina extends RuntimeException {
    public NegativeNumberException_TeamJina(String message) {
        super(message);
    }
}

public class CalculatorClass_TeamJina {

    private final String name;
    private int operationCount;

    public CalculatorClass_TeamJina() {
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
    public int divide(int a, int b) throws InvalidInputException_TeamJina {
        if (b == 0)
            throw new InvalidInputException_TeamJina("Integer division by zero");

        if (a < 0 || b < 0)
            throw new NegativeNumberException_TeamJina("Negative numbers not allowed");

        operationCount++;
        return a / b;
    }

    public double divide(double a, double b) throws InvalidInputException_TeamJina {
        if (b == 0)
            throw new InvalidInputException_TeamJina("Double division by zero");

        if (a < 0 || b < 0)
            throw new NegativeNumberException_TeamJina("Negative numbers not allowed");

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
     * - InvalidInputException_TeamJina (Checked)
     * - NegativeNumberException_TeamJina (Unchecked)
     *
     * Where thrown:
     * - Inside divide() methods
     * 
     * Handled in CalculatorDemo_TeamJina using try-catch blocks
     *
     * Propagation:
     * - Occurs in divide() uses "throws", passes error to caller
     *
     * OOP Concepts:
     * - Encapsulation: private fields
     * - Polymorphism: method overloading
     * ================================================
     */
}