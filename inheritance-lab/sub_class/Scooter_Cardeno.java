package sub_class;

import parent_class.Vehicle_Nono;

public class Scooter_Cardeno extends Vehicle_Nono {

    // attribute for scooter
    protected int maxSpeed;

    // default constructor
    public Scooter_Cardeno() {
        super();
        this.vehicleType = "Scooter";
        this.vehicleName = "Nono's Scooter";
        this.vehicleColor = "Blue";
        this.maxSpeed = 40; // default max speed
    }
    // parameterized constructor
    public Scooter_Cardeno(String vehicleName, String vehicleColor, int maxSpeed) {
        super();
        this.vehicleType = "Scooter";
        this.vehicleName = vehicleName;
        this.vehicleColor = vehicleColor;
        this.maxSpeed = maxSpeed;
    }

    // overriding method
    @Override
    public void move() {
        System.out.println(vehicleName + " is moving at max speed of " + maxSpeed + " km/h.");
    }

    // new method
    public void brake() {
        System.out.println(vehicleName + " is braking to stop.");
    }

    // getter 
    public int getMaxSpeed() {
        return maxSpeed;
    }
    // setter
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}