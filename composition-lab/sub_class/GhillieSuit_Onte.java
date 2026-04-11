package sub_class;

import component_class.Clothes_Obedoza;

public class GhillieSuit_Onte extends Clothes_Obedoza {

    private int camoLevel; // 1 to 10

    // Default constructor
    public GhillieSuit_Onte() {
        super("Ghillie Suit", "Medium", "Green", 3500.00);
        this.camoLevel = 5;
    }

    // Parameterized constructor
    public GhillieSuit_Onte(String size, String color, double price, int camoLevel) {
        super("Ghillie Suit", size, color, price);
        setCamoLevel(camoLevel);
    }

    // Getter
    public int getCamoLevel() {
        return camoLevel;
    }

    // Setter with validation
    public void setCamoLevel(int camoLevel) {
        if (camoLevel >= 1 && camoLevel <= 10) {
            this.camoLevel = camoLevel;
        } else {
            System.out.println("Invalid camo level! Setting default value 5.");
            this.camoLevel = 5;
        }
    }

    // Override describe to clearly show parent class data
    @Override
    public void describe() {
        System.out.println("=== Ghillie Suit Details ===");
        System.out.println("Type: " + getClotheType());
        System.out.println("Size: " + getClotheSize());
        System.out.println("Color: " + getClotheColor());
        System.out.println("Price: " + getClothePrice());
        System.out.println("Camo Level: " + camoLevel);
    }

    // Override chooseColor
    @Override
    public void chooseColor() {
        if (getClotheColor().equalsIgnoreCase("Green")) {
            System.out.println("Ideal for forest camouflage environment.");
        } else {
            System.out.println("Color is not suitable for stealth missions.");
        }
    }

    // Override buyClothing
    @Override
    public void buyClothing() {
        System.out.println("Processing purchase of Ghillie Suit...");
        describe();

        if (getClothePrice() <= 4000) {
            System.out.println("Purchase Approved.");
        } else {
            System.out.println("Too expensive to buy.");
        }

        if (camoLevel >= 7) {
            System.out.println("High camouflage effectiveness.");
        } else {
            System.out.println("Low camouflage effectiveness.");
        }
    }

    // Unique method
    public void hide() {
        System.out.println("You are now blending into the environment using your ghillie suit.");
    }
}