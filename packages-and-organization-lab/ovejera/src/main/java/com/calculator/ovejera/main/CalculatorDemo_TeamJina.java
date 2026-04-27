package com.calculator.ovejera.main;

import com.calculator.ovejera.service.CalculatorClass_TeamJina;
import com.calculator.ovejera.exception.InvalidInputException_TeamJina;
import com.calculator.ovejera.exception.NegativeNumberException_TeamJina;

public class CalculatorDemo_TeamJina {

    public static void main(String[] args) {

        CalculatorClass_TeamJina calc = new CalculatorClass_TeamJina();

        System.out.println("========== MY CALCULATOR ==========\n");

        try {
            System.out.println("20 / 4 = " + calc.divide(20, 4));
            System.out.println("12.6 / 3.0 = " + calc.divide(12.6, 3.0));
        } catch (InvalidInputException_TeamJina | NegativeNumberException_TeamJina e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("10 / 0 = " + calc.divide(10, 0));
        } catch (InvalidInputException_TeamJina | NegativeNumberException_TeamJina e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("-10 / 2 = " + calc.divide(-10, 2));
        } catch (InvalidInputException_TeamJina | NegativeNumberException_TeamJina e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}