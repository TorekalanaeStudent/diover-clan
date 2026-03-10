/*
* This class prepresents a product which has variables pertaining to its properties which are its model, year, roundsPerMinute, caliber, and manufacturer. It also takes note of the amount of products there are through use of the static variable "stock".
* Created by Sean Ethan Go
*/
public class Gun { 

    // Attributes
    String model;
    int year;
    int roundsPerMinute;
    String caliber;
    String manufacturer;

    static int stock = 0;

    // Default constructor
    public Gun() {
        
        model = "Unknown";
        year = 0;
        roundsPerMinute = 0;
        caliber = "Unknown";
        manufacturer = "Unknown";
        stock++;
        
    }
    // Parameterized constructor
    public Gun(String model, int year, int roundsPerMinute, String caliber, String manufacturer) {

        this.model = model;
        this.year = year;
        this.roundsPerMinute = roundsPerMinute;
        this.caliber = caliber;
        this.manufacturer = manufacturer;
        stock++;
        
    }
    // Overloaded constructor
    public Gun(String model, String manufacturer) {
        
        this.model = model;
        year = 0;
        roundsPerMinute = 0;
        caliber = "Unknown";
        manufacturer = "Unknown";
        stock++;
        
    }
    
    // Display method(Method with no params)
    public void displayInfo() {

        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Rounds Per Minute: " + roundsPerMinute);
        System.out.println("Caliber: " + caliber);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println();
        
    }
    // Method with parameters
    public void setInfo(String model, int year, int roundsPerMinute, String caliber, String manufacturer) {
        
    model = mod;
    year = yr;
    roundsPerMinute = rpm;
    caliber = cal;
    manufacturer = mf;

    }
    // Static method
    public static void displayTotalStock() {
        
        System.out.println("Total Guns:" + stock);
        
    }
    
}
