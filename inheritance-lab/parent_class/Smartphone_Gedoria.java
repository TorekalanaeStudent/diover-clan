package parent_class;
/*
 * Parent Class
 * This class is made by Rajan Kurt O. Gedoria
 */

public class Smartphone_Gedoria {
    
    // Attributes
    protected String brand;
    protected String model;
    protected String operatingSystem;
    protected boolean powerStatus;

    // Default Constructor
    public Smartphone_Gedoria() {
        brand = "NA";
        model = "NA";
        operatingSystem = "NA";
        powerStatus = false;
    }

    // Parameterized Constructor
    public Smartphone_Gedoria(String brand, String model, String operatingSystem, boolean powerStatus) {
        this.brand = brand;
        this.model = model;
        this.operatingSystem = operatingSystem;
        this.powerStatus = powerStatus;
    }

    // Behaviors

    // Behavior #1: Validate Inputs
    public void checkDeviceInputs() {

        // Check brand
        if (brand == null) {
            System.out.println("Device has no brand");
        } else {
            System.out.println("Brand is set");
        }

        // Check model
        if (model == null) {
            System.out.println("Device has no model");
        } else {
            System.out.println("Model is set");
        }

        // Check operating system
        if (operatingSystem == null) {
            System.out.println("No operating system specified");
        } else {
            System.out.println("Operating system is set");
        }
    }

    // Behavior 2: Check Power Status
    public void checkPowerStatus() {
        if (powerStatus == false) {
            System.out.println("Smartphone is OFF");
        } else {
            System.out.println("Smartphone is ON");
        }
    }
}
