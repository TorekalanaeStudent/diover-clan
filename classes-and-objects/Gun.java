public class Gun { // Made by Sean Go

    // Attributes
    String model;
    int year;
    int roundsPerMinute;
    String caliber;
    String manufacturer;

        // Main method
    public static void main(String[] args) {

        Gun gunKalashnikov = new Gun("AK-47", 1947, 600, "7.62x39", "Kalashnikov Concern");
        Gun gunColt = new Gun("M4", 1994, 700, "5.56x45", "Colt");

        gunKalashnikov.displayInfo();
        gunColt.displayInfo();
    }

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