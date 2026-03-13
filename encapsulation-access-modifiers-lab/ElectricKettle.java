/*
* This class represents an Electric Kettle with a brand, capacity,
* temperature, and lid status.
* Created by Vince Gian Onte
*/

public class ElectricKettle {

    // Private Attributes
    private String brand;
    private double capacityMl;
    private double currentVolumeMl;
    private double temperatureCel;
    private boolean lidLocked;

    // Static Attribute
    private static int totalKettleCreated = 0;

    // Constructor 1 (Default)
    public ElectricKettle() {
        this("Hanabishi", 1700);
    }

    // Constructor 2 (Parameterized)
    public ElectricKettle(String brand, double capacityMl) {

        setBrand(brand);
        setCapacityMl(capacityMl);

        this.currentVolumeMl = 0;
        this.temperatureCel = 25;
        this.lidLocked = false;

        totalKettleCreated++;
    }

    // GETTERS
    public String getBrand() {
        return brand;
    }

    public double getCapacityMl() {
        return capacityMl;
    }

    public double getCurrentVolumeMl() {
        return currentVolumeMl;
    }

    public double getTemperatureCel() {
        return temperatureCel;
    }

    public boolean isLidLocked() {
        return lidLocked;
    }

    public static int getTotalKettleCreated() {
        return totalKettleCreated;
    }

    // SETTERS

    // Validation 1: Brand
    public void setBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand;
        } else {
            this.brand = "Unknown";
        }
    }

    // Validation 2: Capacity
    public void setCapacityMl(double capacityMl) {

        if (capacityMl <= 0) {
            System.out.println("Capacity must be positive.");
            return;
        }

        // Prevent capacity smaller than current water
        if (capacityMl < currentVolumeMl) {
            System.out.println("Capacity cannot be smaller than current liquid.");
            return;
        }

        this.capacityMl = capacityMl;
    }

    // Validation 3: Temperature
    public void setTemperatureCel(double temperatureCel) {

        if (currentVolumeMl == 0) {
            System.out.println("Cannot heat an empty kettle.");
            return;
        }

        if (temperatureCel < 0 || temperatureCel > 100) {
            System.out.println("Temperature must be between 0°C and 100°C.");
            return;
        }

        this.temperatureCel = temperatureCel;
    }

    // BEHAVIOURS

    // Behaviour 1: Pour liquid
    public void pourLiquid(double amount) {

        if (lidLocked) {
            System.out.println("Unlock the lid first.");
            return;
        }

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        if (currentVolumeMl + amount > capacityMl) {
            System.out.println("Not enough space in the kettle.");
            return;
        }

        currentVolumeMl += amount;
        System.out.println(amount + "ml poured into the kettle.");
    }

    // Behaviour 2: Drink liquid
    public void drinkLiquid(double amount) {

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        if (amount > currentVolumeMl) {
            System.out.println("Not enough liquid to drink.");
            return;
        }

        currentVolumeMl -= amount;
        System.out.println("You drank " + amount + " ml.");
    }

    // Behaviour 3: Lock lid
    public void lockLid() {
        lidLocked = true;
        System.out.println("Lid is locked.");
    }

    // Behaviour 4: Unlock lid
    public void unlockLid() {
        lidLocked = false;
        System.out.println("Lid is unlocked.");
    }
}