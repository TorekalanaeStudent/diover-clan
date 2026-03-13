/*
* This class represents an Electric Kettle with a brand, capacity, temperature, and lid status.
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
    private static int totalThermosCreated = 0;

    // Constructor 1
    public ElectricKettle() {
        brand = "Hanabishi";
        capacityMl = 1700;
        currentVolumeMl = 0;
        temperatureCel = 25;
        lidLocked = false;
        totalThermosCreated++;
    }

    // Constructor 2
    public ElectricKettle(String brand, double capacityMl) {
        if (brand != null && !brand.isEmpty()) {
            this.brand = brand;
        } else {
            this.brand = "Unknown";
        }

        if (capacityMl > 0) {
            this.capacityMl = capacityMl;
        } else {
            this.capacityMl = 1700;
        }

        this.currentVolumeMl = 0;
        this.temperatureCel = 25;
        this.lidLocked = false;

        totalThermosCreated++;
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

    public static int getTotalThermosCreated() {
        return totalThermosCreated;
    }

    // SETTERS

    // Validation 1: Brand
    public void setBrand(String brand) {
        if (brand != null && !brand.isEmpty()) {
            this.brand = brand;
        }
    }

    // Validation 2: Capacity
    public void setCapacityMl(double capacityMl) {
        if (capacityMl > 0) {
            this.capacityMl = capacityMl;
        }
    }

    // Validation 3: Temperature
    public void setTemperatureCel(double temperatureCel) {
        if (temperatureCel >= -20 && temperatureCel <= 120) {
            this.temperatureCel = temperatureCel;
        }
    }

    // BEHAVIOURS

    // Behaviour 1
    public void pourLiquid(double amount) {
        if (!lidLocked && amount > 0 && currentVolumeMl + amount <= capacityMl) {
            currentVolumeMl += amount;
            System.out.println(amount + "ml poured into the kettle.");
        } else {
            System.out.println("Cannot pour liquid.");
        }
    }

    // Behaviour 2
    public void drinkLiquid(double amount) {
        if (amount > 0 && amount <= currentVolumeMl) {
            currentVolumeMl -= amount;
            System.out.println("You drank " + amount + " ml.");
        } else {
            System.out.println("Not enough liquid.");
        }
    }

    // Behaviour 3
    public void lockLid() {
        lidLocked = true;
        System.out.println("Lid is locked.");
    }

    // Behaviour 4
    public void unlockLid() {
        lidLocked = false;
        System.out.println("Lid is unlocked.");
    }
}