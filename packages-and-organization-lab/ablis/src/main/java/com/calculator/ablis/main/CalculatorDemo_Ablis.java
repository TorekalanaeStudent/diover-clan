/**
 * @author: ABLIS, Margreleigne M.
 * @matidagreat
 * Date: 26/04/2026

 * QUESTIONS AND ANSWERS:
 * Q1: How did you organize your packages?
 * I created a specific package for each classes.
 * 
 * Q2: Why did you separate your classes this way?
 * It is to make it more organized and easier to find the classes that we need.
 * 
 * Q3: How do packages improve encapsulation?
 * Packages improve encapsulation by grouping related classes together.
 * 
 * Q4: Where are your exceptions located?
 * My exceptions are located in the com.calculator.ablis.exception
 * 
 * Q5: Why did you choose Maven or Gradle?
 * For me, I chose Maven because I understand it better more than Gradle. 
 * In creating the XML, it is straightforward and easier to understand like HTML.
 */

package com.calculator.ablis.main;

import com.calculator.ablis.service.SimpleCalculator;
import com.calculator.ablis.exception.*;

public class CalculatorDemo_Ablis {
    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();

        System.out.println("Fastest Calculator in the WHOLE EXPANDING UNIVERSE");

        try {
            // basic addition and subtraction
            System.out.println("Addition: " + calc.add(1730, 8));
            System.out.println("SUbtraction: " + calc.subtract(75,8));

            // triggers unchecked exception cuz of negative num
            System.out.println("Multiplication: " + calc.multiply(-5, 30));

            // triggers checked exception cuz of 0
            System.out.println("Division: " + calc.divide(60, 0));
        } catch (ZeroDivisionException e) {
            System.out.println("Checked Exception Error: " + e.getMessage());
        } catch (NegativeNumberException e) {
            System.out.println("Unchecked Exception Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Your Overall Error: " + e.getMessage());
        } finally {
            System.out.println("Operations COunted: " + calc.getOperationCount());
        }

        System.out.println("Thank you for using " + calc.getName());
    }
}