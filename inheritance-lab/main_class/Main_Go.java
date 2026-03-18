package main_class;

import parent_class.Wood_Canillo;
import sub_class.WarpedWood_Go;
import sub_class.CrimsonWood_Go;

/**
 * Main_Go.java
 * Inheritance Demo Program
 * This was made using the Parent class Wood_Canillo
 *
 * ============================================================
 *  INHERITANCE BEHAVIOR ANALYSIS
 * ============================================================
 *
 * 1. WHAT IS THE IS-A RELATIONSHIP IN YOUR PROGRAM?
 *    - "WarpedWood IS-A Wood" because WarpedWood extends Wood and is a type of Wood.
 *    - "CrimsonWood IS-A Wood" because CrimsonWood extends Wood and is a type of Wood.
 *
 * 2. WHICH METHOD WAS OVERRIDDEN?
 *    - knock() was overridden in BOTH WarpedWood_Go and CrimsonWood_Go.
 *      Parent (Wood_Canillo)      - knock()
 *      WarpedWood_Go               - knock() prints "You knocked on the Warped wood once and it cracked."
 *      CrimsonWood_Go              - knock() prints "You knocked on the Crimson wood once and it sounded solid despite its weight."
 *
 * 3. WHAT HAPPENS DURING DYNAMIC BINDING?
 *     Even though the variable is typed as Wood_Canillo (or using the parent reference),
 *     Java calls the actual subclass's overridden method at runtime.
 *     For example:
 *         Wood_Canillo w = new WarpedWood_Go();
 *         w.knock(); // calls WarpedWood_Go.knock(), NOT Wood_Canillo.knock()
 *
 * 4. WHAT METHODS WERE INHERITED FROM THE PARENT CLASS?
 *    - burn() is inherited from Wood_Canillo and can be called directly.
 *    - getWoodName() is inherited and used in inspect() or other subclass methods.
 *    - All private attributes (woodType, woodColor, woodName) are inherited but accessed via public getters.
 *
 * 5. WHAT NEW BEHAVIOR DID THE SUBCLASSES INTRODUCE?
 *    - WarpedWood_Go introduced:
 *        age                      - Represents the age of the wood.
 *        weight                   - Represents how heavy the wood is.
 *        moss                     - Extra description of moss on the wood.
 *        texture()                - Prints texture details of the wood.
 *        mossOverGrowth(String)   - Prints moss coverage with intensity.
 *        inspect()                - Displays age, weight, and moss information.
 *        strip(String)            - Simulates stripping the wood with a tool.
 *
 *    - CrimsonWood_Go introduced:
 *        age                      - Represents the age of the wood.
 *        weight                   - Represents how heavy the wood is.
 *        moss                     - Extra description of moss on the wood.
 *        texture()                - Prints texture details of the wood (coarser than WarpedWood_Go).
 *        mossOverGrowth(String)   - Prints moss coverage with intensity.
 *        inspect()                - Displays age, weight, and moss information.
 *        strip(String)            - Simulates stripping the wood with a tool, with crimson flavor.
 *
 * ============================================================
 */

public class Main_Go {
    public static void main(String[] args) {

        // Create WarpedWood objects
        WarpedWood_Go warpedDefault = new WarpedWood_Go(); // default constructor
        WarpedWood_Go warpedParam = new WarpedWood_Go("Warped Oak", "Cyan", "Go's Wood", 12, "Heavy", "Mossy");

        // Create CrimsonWood objects 
        CrimsonWood_Go crimsonDefault = new CrimsonWood_Go(); // default constructor
        CrimsonWood_Go crimsonParam = new CrimsonWood_Go("Crimson Oak", "Red", "Canillo's Wood", 8, "Light", "None");

        //  Test WarpedWood 
        System.out.println("\n--- WarpedWood Default ---");
        warpedDefault.inspect();
        warpedDefault.knock();
        warpedDefault.texture();
        warpedDefault.mossOverGrowth("moderate");
        warpedDefault.strip("axe");

        System.out.println("\n--- WarpedWood Parameterized ---");
        warpedParam.inspect();
        warpedParam.knock();
        warpedParam.texture();
        warpedParam.mossOverGrowth("dense");
        warpedParam.strip("shovel");

        // Test CrimsonWood
        System.out.println("\n--- CrimsonWood Default ---");
        crimsonDefault.inspect();
        crimsonDefault.knock();
        crimsonDefault.texture();
        crimsonDefault.mossOverGrowth("light");
        crimsonDefault.strip("axe");

        System.out.println("\n--- CrimsonWood Parameterized ---");
        crimsonParam.inspect();
        crimsonParam.knock();
        crimsonParam.texture();
        crimsonParam.mossOverGrowth("none");
        crimsonParam.strip("pickaxe");
    }
}