package com.calculator.arban.main;

import com.calculator.arban.service.AbstractCalculator;
import com.calculator.arban.service.Calculator;
import com.calculator.arban.service.CalculatorSystem;
import com.calculator.arban.exception.*;
/**
 * Arban, Jhave P.
 * @author @jhavearban-ctrl
  * 1. HOW DID YOU ORGANIZE YOUR PACKAGES?
 *    I organized the project into four packages based on responsibility:
 *    - com.calculator.arban.main      → entry point / demo runner
 *    - com.calculator.arban.service   → business logic (interface, abstract class, implementation)
 *    - com.calculator.arban.exception → custom exception classes
 *    Each package has a single, clear purpose.
 *
 * 2. WHY DID YOU SEPARATE YOUR CLASSES THIS WAY?
 *    Separating classes by role makes the code easier to read, maintain,
 *    and extend. For example, exception handling is isolated in its own
 *    package so it can be reused without pulling in unrelated logic.
 *
 * 3. HOW DO PACKAGES IMPROVE ENCAPSULATION?
 *    Packages act as namespaces that group related classes together and
 *    control visibility. Classes can use package-private access to hide
 *    implementation details from other packages, enforcing boundaries
 *    between layers of the application.
 *
 * 4. WHERE ARE YOUR EXCEPTIONS LOCATED?
 *    All custom exceptions are located in:
 *    com.calculator.arban.exception
 *    - InvalidInputException.java  → checked exception (extends Exception)
 *    - DivisionByZeroException.java → checked exception (extends InvalidInputException)
 *
 * 5. WHY DID YOU CHOOSE GRADLE?
 *    Gradle was chosen because it is faster than Maven due to incremental
 *    builds and build caching. It also uses a Groovy/Kotlin DSL which is
 *    more concise than Maven's verbose XML configuration. Gradle is also
 *    the standard build tool used in this course workspace.
 * ============================================================
 */

public class CalculatorDemo_Arban{
    public static void main(String[] args) {

        // Default Constructor
        Calculator calc = new Calculator();

        System.out.println("==== " + calc.getCalculatorName().toUpperCase() + " ====");
        System.out.println();

        // Basic INT Operations
        System.out.println("==== BASIC INT OPERATIONS ====");
        calc.add(10, 5);
        calc.subtract(10, 5);
        calc.multiply(10, 5);

        System.out.println();

        // Basic DOUBLE Operations
        System.out.println("==== BASIC DOUBLE OPERATIONS ====");
        calc.add(10.5, 4.5);
        calc.subtract(10.5, 4.5);
        calc.multiply(10.5, 4.5);

        System.out.println();

        // Polymorphism via Abstract Class
        System.out.println("==== POLYMORPHISM VIA ABSTRACT CLASS ====");
        AbstractCalculator abstractCalc = calc;
        abstractCalc.add(20.0, 30.0);
        abstractCalc.subtract(50.0, 15.0);

        System.out.println();

        // Polymorphism via Interface
        System.out.println("==== POLYMORPHISM VIA INTERFACE ====");
        CalculatorSystem calcOps = calc;
        calcOps.add(100, 200);
        calcOps.subtract(100, 50);

        System.out.println();

        // Interface Default Method
        System.out.println("==== INTERFACE DEFAULT METHOD ====");
        calcOps.showOperation("Addition", calc.getLastResult());

        System.out.println();

        // Checked Exception
        System.out.println("==== CHECKED EXCEPTION: divide(int, int) ====");
        try {
            calc.divide(10, 2);
            calc.divide(10, 0);   // triggers InvalidInputException
        } catch (InvalidInputException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        } finally {
            System.out.println("INT division block executed.");
        }

        System.out.println();

        // Unchecked Exception
        System.out.println("==== UNCHECKED EXCEPTION: divide(double, double) ====");
        try {
            calc.divide(10.0, 2.0);
            calc.divide(10.0, 0.0);   // triggers DivisionByZeroException
        } catch (DivisionByZeroException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        } finally {
            System.out.println("DOUBLE division block executed.");
        }

        System.out.println();

        // Exception Propagation
        System.out.println("==== EXCEPTION PROPAGATION VIA INTERFACE ====");
        try {
            calcOps.divide(50, 0);
        } catch (InvalidInputException e) {
            System.out.println("Propagated exception caught: " + e.getMessage());
        } finally {
            System.out.println("Propagation block executed.");
        }
    }
}
