package sub_class;

import parent_class.Wood_Canillo;

public class WarpedWood_Go extends Wood_Canillo {

    public WarpedWood_Go() {
        super();
    }

    @Override
    public void knock() {
        System.out.println("You knocked on the Warped wood a single time and it broke.");
    }
}
