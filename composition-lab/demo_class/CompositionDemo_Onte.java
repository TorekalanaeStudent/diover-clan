package demo_class;

import sub_class.GhillieSuit_Onte;
import component_class.Clothes_Obedoza;

public class CompositionDemo_Onte {

    public static void main(String[] args) {
        System.out.println("====== Composition Demo: GhillieSuit_Onte ======");

        // Create a GhillieSuit object
        GhillieSuit_Onte ghillieSuit = new GhillieSuit_Onte("Large", "Green", 250.50, 8);
        
        // Test the clothing methods
        ghillieSuit.buyClothing();
        System.out.println();
        
        ghillieSuit.chooseColor();
        System.out.println();
        
        // Test unique behavior
        ghillieSuit.hide();
    }
}