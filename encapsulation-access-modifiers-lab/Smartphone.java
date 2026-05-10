/*
* This class represents an Smartphone with a brand, model, battery level and storage.
* ALso checks if it phone is locked
* Created by Rajan Kurt O. Gedoria
* AI was used to verify if code is following the instructions
*/
public class Smartphone {
    



    private String brand;
    private String model;
    private String phoneNumber;
    private double batteryLevel = 100;
    
    // Static attribute
    private static int totalPhones = 0;

    // Object Invariant - battery level must always be >= 0
    private boolean isLocked = true;

    private int storageGB = 128;

    // Default constructor
    public Smartphone() {
        this.brand = "Unknown Brand";
        this.model = "Unknown Model";
        this.phoneNumber = "Not Assigned";
        totalPhones++;
    }

    // Parameterized constructor
    public Smartphone(String brand, String model, String phoneNumber) {

        if(brand != null && !brand.isEmpty())
            this.brand = brand;
        else
            this.brand = "Unknown Brand";

        if(model != null && !model.isEmpty())
            this.model = model;
        else
            this.model = "Unknown Model";

        if(phoneNumber != null && !phoneNumber.isEmpty())
            this.phoneNumber = phoneNumber;
        else
            this.phoneNumber = "Not Assigned";

        totalPhones++;
    }

    // Getters
    public String getBrand() { return this.brand; }

    public String getModel() { return this.model; }

    public String getPhoneNumber() { return this.phoneNumber; }

    public double getBatteryLevel() { return this.batteryLevel; }

    public boolean isLocked() { return this.isLocked; }

    public int getStorageGB() { return this.storageGB; }

    public static int getTotalPhones() { return totalPhones; }

    // Setters with validation

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber != null && !phoneNumber.isEmpty())
            this.phoneNumber = phoneNumber;
        else
            System.out.println("Invalid phone number.");
    }

    public void setStorageGB(int storageGB) {
        // Validation rule: storage must be at least 32GB
        if(storageGB >= 32)
            this.storageGB = storageGB;
        else
            System.out.println("Storage must be at least 32GB.");
    }

    public void setBatteryLevel(double batteryLevel) {
        // Validation rule: battery must be between 0 and 100
        if(batteryLevel >= 0 && batteryLevel <= 100)
            this.batteryLevel = batteryLevel;
        else
            System.out.println("Battery level must be between 0 and 100.");
    }

    // Behaviors

    public void lockPhone() {
        this.isLocked = true;
    }

    public void unlockPhone() {
        this.isLocked = false;
    }

    public void useBattery(double amount) {
        // Validation rule: cannot reduce battery below 0
        if(amount > 0 && batteryLevel - amount >= 0)
            batteryLevel -= amount;
        else
            System.out.println("Not enough battery.");
    }

    public void chargeBattery(double amount) {
        if(amount > 0) {
            batteryLevel += amount;

            if(batteryLevel > 100)
                batteryLevel = 100;
        }
    }
}

