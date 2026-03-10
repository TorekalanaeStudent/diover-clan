public class Gun { // Made by Sean Go

    // Attributes
    String model;
    int year;
    int roundsPerMinute;
    String caliber;
    String manufacturer;

    // Parameterized constructor
    public Gun(String model, int year, int roundsPerMinute, String caliber, String manufacturer) {

        this.model = model;
        this.year = year;
        this.roundsPerMinute = roundsPerMinute;
        this.caliber = caliber;
        this.manufacturer = manufacturer;
    }

    // Display method
    public void displayInfo() {

        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Rounds Per Minute: " + roundsPerMinute);
        System.out.println("Caliber: " + caliber);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println();
    }
}