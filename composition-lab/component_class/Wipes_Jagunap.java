package component_class;
public class Wipes_Jagunap {

    // --- Private Attributes ---
    private String brand;
    private int moistureLevel;   // 1–100
    private boolean scented;

    // --- Constructor ---
    public Wipes(String brand, int moistureLevel, boolean scented) {
        setBrand(brand);
        setMoistureLevel(moistureLevel);
        this.scented = scented;
    }

    // --- Getters & Setters (Encapsulation) ---

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        // Validation: brand cannot be empty
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty.");
        }
        this.brand = brand;
    }

    public int getMoistureLevel() {
        return moistureLevel;
    }

    public void setMoistureLevel(int moistureLevel) {
        // Validation: moisture must be between 1 and 100
        if (moistureLevel < 1 || moistureLevel > 100) {
            throw new IllegalArgumentException("Moisture level must be between 1 and 100.");
        }
        this.moistureLevel = moistureLevel;
    }

    public boolean isScented() {
        return scented;
    }

    public void setScented(boolean scented) {
        this.scented = scented;
    }

    // --- Behaviors (Methods) ---

    // Method 1: Clean the nose
    public void cleanNose() {
        if (moistureLevel < 10) {
            throw new IllegalStateException("Wipe is too dry to clean the nose safely.");
        }
        System.out.println("Cleaning the nose gently with " + brand + " wipe...");
        moistureLevel -= 10; // moisture decreases when used
    }

    // Method 2: Re-moisten the wipe
    public void remoisten(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }

        moistureLevel += amount;

        if (moistureLevel > 100) {
            moistureLevel = 100; // cap moisture at 100
        }
    }
}
