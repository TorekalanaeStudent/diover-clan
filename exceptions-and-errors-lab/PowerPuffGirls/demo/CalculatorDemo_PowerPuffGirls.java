package demo;

import calculator_class.Calculator;
import exceptions.InvalidInputException;
import exceptions.NegativeNumberException;
 
/*
=====================================================
CalculatorDemo_GroupName.java
-----------------------------------------------------
GROUP MEMBERS:
- Faye Cardeno
- Janelle Jagunap
- Mary Angeline B. Nono
 
PURPOSE:
This demo program tests the Calculator system by:
- Calling calculator methods
- Triggering multiple exceptions
- Showing proper exception handling
- Demonstrating OOP principles
=====================================================
 
---------------------------------------------
EXCEPTIONS CREATED (Code-Based Analysis)
---------------------------------------------
1. InvalidInputException
   - Type: CHECKED exception
   - Extends: Exception
   - Purpose: Handles invalid inputs such as division by zero
   - Thrown in: divide() methods of Calculator
 
2. NegativeNumberException
   - Type: UNCHECKED exception
   - Extends: RuntimeException
   - Purpose: Restricts negative numbers in multiplication
   - Thrown in: validateNegative() method
 
---------------------------------------------
WHERE EXCEPTIONS ARE THROWN
---------------------------------------------
- InvalidInputException:
  - Thrown using 'throw' inside divide()
  - Declared using 'throws' in method signature
 
- NegativeNumberException:
  - Thrown using 'throw' inside validateNegative()
  - Not declared in method signature (unchecked)
 
---------------------------------------------
WHERE EXCEPTIONS ARE HANDLED
---------------------------------------------
- ALL exceptions are handled in this Demo class
  using try-catch blocks.
 
---------------------------------------------
EXCEPTION PROPAGATION
---------------------------------------------
- Exceptions originate in Calculator methods
- Propagate up to this demo class
- Handled here to keep Calculator reusable
 
---------------------------------------------
OOP CONCEPTS APPLIED
---------------------------------------------
Encapsulation:
- Calculator data & logic hidden inside classes
 
Abstraction:
- Demo interacts only with public methods
 
Inheritance:
- AdvancedCalculator extends Calculator
 
Polymorphism:
- Overridden divide() method used at runtime
=====================================================
*/
 
public class CalculatorDemo_PowerPuffGirls {
 
    public static void main(String[] args) {
 
        // Polymorphism:
        // Parent reference pointing to child object
        Calculator calculator = new Calculator();
 
        System.out.println("===== Calculator Demo Started =====");
 
        try {
            // ✅ Normal operations
            System.out.println("Addition (int): " + calculator.add(10, 5));
            System.out.println("Addition (double): " + calculator.add(2.5, 1.5));
            System.out.println("Subtraction: " + calculator.subtract(10, 3));
 
            // ✅ Valid multiplication
            System.out.println("Multiplication: " + calculator.multiply(4, 3));
 
            // ❌ Trigger CHECKED exception (division by zero)
            System.out.println("Division: " + calculator.divide(10, 0));
 
        }
        catch (InvalidInputException e) {
            // Handles CHECKED exception
            System.err.println("ERROR (Invalid Input): " + e.getMessage());
 
        }
        catch (NegativeNumberException e) {
            // Handles UNCHECKED exception
            System.err.println("ERROR (Negative Number): " + e.getMessage());
 
        }
        catch (Exception e) {
            // Safety net for unexpected exceptions
            System.err.println("Unexpected Error: " + e.getMessage());
 
        }
        finally {
            // ✅ Always executes
            System.out.println("===== Calculator Demo Finished =====");
        }
 
        /*
         -----------------------------------------------------
         Trigger UNCHECKED exception separately
         -----------------------------------------------------
         This block shows that unchecked exceptions
         can occur at runtime without 'throws'
        */
        try {
            System.out.println("Triggering Negative Number Exception:");
            System.out.println(calculator.multiply(-5, 2));
        }
        catch (NegativeNumberException e) {
            System.err.println("ERROR (Negative Number): " + e.getMessage());
        }
 
    }
}