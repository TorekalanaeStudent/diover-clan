package sub_class;

import parent_class.Wood_Canillo;

public class CrimsonWood extends Wood_Canillo {

    public CrimsonWood() {
        super();
    }

    @Override
    public void knock() {
        System.out.println("You knocked on the Crimson wood gently.");
    }
}
