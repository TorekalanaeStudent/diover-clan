/* 
* QUESTIONS AND ANSWERS:
 * Q1: How did you organize your packages?
 * Create a package for each class.
 * 
 * Q2: Why did you separate your classes this way?
 * To apply packages and organization.
 * 
 * Q3: How do packages improve encapsulation?
 * Packages improve encapsulation by grouping classes together as needed.
 * 
 * Q4: Where are your exceptions located?
 * My exceptions are located in the com.calculator.gedoria.exception
 * 
 * Q5: Why did you choose Maven or Gradle?
 * For me, I chosen Maven as a preferance as it seemed easier to deal with
 */

package com.calculator.gedoria.main;

import com.calculator.gedoria.service.SimpleCalculator;
import com.calculator.gedoria.exception.*;

public class CalculatorDemo_Gedoria {
    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();

        System.out.println("Calculator");

        try {
            // basic addition and subtraction
            System.out.println("Addition: " + calc.add(17, 8));
            System.out.println("SUbtraction: " + calc.subtract(55,8));

            // triggers unchecked exception
            System.out.println("Multiplication: " + calc.multiply(-3, 13));

            // triggers checked exception
            System.out.println("Division: " + calc.divide(10, 0));
        } catch (ZeroDivisionException e) {
            System.out.println("Checked Exception Error: " + e.getMessage());
        } catch (NegativeNumberException e) {
            System.out.println("Unchecked Exception Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Your Overall Error: " + e.getMessage());
        } finally {
            System.out.println("Operations Counted: " + calc.getOperationCount());
        }
    }
}
