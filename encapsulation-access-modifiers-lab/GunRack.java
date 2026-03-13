/*
* This class prepresents a product which has variables pertaining to its properties which are its model, year, roundsPerMinute, caliber, and manufacturer. It also takes note of the amount of products there are through use of the static variable "stock". Attributes are also privatized and values are accessed through getters and setters.
* Created by Sean Ethan Go
*/
public class GunRack { 

    // Attributes
    private String model;
    private int year;
    private int roundsPerMinute;
    private String caliber;
    private int penetration;
    private String manufacturer;
    private boolean isAvailable;

    private static int stock = 0;

    // Default constructor
    public GunRack() {
        
       model = "Unknown";
       year = 0;
       roundsPerMinute = 0;
       caliber = "Unknown";
       penetration = 0;
       manufacturer = "Unknown";
       isAvailable = true;
       stock++;
        
    }

    // Parameterized constructor
    public GunRack(String model, int year, int roundsPerMinute, String caliber, int penetration ,String manufacturer) {

        this.model = model;
        this.year = year;
        this.roundsPerMinute = roundsPerMinute;
        this.caliber = caliber;
        this.penetration = penetration;
        this.manufacturer = manufacturer;
        this.isAvailable = true;
        stock++;
        
    }

    // Overloaded constructor
    public GunRack(String model, String manufacturer) {
        
        this.model = model;
        year = 0;
        roundsPerMinute = 0;
        caliber = "Unknown";
        penetration = 0;
        this.manufacturer = manufacturer;
        isAvailable = true;
        stock++;
        
    }

    // Display method
    public void displayInfo() {

        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Rounds Per Minute: " + roundsPerMinute);
        System.out.println("Caliber: " + caliber);
        System.out.println("Penetration: " + penetration);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Available: " + isAvailable);
        System.out.println();
        
    }

    // Method with parameters
    public void setInfo(String model, int year, int roundsPerMinute, String caliber, int penetration , String manufacturer) {
        
        this.model = model;
        this.year = year;
        this.roundsPerMinute = roundsPerMinute;
        this.caliber = caliber;
        this.penetration = penetration;
        this.manufacturer = manufacturer;

    }

    // Static method
    public static void displayTotalStock() {
        
        System.out.println("Gun Choices: " + stock);
        
    }

    // Getters

    public String getModel() {
    return model;
    }

    public int getYear() {
    return year;
    }

    public int getRoundsPerMinute() {
    return roundsPerMinute;
    }

    public String getCaliber() {
    return caliber;
    }

    public int getPenetration() {
    return penetration;
    }

    public String getManufacturer() {
    return manufacturer;
    }

    public boolean isAvailable() {
    return isAvailable;
    }

    // Setters

    public void setModel(String model) {
    this.model = model;
    }

    public void setYear(int year) {

    if (year >= 0) {
        this.year = year;
    } else {
        System.out.println("Invalid year. Year must be greater than 0");
    }

    }

    public void setRoundsPerMinute(int roundsPerMinute) {

    if (roundsPerMinute >= 0) {
        this.roundsPerMinute = roundsPerMinute;
    } else {
        System.out.println("Invalid RPM. Value must be greater than 0.");
    }

    }

    public void setCaliber(String caliber) {
    this.caliber = caliber;
    }

    public void setPenetration(int penetration) {
    if (penetration >= 0) {
        this.penetration = penetration;
    } else {
        System.out.println("Invalid Penetration value. Value must be greater than 0.");
    }

    }

    public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
    }

    public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
    }