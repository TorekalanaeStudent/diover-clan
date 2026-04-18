package calculator_class;
/**
 * Calculator System Class
 * Navarro, Vince Justine
 * @author StillLizard0106
 */
public class SimpleCalculator_Navarro {

    private final String name;
    private int operationCount;

    public SimpleCalculator_Navarro() {
        this.name = "Simple Calculator";
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

    public int divide(int a, int b) {
        if (b == 0)
            throw new ArithmeticException("Integer division by zero");
        operationCount++;
        return a / b;
    }

    public double divide(double a, double b) {
        if (b == 0)
            throw new ArithmeticException("Double division by zero");
        operationCount++;
        return a / b;
    }

    public String getName()          { return name; }
    public int    getOperationCount() { return operationCount; }
}