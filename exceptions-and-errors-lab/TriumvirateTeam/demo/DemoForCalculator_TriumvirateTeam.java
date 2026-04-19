package demo;
/**
 * ANALYSIS
 * Q1: What exceptions did you create?
 * -We Created NegativeNumberException.java And ZeroDivisionException.java
 * 
 * Q2: Which are checked vs unchecked?
 * -ZeroDivisionException is Checked Exception, And NegativeNumberException is Unchecked Exception
 * 
 * Q3: Where are exceptions thrown?
 * -ZeroDivisionException is thrown in divide(), if user has divide by 0
 * -NegativeNumberException is thrown in Cases where negative numbers are invalid
 * 
 * Q4: Where are they handled?
 * -Exceptions are caught and handled within the demo or main class, using try catch blocks
 * 
 * Q5: Where does propagation occur?
 * -Propagation occurs when a method was thrown exceptions, but not being dealt within there.
 * 
 * Q6: How did you apply OOP concepts?
 * -We applied OOP concepts with their design principle being to promote single responsibilities in 
 *  methods, and or other classes, in encapsulation being getters and setters, in polymorphism being
 *  using the same function with a different angle. while not everything was used, majority of the  
 *  practices of OOP was used.
 */


import calculator_class.SimpleCalculator;
import exceptions.*; // did not import them 1 by 1 since its js 2 and we need both

public class DemoForCalculator_TriumvirateTeam {
    public static void main(String[] args) {

        SimpleCalculator calc = new SimpleCalculator();

        System.out.println("=========== CALC ===========\n(calc is short for calculator btw if u guys dont know)\n");

        try {
            // normal operation stuff
            System.out.println("Add: " + calc.add(1, 66));
            System.out.println("Subtract: " + calc.subtract(100, 33));

            // triggering unchecked exception
            System.out.println("Multiply: " + calc.multiply(-3, 13)); // will need to comment this so u can get to the checked exception
                                                                      // its just for demo so we dont really need to make this 
                                                                      // complicated 
            // triggering checked exception
            System.out.println("Divide: " + calc.divide(10, 0)); 

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
        System.out.println("\nMembers:" +
        "\nCanillo, Diover Vincent L." +
        "\nCaneda, Ramil Jr" +
        "\nNavarro, Vince Justin" +
        "\n=========== FIN ===========");
    }
}
