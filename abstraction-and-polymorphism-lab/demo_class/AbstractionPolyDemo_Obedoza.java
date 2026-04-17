package demo_class;

import implementations.Car_Obedoza;
import implementations.Truck_Obedoza;
import abstract_classes.Vehicles_DeJuras;
import interfaces.VehicleSystem_DeJuras;

//**
// Q1: What abstract class did you create?
// - The abstract class I created is Vehicles_DeJuras.java
// Q2: What interface did you create?
// - The interface I created is VehicleSystem_DeJuras.java
// Q3: What methods did you override?
// - The methods I overrode are accelerate() and performSpecialFeature() in both Car_Obedoza and Truck_Obedoza classes.
// Q4: What methods did you overload?
// - The method I overloaded is accelerate()
// Q5: Where does dynamic binding occur in your code?
// - Dynamic binding occurs when we call the accelerate() and performSpecialFeature() 
// methods on the VehicleSystem_DeJuras reference variables (vehicle1 and vehicle2) which are 
// referring to Car_Obedoza and Truck_Obedoza objects respectively
// Q6: Which shows polymorphism?
// - Polymorphism is shown when we call the accelerate() and performSpecialFeature() methods on the
// VehicleSystem_DeJuras reference variables (vehicle1 and vehicle2) which are referring to different 
// types of objects (Car_Obedoza and Truck_Obedoza) but still execute the correct overridden methods 
// based on the actual object type.
// Q7: How does your design achieve low coupling?
// - The design achieves low coupling by using interfaces and abstract classes. The Car_Obedoza and Truck_Obedoza 
// classes are not directly dependent on each other, and they both implement the VehicleSystem_DeJuras interface, 
// allowing for flexibility and separation of concerns.
// Q8: How does your design achieve high cohesion?
// - Each class has a single responsibility (Car, Truck, Vehicle system).
//  */

public class AbstractionPolyDemo_Obedoza {
    public static void main(String[] args){

        // Create Car Object
        Car_Obedoza car = new Car_Obedoza("Toyota Camry", "Sedan", 180, true);
        car.setModelName("Toyota Camry");
        car.setCarType("Sedan");
        car.setTopSpeed(180);
        car.setIsRunning(true);

        // Create Truck Object
        Truck_Obedoza truck = new Truck_Obedoza();
        truck.setCapacity(15000);

        // Display Car Information
        System.out.println("\nCar Information:");
        System.out.println("Model Name: " + car.getModelName());
        System.out.println("Car Type: " + car.getCarType());
        System.out.println("Top Speed: " + car.getTopSpeed() + " km/h");
        System.out.println("Is Running: " + (car.getIsRunning() ? "Yes" : "No"));

        // Display Truck Information
        System.out.println("\nTruck Information:");
        System.out.println("Name: " + truck.getName());
        System.out.println("Brand: " + truck.getBrand());
        System.out.println("Speed: " + truck.getSpeed() + " km/h");
        System.out.println("Capacity: " + truck.getCapacity() + " kg");

        // Demonstrate Polymorphism
        VehicleSystem_DeJuras vehicle1 = car; // Upcasting to interface
        VehicleSystem_DeJuras vehicle2 = truck; // Upcasting to interface

        System.out.println("\nDemonstrating Polymorphism:");
        vehicle1.accelerate();
        vehicle1.performSpecialFeature();
        
        vehicle2.accelerate(80);
        vehicle2.performSpecialFeature();

        

    }
}