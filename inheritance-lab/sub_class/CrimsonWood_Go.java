package sub_class;

import parent_class.Wood_Canillo;

public class CrimsonWood_Go extends Wood_Canillo {

    // static attribute
    private static boolean flammable;

    // attributes
    private String woodType;
    private String woodColor;
    private String woodName;

    // default constructor
    public CrimsonWood_Go() {
        super(); // calls Wood_Canillo constructor
        this.flammable = false;
        this.woodType = "Crimson";
        this.woodColor = "Maroon";
        this.woodName = "Go's Crimson Wood";
    }

    // behaviors
    public void burn() {
        // Access parent getter for woodName and flammable
        System.out.println(flammable ? getWoodName() + " is burning." : getWoodName() + " is flame resistant.");
    }

    // overridden behavior
    @Override
    public void knock() {
        System.out.println("You knocked on the wood for 5 times to test its durabilty.");
    }
   
    // Getters
    public String getWoodName(){
        return this.woodName;
    }

}
