package main_class;

import parent_class.Vehicle_Nono;
import sub_class.Scooter_Cardeno;
import sub_class.ElectricBike_Cardeno;

/*11. Analyzing the Inheritance Behavior
    1. What is the IS-A relationship in your program? 
        - Both Scooter_Cardeno and ElectricBike_Cardeno are types of Vehicle_Nono.
        - Therefore, Scooter_Cardeno IS-A Vehicle_Nono and ElectricBike_Cardeno IS-A Vehicle_Nono

    2. Which method was overridden? 
        - The move() method. This method was overridden because each subclass changed how move() works to show its own behavior. 
        - For example, the scooter shows max speed, the e-bike shows current speed.

    3. What happens during dynamic binding?
        - When I use Vehicle_Nono as a reference and assign it to a subclass object, 
        Java checks what the actual object is at runtime and runs that version of the method.

    4. What methods were inherited from the parent class?
        - The methods that were inherited from Vehicle_Nono (the parent class) were:
        1. start() 
        2. getVehicleName() 
        - Both subclasses can use these methods without writing them again.

    5. What new behavior did the subclass introduce?
        - The new behaviors that the subclasses introduced were:
        1. Scooter_Cardeno added brake(), so it can stop. 
        2. ElectricBike_Cardeno added accelerate(), so it can speed up. 
        - These are extra features that only the subclasses have.
    */

   
public class Main_Cardeno {

    public static void main(String[] args) {

        // create objects using parent reference (dynamic binding)
        Vehicle_Nono v1 = new Scooter_Cardeno();
        Vehicle_Nono v2 = new ElectricBike_Cardeno();

        // using inherited behavior
        v1.start();
        v2.start();

        // showing overridden methods
        v1.move();
        v2.move();

        // another dynamic binding example
        Vehicle_Nono v3 = new ElectricBike_Cardeno("E-Trikes", "Yellowski", 35);
        v3.move();
        Vehicle_Nono v4 = new Scooter_Cardeno("Mini Scooter", "Black", 45);
        v4.move(); 

        // calling subclass methods 
        Scooter_Cardeno s = new Scooter_Cardeno();
        s.brake();
        ElectricBike_Cardeno e = new ElectricBike_Cardeno();
        e.accelerate(10);
    }
}