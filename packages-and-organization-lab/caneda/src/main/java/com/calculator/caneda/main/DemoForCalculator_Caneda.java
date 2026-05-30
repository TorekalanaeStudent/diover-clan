package com.calculator.caneda.main;

import com.calculator.caneda.service.SimpleCalculator;
import com.calculator.caneda.exceptions.*;
import java.util.*;

// Code-Based Analysis
/**
 * Q1: How did you organize your packages?
 * A1: Through multiple folders being organized that somewhat copies industry practices
 * 
 * Q2: Why did you separate your classes this way?
 * A2: To practice near industry practices that would be advantages for skills gathering
 * 
 * Q3: How do packages improve encapsulation?
 * A3: Packages improve encapsulation by separating folders into their own designated areas of logic, and
 *     by keeping major functions into single responsibilities
 * 
 * Q4: Where are your exceptions located?
 * A4: The exceptions are located in com.calculator.caneda.exceptions
 * 
 * Q5: Why did you choose Maven or Gradle?
 * A5: I chose Gradle because i want to expand my knowledge in this build tool
 * 
 */

public class DemoForCalculator_Caneda {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String userChoice;
        int numIntA;
        int numIntB;
        double numDoubleA;
        double numDoubleB;
        boolean whileRunning = true;

        SimpleCalculator calc = new SimpleCalculator();

        System.out.println("=========== CALCULATOR ===========");

        try {   
            while(whileRunning){
            display();
                userChoice = in.nextLine();

            switch(userChoice){
                case "Addition" , "1" , "+": {  
                    System.out.println("Intergers only, yes or no?");
                     userChoice = in.nextLine();
                    if(userChoice.equals("yes") || userChoice.equals("y")){
                        numIntA = inPutIntNum(in);
                        numIntB = inPutIntNum(in);
                        System.out.println(calc.add(numIntA, numIntB));
                    }
                    else {
                        numDoubleA = inputDoubleNum(in);
                        numDoubleB = inputDoubleNum(in);
                        System.out.println(calc.add(numDoubleA, numDoubleB));
                    }
                    
                }
                break;
                
                case "Subtraction" , "2" , "-":{
                    System.out.println("Intergers only, yes or no?");
                     userChoice = in.nextLine();
                    if(userChoice.equals("yes") || userChoice.equals("y")){
                        numIntA = inPutIntNum(in);
                        numIntB = inPutIntNum(in);
                        System.out.println(calc.subtract(numIntA, numIntB));
                    }
                    else {
                        numDoubleA = inputDoubleNum(in);
                        numDoubleB = inputDoubleNum(in);
                        System.out.println(calc.subtract(numDoubleA, numDoubleB));
                    }
                    
                }
                
                break;

                case "Multiplication" , "3" , "*":{
                    System.out.println("Intergers only, yes or no?");
                     userChoice = in.nextLine();
                    if(userChoice.equals("yes") || userChoice.equals("y")){
                        numIntA = inPutIntNum(in);
                        numIntB = inPutIntNum(in);
                        System.out.println(calc.multiply(numIntA, numIntB));
                    }
                    else {
                        numDoubleA = inputDoubleNum(in);
                        numDoubleB = inputDoubleNum(in);
                        System.out.println(calc.multiply(numDoubleA, numDoubleB));
                    }
                    
                }
                
                break;
                
                case "Division" , "4" , "/":{
                    System.out.println("Intergers only, yes or no?");
                     userChoice = in.nextLine();
                    if(userChoice.equals("yes") || userChoice.equals("y")){
                        numIntA = inPutIntNum(in);
                        numIntB = inPutIntNum(in);
                        System.out.println(calc.divide(numIntA, numIntB));
                    }
                    else {
                        numDoubleA = inputDoubleNum(in);
                        numDoubleB = inputDoubleNum(in);
                        System.out.println(calc.divide(numDoubleA, numDoubleB));
                    }
                    
                }
                
                break;

                case "Exit" , "5": {
                    whileRunning = false;
                    in.close();
                }

                default: {
                    System.out.println("Invalid option");
                }
                    
                
            
            }
            }
        } catch (ZeroDivisionException e) {
            System.out.println("Checked Exception Caught: " + e.getMessage());

        } catch (NegativeNumberException e) {
            System.out.println("Unchecked Exception Caught: " + e.getMessage());

        } catch (InputMismatchException e) {
            System.out.println("Checked Exception Caught: " + e.getMessage());
        }
          catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());

        } finally {
            System.out.println("Operations attempted: " + calc.getOperationCount());
            System.out.println("\nCleaning up resources..."); // just to make it cooler fr
        }

        System.out.println("\n[Brought to you by " + calc.getName() + "]");
        System.out.println("\n \nCaneda, Ramil Jr"+
         "\n=========== FIN ===========");
    
                
            
        }
    
public static void display() {
    System.out.println("Enter Operation"+
                    "\n1. Addition"+
                    "\n2. Subtraction"+
                    "\n3. Mulitiplication"+
                    "\n4. Division"+
                    "\n5. Exit");
}
public static int inPutIntNum (Scanner in) {
    System.out.print("Num: ");
    int numInt = in.nextInt();
    return numInt;
}
public static double inputDoubleNum (Scanner in) {
    System.out.print("Num: ");
    double numDouble = in.nextDouble();
    return numDouble;
}
} 
