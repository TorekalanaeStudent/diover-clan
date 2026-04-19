package interfaces;

import exceptions.InvalidInputException;

/**Group Members:
 * Arban, Jhave P.
 * De Juras, Clint Norbert P.
 * @author @jhavearban-ctrl @cdejuras
 */

public interface CalculatorSystem {

    // Abstract methods — must be implemented
    int add(int a, int b);
    int subtract(int a, int b);
    int multiply(int a, int b);

    // Checked exception declared in signature
    int divide(int a, int b) throws InvalidInputException;

    // Default method
    default void showOperation(String operation, double result) {
        System.out.println("Operation: " + operation + " = " + result);
    }
}