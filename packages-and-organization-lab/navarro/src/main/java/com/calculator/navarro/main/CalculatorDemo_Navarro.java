package com.calculator.navarro.main;

import com.calculator.navarro.service.SimpleCalculator;
import com.calculator.navarro.exception.*;

// Code-Based Analysis
/**
 * 1. How did you organize your packages?
 * A: I created multiple folders to make it easier to navigate.
 * 
 * 2. Why did you separate your classes this way?
 * A: To make sure it's more organized and make files easier to find.
 * 
 * 3. How do packages improve encapsulation?
 * A: Packages improve encapsulation because it controls the visibility of classes by using access modifiers.
 * 
 * 4. Where are your exceptions located?
 * A: In com.calculator.navarro.exceptions.
 * 
 * 5. Why did you choose Maven or Gradle?
 * A: I picked Gradle because I think it's more easier to do and I already have some expereince of using it.
 * 
 */

public class CalculatorDemo_Navarro {
    public static void main(String[] args) {

        SimpleCalculator calc = new SimpleCalculator();

        System.out.println("=========== Navarrro Calcualtor ===========");

        try {
            // normal operation stuff
            System.out.println("Add: " + calc.add(1, 50));
            System.out.println("Subtract: " + calc.subtract(100, 30));

            // triggering unchecked exception
            System.out.println("Multiply: " + calc.multiply(-3, 25)); 
                                                     
            // triggering checked exception
            System.out.println("Divide: " + calc.divide(6, 0)); 

        } catch (ZeroDivisionException e) {
            System.out.println("Checked Exception Caught: " + e.getMessage());

        } catch (NegativeNumberException e) {
            System.out.println("Unchecked Exception Caught: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());

        } finally {
            System.out.println("Operations attempted: " + calc.getOperationCount());
            System.out.println("\nCleaning up resources..."); // just to make it cooler
        }

        System.out.println("\n[Brought to you by " + calc.getName() + "]");
    }
}
