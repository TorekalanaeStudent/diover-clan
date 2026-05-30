package interfaces;

/**
 * @author De Juras, Clint Norbert P.
 * @cdejuras
 */

public interface VehicleSystem_DeJuras {

    // Abstract Methods
    void accelerate();

    void accelerate(int targetSpeed); // Overloading

    void brake();

    void performSpecialFeature();

    // Default Methods
    default void refuel() {
        System.out.println("Refueling vehicle...");
    }

    default void displayInfo(String vehicleType) {
        System.out.println("Vehicle type: " + vehicleType);
    }
}