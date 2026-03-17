package sub_class;

import parent_class.Wood_Canillo;

public class CrimsonWood_Go extends Wood_Canillo {

    public CrimsonWood_Go() {
        super();
    }

    @Override
    public void knock() {
        System.out.println("You knocked on the Crimson wood 10 times to test its strength.");
    }
}
