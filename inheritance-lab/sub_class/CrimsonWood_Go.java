package sub_class;

import parent_class.Wood_Canillo;

public class CrimsonWood_Go extends Wood_Canillo {

    public CrimsonWood_Go() {
        super();
        this.setFlammable(false);
        this.woodType = "Crimson";
        this.woodColor = "Maroon";
        this.woodName = "Go's Crimson Wood";
    }

    @Override
    public void burn() {
        System.out.println(isFlammable() ? getWoodName() + " is burning." : getWoodName() + " is flame resistant.");
    }

    @Override
    public void knock() {
        System.out.println("You knocked on the wood for 5 times to test its durability.");
    }

    public void setFlammable(boolean flammable) {
        this.flammable = flammable;
    }

    public boolean isFlammable() {
        return this.flammable;
    }

    public String getWoodName() {
        return this.woodName;
    }

}
