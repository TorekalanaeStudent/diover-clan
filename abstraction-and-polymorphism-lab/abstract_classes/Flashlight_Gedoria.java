// Abstract Class by: Rajan Kurt O. Gedoria

public abstract class Flashlight_Gedoria {

    String model;
    int batteryLevel;

    // Constructor
    public Flashlight_Gedoria(String model, int batteryLevel) {
        this.model = model;
        this.batteryLevel = batteryLevel;
    }

    // Abstract method (must be implemented by subclasses)
    public abstract void turnOn();
    public abstract void turnOff();

    // Concrete method
    public void showBatteryStatus() {
        System.out.println("Battery level: " + batteryLevel + "%");
    }
}