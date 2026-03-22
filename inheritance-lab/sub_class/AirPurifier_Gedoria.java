package sub_class;

import parent_class.Appliances_Arban;

// Child Class of Appliances_Arban, created by Rajan Gedoria

public class AirPurifier_Gedoria extends Appliances_Arban {

    // Unique attributes
    private int airQualityIndex;
    private String filterType; 

    // Constructor
    public AirPurifier_Gedoria(String type, String brand, int stock, boolean power, int airQualityIndex, String filterType) {
        super(); // call parent constructor

        // Override parent attributes
        this.type = type;
        this.brand = brand;
        this.stock = stock;
        this.power = power;

        // Child-specific attributes
        this.airQualityIndex = airQualityIndex;
        this.filterType = filterType;
    }

    // Getter and Setter for airQualityIndex
    public int getAirQualityIndex() {
        return airQualityIndex;
    }

    public void setAirQualityIndex(int airQualityIndex) {
        this.airQualityIndex = airQualityIndex;
    }

    // Getter and Setter for filterType
    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    // Child-specific method
    public void displayAirPurifierInfo() {
        System.out.println("=== Air Purifier Information ===");
        System.out.println("Brand: " + brand);
        System.out.println("Type: " + type);
        System.out.println("Stock: " + stock);
        System.out.println("Air Quality Index: " + airQualityIndex);
        System.out.println("Filter Type: " + filterType);
        System.out.println("Power Status: " + (power ? "ON" : "OFF"));
    }

    // Override parent method
    @Override
    public void action() {
        System.out.println("Purifying air using your " + brand + " " + type);
    }
}