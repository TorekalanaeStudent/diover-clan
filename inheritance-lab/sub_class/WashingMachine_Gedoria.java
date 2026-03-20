package sub_class;

import parent_class.Appliances_Arban;

// Child Class 2 of Appliances_Arban, created by Rajan Gedoria

public class WashingMachine_Gedoria extends Appliances_Arban {

    // Unique attributes
    private int loadCapacity;
    private String washType; 

    // Constructor
    public WashingMachine_Gedoria(String type, String brand, int stock, boolean power, int loadCapacity, String washType) {
        super(); // call parent constructor

        // Override parent attributes
        this.type = type;
        this.brand = brand;
        this.stock = stock;
        this.power = power;

        // Child-specific attributes
        this.loadCapacity = loadCapacity;
        this.washType = washType;
    }

    // Getter and Setter for loadCapacity
    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    // Getter and Setter for washType
    public String getWashType() {
        return washType;
    }

    public void setWashType(String washType) {
        this.washType = washType;
    }

    // Child-specific method
    public void displayWashingMachineInfo() {
        System.out.println("=== Washing Machine Information ===");
        System.out.println("Brand: " + brand);
        System.out.println("Type: " + type);
        System.out.println("Stock: " + stock);
        System.out.println("Load Capacity: " + loadCapacity + " kg");
        System.out.println("Wash Type: " + washType);
        System.out.println("Power Status: " + (power ? "ON" : "OFF"));
    }

    // Override parent method
    @Override
    public void action() {
        if (power) {
            System.out.println("Washing clothes using your " + brand + " " + type);
        } else {
            System.out.println("Please turn on the washing machine first.");
        }
    }