package sub_class;

import parent_class.Vehicle_Nono;

public class ElectricBike_Cardeno extends Vehicle_Nono {

    // attribute for ebike
    protected int speed; 

    // default constructor
    public ElectricBike_Cardeno() {
        super(); // calls Vehicle_Nono
        this.vehicleType = "Electric Bicycle";
        this.vehicleColor = "Black";
        this.vehicleName = "Nono's Ebike";
        this.speed = 20; // starting speed
    }

    // parameterized constructor
    public ElectricBike_Cardeno(String vehicleName, String vehicleColor, int speed) {
        super();
        this.vehicleType = "Electric Bicycle";
        this.vehicleName = vehicleName;
        this.vehicleColor = vehicleColor;
        this.speed = speed;
    }

    // overriding method
    @Override
    public void move() {
        System.out.println(vehicleName + " is moving at " + speed + " km/h.");
    }

    // new method 
    public void accelerate(int increase) {
        speed += increase;
        System.out.println(vehicleName + " accelerated! Current speed: " + speed + " km/h.");
    }

    // getter
    public int getSpeed() {
        return speed;
    }

    // setter
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}