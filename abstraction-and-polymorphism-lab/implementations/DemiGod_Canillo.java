package implementations;

import abstract_classes.GameCharacter_Navarro;
import interfaces.CombatSystem_Navarro;

public class DemiGod_Canillo extends GameCharacter_Navarro implements CombatSystem_Navarro{
    // Attribute(s)
    private double strength;
    private String title;
    private boolean demiGodSet;

    // Default Constructor
    public DemiGod_Canillo(){
        super("Kratos", 100);
        setStrength(100);
        setTitle("God of War");
    }

    // Parameterized Constructor
    public DemiGod_Canillo(String name, int health, int strength, String title){
        super(name, health);
        setStrength(strength);
        setTitle(title);
    }

    // Overrides
    // --- ABSTRACT CLASS ---
    @Override
    public String getRole(){
        if(strength == 1000){
            return "The " + getTitle();
        }
        else if(strength >= 800){
            return "Legendary " + getTitle();
        } else if(strength >= 600){
            return "Elite " + getTitle();
        } else if(strength >= 400){
            return "Rising " + getTitle(); 
        } else if(strength >= 200){
            return "Trained " + getTitle();
        } else if(strength >= 100){
            return "Novice " + getTitle();
        } else if(strength >= 50){
            return "Awakened " + getTitle();
        } else{
            return "Dormant " + getTitle();
        }
    }

    // Status for Demi God's health status
    @Override
    public String getStatus(){
        int health = getHealth();
        
        if(health >= 80)
            return "Healthy";
        else if (health >= 50)
            return "Scratched";
        else if (health >= 25)
            return "Damaged";
        else
            return "In danger";
    }

    // --- INTERFACE ---
    @Override // for interface stuff
    public void attack(GameCharacter_Navarro enemy){
        System.out.println(getName() + " attacked " + enemy.getName() + "!");
    }

    // Getters
    public double getStrength(){return this.strength;}
    public String getTitle(){return this.title;}

    // Setters
    // setter that will set the strength
    public void setStrength(double strength){
        // strength cannot go above 1000 (its the MAX strength)
        // also cannot go below 0 since Kratos aint weak
        if(strength < 0 || strength > 1000){
            System.out.println("Invalid strength stat, try again!");
        } else{
            System.out.println("Strength set to: " + strength);
            this.strength = strength;
        }
    } 

    // a setter that will set the title of the demi god ex. "God of Pizza"
    public void setTitle(String title) {
        // Sets the title given to the Demi God
        if(title.isBlank() || title.equals(null)){
            System.out.println("Title cannot be blank, try again!");
        } else{
            System.out.println("Title set to: " + title);
            this.title = title;
        }
    }
}