package sub_class;

import component_class.Clothes_Obedoza;

public class GhillieSuit_Onte extends Clothes_Obedoza {

    private int camoLevel; // 1 to 10

    // Constructor
    public GhillieSuit_Onte(String size, String color, double price, int camoLevel) {
        super("Ghillie Suit", size, color, price);
        this.camoLevel = camoLevel;
    }

    // Getter
    public int getCamoLevel() {
        return camoLevel;
    }

    // Setter
    public void setCamoLevel(int camoLevel) {
        if (camoLevel >= 1 && camoLevel <= 10) {
            this.camoLevel = camoLevel;
        } else {
            System.out.println("Invalid camo level!");
        }
    }

    // Override method
    @Override
    public void buyClothing() {
        System.out.println("Buying a ghillie suit...");
        super.describe();

        if (camoLevel >= 7) {
            System.out.println("Good camouflage for missions.");
        } else {
            System.out.println("Low camouflage, be careful.");
        }
    }

    // Override method
    @Override
    public void chooseColor() {
        if (getClotheColor().equalsIgnoreCase("Green")) {
            System.out.println("Perfect for forest camouflage.");
        } else {
            System.out.println("Not ideal for hiding.");
        }
    }

    // Unique behavior
    public void hide() {
        System.out.println("You hide using your ghillie suit...");
    }
}