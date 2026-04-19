/**
 * Calculator Demonstration
 * Group Members:
 * Ovejera, Ziggy - @ziggyovejera
 * Ablis, Margreleigen - @matidagreat
 * 
 * @author: Ablis, Margreleigne
 */

package TeamJina;

import TeamJina.CalculatorClass_TeamJina;

public class CalculatorDemo_TeamJina {

    public static void main(String[] args) {

        // Create a new calculator object
        CalculatorClass_TeamJina calc = new CalculatorClass_TeamJina();

        System.out.println("========== MY CALCULATOR ==========\n");

        // Addition with whole numbers and decimals
        System.out.println("Addition with whole numbers and decimals: ");
        System.out.println("10 + 5 = " + calc.add(10, 5));
        System.out.println("20.8 + 8.3 = " + calc.add(20.8, 8.3));

        // Subtraction with whole numbers and decimals
        System.out.println("\nSubtraction with whole numbers and decimals: ");
        System.out.println("15 - 3 = " + calc.subtract(15, 3));
        System.out.println("50.9 - 20.4 = " + calc.subtract(50.9, 20.4));

        // Multiplication with whole numbers and decimals
        System.out.println("\nMultiplication with whole numbers and decimals: ");
        System.out.println("6 x 7 = " + calc.multiply(6, 7));
        System.out.println("9.8 x 4.3 = " + calc.multiply(9.8, 4.3));

        // DIVISION WITH TRY-CATCH BLOCKS TO DEMONSTRATE EXCEPTION HANDLING
        // Division with whole numbers and decimals
        System.out.println("\nDivision With No Errors:\n");
        
        try {
            System.out.println("Valid Division: 20 / 4 = " + calc.divide(20, 4));
            System.out.println("Valid Division: 12.6 / 3.0 = " + calc.divide(12.6, 3.0));
        } catch (InvalidInputException_TeamJina e) {
            System.out.println("ERROR: " + e.getMessage());
        } 
        System.out.println(); // for spacing

        // catching errors
        System.out.println("Division Errors:\n");

        // Error 1: Division by zero
        System.out.println("Error Demonstration for Division by Zero: ");
        try {
            System.out.println("Trying: 10 / 0");
            int result = calc.divide(10, 0);
            System.out.println("Result: " + result);
        } catch (InvalidInputException_TeamJina e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("Oh no!We can't divide by zero!\n");
        }

        // Error 2: Negative numbers
        System.out.println("Error Demonstration for Negative Numbers:");
        try {
            System.out.println("Trying: -10 / 2");
            int result = calc.divide(-10, 2);
            System.out.println("Result: " + result);
        } catch (NegativeNumberException_TeamJina e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("Oops! Negative numbers not allowed!\n");
        } catch (InvalidInputException_TeamJina e) {
            System.out.println("ERROR: " + e.getMessage());
        } 

        // summary of calculator demo
        System.out.println("SUMMARY\n");
        System.out.println("Operations performed: " + calc.getOperationCount());
        System.out.println("Calculator name: " + calc.getName());
        System.out.println("\nDemo Complete! Calculator operations completed.");
    }
}