public class Tissue {

    // Private attributes
    private String brand;
    private int sheetCount;
    private boolean isMoist;

    // Constructor
    public Tissue(String brand, int sheetCount, boolean isMoist) {
        this.setBrand(brand);
        this.setSheetCount(sheetCount);
        this.setMoist(isMoist);
    }

    // ===== Getters =====
    public String getBrand() {
        return brand;
    }

    public int getSheetCount() {
        return sheetCount;
    }

    public boolean isMoist() {
        return isMoist;
    }

    // ===== Setters =====
    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty.");
        }
        this.brand = brand;
    }

    public void setSheetCount(int sheetCount) {
        if (sheetCount <= 0) {
            throw new IllegalArgumentException("Sheet count must be greater than 0.");
        }
        this.sheetCount = sheetCount;
    }

    public void setMoist(boolean isMoist) {
        this.isMoist = isMoist;
    }

    // ===== Behaviors =====
    public void useTissue(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (amount > sheetCount) {
            System.out.println("Not enough tissue left.");
        } else {
            sheetCount -= amount;
            System.out.println(amount + " tissue(s) used.");
        }
    }

    public void restock(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid restock amount.");
            return;
        }

        sheetCount += amount;
        System.out.println("Restocked " + amount + " tissues.");
    }
}