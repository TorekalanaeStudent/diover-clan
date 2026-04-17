package implementations;

import abstract_classes.Vehicles_DeJuras;
import interfaces.VehicleSystem_DeJuras;

public class Car_Obedoza extends Vehicles_DeJuras implements VehicleSystem_DeJuras {
    
    // Attributes
    private int capacity;

    // Constructors
    public Car_Obedoza() {
         super("Dump Truck", "Mercedes", 6);
        this.capacity = 10000;
    }

    public Car_Obedoza(String name, String brand, int speed, int capacity) {
        super(name, brand, speed);
        this.capacity = capacity;
    }

    // Setters & Getter
    public int getCapacity() {return capacity;}
    public void setCapacity(int capacity) {this.capacity = capacity;}

    @Override
    public void accelerate() {
        speed += 10;
        System.out.println();
        System.out.println(name + " (Truck) accelerating. Speed: " + speed);
    }

    @Override
    public void accelerate(int targetSpeed) {
        speed = targetSpeed;
        System.out.println(name + " (Truck) reached " + speed + " km/h");
    }

    @Override 
    public void brake() {
        speed = 0;
        System.out.println(name + "Stopped");
    }
    
    @Override
    public void performSpecialFeature() {
        System.out.println(name + " unloading heavy cargo!");
    }

}