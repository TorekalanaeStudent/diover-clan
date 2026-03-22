/*
1. IS-A RELATIONSHIP: RcHelicopter_Ablis, and RcCar_Ablis are child classes of Drone_Onte.
2. OVERRIDEN: This method was overriden: public void performTask() 
3. DYNAMIC BINDING: rcCar1.drive(); is an example of dynamic binding because when I tell an instruction to perform their task, 
                    the helicopter and drone fly, and the car drives. It perform its dedicated method/task.
4. INHERITED METHODS: performTask()
                    Drone: (model + " is doing the task.");
                    RcCar: ("The RC car is driving around the track.");
                    RcHelicopter: (model + " floats at " + hoverAltitude + " meters with " + rotorCount + " " + rotorType + " rotors.");
5. NEW BEHAVIOUR FROM SUBCLASS: countHelicopters();
*/

package main_class;

import sub_class.RcHelicopter_Ablis;
import sub_class.RcCar_Ablis;
import parent_class.Drone_Onte;

public class Main_Ablis {

    public static void main(String[] args) {

        System.out.println("=== RC HELICOPTER SECTION ===");

        Drone_Onte heli1 = new RcHelicopter_Ablis();
        heli1.performTask(); // performTask was overridden in RcHelicopter_Ablis

        System.out.println();

        Drone_Onte heli2 = new RcHelicopter_Ablis("Align T-Rex 450", 80, 55.0, "coaxial", 3, 15.0);
        heli2.performTask();

        // new behaviour
        RcHelicopter_Ablis.countHelicopters();

        System.out.println(); 

        System.out.println("=== RC CAR SECTION ===");

        RcCar_Ablis rcCar1 = new RcCar_Ablis(); 
        rcCar1.drive();
        rcCar1.brake();

        rcCar1.setWheelType("monster"); // rule validation - invalid type

        System.out.println("Model: " + rcCar1.getModel());
        System.out.println("Wheel Type: " + rcCar1.getWheelType());
        System.out.println("Wheel Count: " + rcCar1.getWheelCount());
        System.out.println("Max Speed: " + rcCar1.getMaxSpeed());

        System.out.println(); 

        RcCar_Ablis rcCar2 = new RcCar_Ablis("HPI RS4 Sport 3", 90, 45.0, "rally", 4, 120.0);

        rcCar2.setWheelType("street");

        System.out.println("Model: " + rcCar2.getModel());
        System.out.println("Wheel Type: " + rcCar2.getWheelType());
        System.out.println("Wheel Count: " + rcCar2.getWheelCount());
        System.out.println("Max Speed: " + rcCar2.getMaxSpeed());

    }
}
