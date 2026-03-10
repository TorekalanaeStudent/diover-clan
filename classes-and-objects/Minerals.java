public class Minerals {

    // Attributes
    String mineralsName;

    String Color;
    String mineLocation;
    String Cords;
    int mineralsInInventory;

    // static Attributes
    static int totalMinerals = 0;
    public static String mineralsMiner = "Steve";

    // Default constructor
    Minerals() {
        this.mineralsName = "Diamond";
        this.color = "Cyan";
        this.Biome = "Mushroom islands";
        this.Cords = "-1500, -30, 60000";
        this.mineralsInInventory = 64;
        totalMinerals++;
    }
    // Parameteried constructor 
    Minerals(String mineralsName, String color, String Biome, String Cords, int mineralsInInventory) {
        this.mineralsName = mineralsName;
        this.Color = color;
        this.Biome = Biome;
        this.Cords = Cords;
        this.mineralsInInventory = mineralsInInventory;
        totalMinerals++;
    }
    // Overloaded constructor
    Minerals(String mineralsName,int mineralsInInventory) {
        this.mineralsName = mineralsName;
        this.Color = "NONE";
        this.Biome = "NONE";
        this.Cords = "NONE";
        this.mineralsInInventory = mineralsInInventory;
        totalMinerals++;
    }
    // Behavior without parameters
    void displayMinerals() {
        System.out.println("Minerals Name: "+ mineralsName);
        System.out.println("Color: "+ color);
        System.out.println("Biome: "+ Biome);
        System.out.println("Cords: "+ Cords);
        System.out.println("Minerals in inventory: "+mineralsInInventory);
    }
    // Behavior with Parameters
    void updateMineral(String newMineral) {
        System.out.println(mineralsMiner +"now has thrown out their "+mineralsName+" for "+newMinerals);
        mineralsName = newMinerals;
    }
    // Static method
    static void displayTotalMineralsInInventory () {
        System.out.println("Total Minerals In Inventory is "+totalMinerals);
    }
}
