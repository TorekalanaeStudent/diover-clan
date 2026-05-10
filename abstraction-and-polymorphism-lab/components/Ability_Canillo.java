package components;

import abstract_classes.GameCharacter_Navarro;

public class Ability_Canillo {
    private String name;
    private int power;

    // Parameterized Constructor
    public Ability_Canillo(String name, int power){
        this.name = name;
        this.power = power;
    }

    public void use(GameCharacter_Navarro user){
        System.out.println(user.getName() + "  uses " + name + " (Power: " + power + ")");
    }

    public String getName(){ return name; }
    public int getPower(){ return power; }

}