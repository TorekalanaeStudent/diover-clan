package sub_class;

import parent_class.Wood_Canillo;

public class WarpedWood_Go extends Wood_Canillo {

    // Additional attributes for subclass
    private int age; 
    private String weight;
    private String moss;

    // Default constructor
    public WarpedWood_Go() {
        super(); // calls parent default constructor
        this.age = 9;
        this.weight = "Heavy";
        this.moss = "mild";
    }

    // Parameterized constructor
    public WarpedWood_Go(String woodType, String woodColor, String woodName, int age, String weight, String moss) {
        super(); // initializes parent fields
        this.age = age;
        this.weight = weight;
        this.moss = moss;

    }

    // Overridden methods

    @Override
    public void knock() {
        System.out.println("You knocked on the Warped wood once and it cracked.");
    }

    // New methods
    
    public void texture() {
        System.out.println("The wood is smooth to the touch; almost like satin.");
    }

    // Overloaded warp method with intensity parameter
    public void mossOverGrowth(String amount) {
        System.out.println("The wood is ensrouded in " + amount + " moss.");
    }

    // Inspect wood method
    public void inspect() {
        System.out.println(getWoodName() + " is " + age + " years old. Its weight is " + weight);
    }

    // Repair method
    public void strip(String tool) {
        System.out.println("Attempting to strip " + getWoodName() + " using " + tool + ".");
        if (tool.equals("axe")) {
            System.out.println("Strip successful, it has revealed a cyan inner layer.");
        } else {
            System.out.println("Strip unsuccessful, the wrong tool was used");
        }
    }

    // Getters

    public int getAge() {
        return age;
    }

    public String getWeight() {
        return weight;
    }

    public String getMoss() {
        return moss;
    }

    // Setters

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setMoss(String moss) {
        this.moss = moss;
    }
}