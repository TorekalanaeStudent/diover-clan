package calculator_demo;

import calculator_class.PlainCalculator;
import exceptions.DivideByZeroException;
import exceptions.NegativeNumberException;

public class PlainCalculatorDemo {

    public static void main(String[] args) {

        PlainCalculator calc = new PlainCalculator("Basic Calculator");

        // First set
        try {
            System.out.println("Calculator: " + calc.getName());
            System.out.println("Add: " + calc.add(10, 5));
            System.out.println("Subtract: " + calc.subtract(10, 3));
            System.out.println("Multiply: " + calc.multiply(4, 2));

            System.out.println("Divide: " + calc.divide(10, 0));

        } catch (DivideByZeroException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("First set done.\n");
        }

        // Second set
        try {
            System.out.println("Add (double): " + calc.add(2.5, 3.5));

            calc.validateInput(-5);

        } catch (NegativeNumberException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }

        // Final outputs
        System.out.println("\nLast Result: " + calc.getLastResult());

        calc.clear();
        System.out.println("After clear: " + calc.getLastResult());
    }
}