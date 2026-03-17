package main_class;


import parent_class.Wood_Canillo;
import sub_class.CrimsonWood_Go;
import sub_class.WarpedWood_Go;

public class Main {
    public static void main(String[] args) {
        // Create a CrimsonWood object
        CrimsonWood_Go crimson = new CrimsonWood_Go();
        System.out.println("---- CrimsonWood ----");
        crimson.burn();   // new behavior
        crimson.knock();  // overridden behavior
        System.out.println("Name: " + crimson.getWoodName());

        System.out.println();

        // Create a WarpedWood object
        WarpedWood_Go warped = new WarpedWood_Go();
        System.out.println("---- WarpedWood ----");
        warped.burn();    // new behavior
        warped.knock();   // overridden behavior
        System.out.println("Name: " + warped.getWoodName());
    }
}
