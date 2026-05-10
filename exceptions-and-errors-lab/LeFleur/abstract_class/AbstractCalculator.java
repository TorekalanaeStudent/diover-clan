package abstract_classes;

/**Group Members:
 * Arban, Jhave P.
 * De Juras, Clint Norbert P.
 * @author @jhavearban-ctrl @cdejuras
 */

public abstract class AbstractCalculator {

    protected String calculatorName;

    // Constructor
    public AbstractCalculator(String calculatorName) {
        this.calculatorName = calculatorName;
    }

    // Abstract methods — subclass must implement
    public abstract int add(int a, int b);
    public abstract int subtract(int a, int b);
    public abstract int multiply(int a, int b);

    public abstract double add(double a, double b);
    public abstract double subtract(double a, double b);
    public abstract double multiply(double a, double b);
    public abstract double divide(double a, double b);

    // Concrete method
    public String getCalculatorName() {
        return calculatorName;
    }

    public void showCalculatorName() {
        System.out.println("Calculator: " + calculatorName);
    }
}