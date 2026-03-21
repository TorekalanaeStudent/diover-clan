package sub_class;

import parent_class.Appliances_Arban;

// Child Class of Appliances_Arban, created by Rajan Gedoria

public class SmartTV_Gedoria extends Appliances_Arban {

    // Unique attributes for Smart TV
    private int screenSize;
    private String resolution;

    // Constructor
    public SmartTV_Gedoria(String type, String brand, int stock, boolean power, int screenSize, String resolution) {
        super(); // calls parent constructor

        // Override parent values
        this.type = type;
        this.brand = brand;
        this.stock = stock;
        this.power = power;

        // Child-specific attributes
        this.screenSize = screenSize;
        this.resolution = resolution;
    }

    // Getter and Setter for screenSize
    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    // Getter and Setter for resolution
    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    // Child-specific method
    public void displaySmartTVInfo() {
        System.out.println("=== Smart TV Information ===");
        System.out.println("Brand: " + brand);
        System.out.println("Type: " + type);
        System.out.println("Stock: " + stock);
        System.out.println("Screen Size: " + screenSize + " inches");
        System.out.println("Resolution: " + resolution);
        System.out.println("Power Status: " + power );
    }

    // Overriding parent method
    @Override
    public void action() {
        System.out.println("Streaming Netflix on your " + brand + " " + type);
    }
}