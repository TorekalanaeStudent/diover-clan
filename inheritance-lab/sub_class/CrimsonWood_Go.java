package sub_class;

import parent_class.Wood_Canillo;

public class CrimsonWood_Go extends Wood_Canillo {

    // Additional attributes for subclass
    private int age; 
    private String weight;
    private String moss;

    // Default constructor
    public CrimsonWood_Go() {
        super(); // calls parent default constructor
        this.age = 5;
        this.weight = "Light";
        this.moss = "None";
    }

    // Parameterized constructor
    public CrimsonWood_Go(String woodType, String woodColor, String woodName, int age, String weight, String moss) {
        super(); // initializes parent fields
        this.age = age;
        this.weight = weight;
        this.moss = moss;
    }

    // Overridden method
    @Override
    public void knock() {
        System.out.println("You knocked on the Crimson wood once and it sounded solid despite its weight.");
    }

    // New methods
    public void texture() {
        System.out.println("The wood is coarse to the touch; caressing it would inflict pain.");
    }

    // Overloaded method
    public void mossOverGrowth(String amount) {
        System.out.println("The Crimson wood is ensrouded in " + amount + " moss.");
    }

    // Inspect wood method
    public void inspect() {
        System.out.println(getWoodName() + " is " + age + " years old. Its weight is " + weight + " and moss: " + moss);
    }

    // Repair method
    public void strip(String tool) {
        System.out.println("Attempting to strip " + getWoodName() + " using " + tool + ".");
        if ("axe".equals(tool)) {
            System.out.println("Strip successful, it revealed crimson red layers.");
        } else {
            System.out.println("Strip unsuccessful, wrong tool used");
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