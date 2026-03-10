/*
* This class represents a product which contains variables corresponding to its properties denoted by model, year, roundsPerMinute, caliber, manufacturer, and stock.
* Created by Sean Ethan Go
*/
public class Gun {

    // Attributes
    String model;
    int year;
    int roundsPerMinute;
    String caliber;
    String manufacturer;

    static int gunAmount = 0;

    // Parameterized constructor
    public Gun(String model, int year, int roundsPerMinute, String caliber, String manufacturer) {

        this.model = model;
        this.year = year;
        this.roundsPerMinute = roundsPerMinute;
        this.caliber = caliber;
        this.manufacturer = manufacturer;
        gunAmount++;
    }

    // Display method
    public static void displayInfo() {

        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Rounds Per Minute: " + roundsPerMinute);
        System.out.println("Caliber: " + caliber);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Stock:" + gunAmount);
        System.out.println();
        
    }
}
