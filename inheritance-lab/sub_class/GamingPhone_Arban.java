package sub_class;

import parent_class.Smartphone_Gedoria;

public class GamingPhone_Arban extends Smartphone_Gedoria {

    // Additional attributes
    private int ram;
    private int batteryCapacity;

    // Default Constructor
    public GamingPhone_Arban() {
        super("iPhone", "iPhone 12 mini", "iOS", false);
        ram = 0;
        batteryCapacity = 0;
    }

    // Parameterized Constructor
    public GamingPhone_Arban(String operatingSystem, boolean powerStatus,
                             int ram, int batteryCapacity) {
        super("iPhone", "iPhone 12 mini", operatingSystem, powerStatus);
        this.ram = ram;
        this.batteryCapacity = batteryCapacity;
    }

    // Display specs
    public void displaySpecs() {
        System.out.println("=== Gaming Phone Specs ===");
        System.out.println("Brand: " + brand); // iPhone
        System.out.println("Model: " + model); // iPhone 12 mini
        System.out.println("OS: " + operatingSystem);
        System.out.println("Power Status: " + (powerStatus ? "ON" : "OFF"));
        System.out.println("RAM: " + ram + "GB");
        System.out.println("Battery: " + batteryCapacity + "mAh");
    }

    // Gaming mode
    public void enableGamingMode() {
        if (powerStatus) {
            System.out.println("Gaming Mode Activated");
        } else {
            System.out.println("Cannot enable Gaming Mode. Phone is OFF.");
        }
    }
}