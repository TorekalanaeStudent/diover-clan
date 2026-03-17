package sub_class;

import parent_class.Wood_Canillo;

public class WarpedWood_Go extends Wood_Canillo {

    public WarpedWood_Go() {
        super();
        this.flammable = false;
        this.woodType = "Warped";
        this.woodColor = "Cyan";
        this.woodName = "Go's Warped Wood";
    }

    @Override
    public void burn() {
        System.out.println(flammable ? woodName + " is burning." : woodName + " is flame resistant.");
    }

    @Override
    public void knock() {
        System.out.println("You knocked on the wood for 5 times to test its hollowness.");
    }
}
