package main_class;

import parent_class.Vehicle_Surname;
import sub_class.Car_Surname;

/*
    Q1: What is the IS-A relationship in your program?
    A1: The IS-A relationship in my program is the Vehicle_Surname and Car_Surname
        because Car_Surname extends Vehicle_Surname or an inheritance of Vehicle_Surname

    Q2: Which method was overridden?
    A2: The overriden method were:
        start(); and drive();

    Q3: What happens during dynamic binding?
    A3: Dynamic binding is the process of creating an object using the parent's class and then using the sub class as the new Constructor.
        It is shown in "Vehicle_Surname civi = new Car_Surname()".

    Q4: What methods were inherited from the parent class?
    A4: The method that were inherited from the parent class were:
        1. start();
        2. drive();
    
    Q5: What new behavior did the subclass introduce?
    A4: The new behaviors that the subclass introduced is:
        1. turnWheel();
            - Let's you turn the wheel left or right, if no direction was called or the wrong direction is called
              then it will follow the rule validation and then print out that that direction is not a direction.
*/

public class Main_Surname extends Car_Surname{
    public static void main(String[] args){
        // First object of Car_Surname:

        // default thing
        Vehicle_Surname civic = new Car_Surname();
        civic.start();
        civic.drive();
        
        System.out.println(); // spacer

        // Second object of Car_Surname:

        Car_Surname lancer = new Car_Surname("red", "Mitsubishi", "Lancer", 1973, 1.4);
        lancer.start();
        lancer.drive();

        lancer.turnWheel("up");
    }
}