package main_class;

import parent_class.Drone_Onte;
import sub_class.RcCar_Ablis;
import sub_class.RcHelicopter_Ablis;

public class Main_Ablis {
    public static void main(String[] args) {

        // RcHelicopter 
        System.out.println("===== HELICOPTERS =====");

        // default constructor
        Drone_Onte heli1 = new RcHelicopter_Ablis();
        System.out.println("Model: " + heli1.getModel());
        heli1.fly();
        heli1.land();

        System.out.println();

        // parameterized constructor
        Drone_Onte heli2 = new RcHelicopter_Ablis("Align T-Rex 450", 80, 55.0, "coaxial", 3, 15.0);
        System.out.println("Model: " + heli2.getModel());
        heli2.fly();
        heli2.land();
        heli2.performTask();

        System.out.println();

        // static method
        RcHelicopter_Ablis.countHelicopters();

        // to access subclass getters
        RcHelicopter_Ablis heliCast = (RcHelicopter_Ablis) heli2;
        System.out.println("Rotor Type: " + heliCast.getHelicopterRotorType());
        System.out.println("Rotor Count: " + heliCast.getHelicopterRotorCount());
        System.out.println("Hover Altitude: " + heliCast.getHelicopterHoverAltitude());

        System.out.println();

        //  validation rule
        heliCast.setRotorType("tandem");
        System.out.println("Updated Rotor Type: " + heliCast.getHelicopterRotorType());

        // validation rule -invalid if blank
        heliCast.setRotorType("");

        // validation rule - invalid if negavtive
        heliCast.setHoverAltitude(-5.0);

        System.out.println();

        // RcCar Section 
        System.out.println("===== CARS =====");

        // default constructor
        RcCar_Ablis rcCar1 = new RcCar_Ablis();
        System.out.println("Model: " + rcCar1.getModel());
        System.out.println("Wheel Type: " + rcCar1.getWheelType());
        System.out.println("Wheel Count: " + rcCar1.getWheelCount());
        System.out.println("Max Speed: " + rcCar1.getMaxSpeed());
        rcCar1.drive();
        rcCar1.brake();
        rcCar1.performTask();

        System.out.println();

        // validattion rule
        rcCar1.setWheelType("street");
        System.out.println("Updated Wheel Type: " + rcCar1.getWheelType());

        // validation rule - invalid wheel type bcuz street, rally, and offroad are the only accepted type
        rcCar1.setWheelType("monster");

        // validationn rule - invalid if blank
        rcCar1.setWheelType("");

        System.out.println();

        // parameterized constructor
        RcCar_Ablis rcCar2 = new RcCar_Ablis("HPI RS4 Sport 3", 90, 45.0, "rally", 4, 120.0);
        System.out.println("Model: " + rcCar2.getModel());
        System.out.println("Wheel Type: " + rcCar2.getWheelType());
        System.out.println("Wheel Count: " + rcCar2.getWheelCount());
        System.out.println("Max Speed: " + rcCar2.getMaxSpeed());
        rcCar2.drive();
        rcCar2.brake();

        System.out.println();

        // validation rulle - negative speed
        rcCar2.setMaxSpeed(-50.0);

        // validation rule - valid max speed
        rcCar2.setMaxSpeed(150.0);
        System.out.println("Updated Max Speed: " + rcCar2.getMaxSpeed());

        System.out.println();

        // 
        RcCar_Ablis.countCars();
    }
}