package implementations;

import abstract_classes.GameCharacter_Navarro;
import interfaces.CombatSystem_Navarro;

/**
 * @author Canillo, Diover Vincent
 * @TorekalanaeStudent
 */

public class DemiGod_Canillo extends GameCharacter_Navarro implements CombatSystem_Navarro{
    // Attribute(s)
    private double strength;
    private String title;
    private String weapon;
    private boolean defending;

    // Default Constructor
    public DemiGod_Canillo(){
        super("Kratos", 100);
        setStrength(100);
        setTitle("God of War");
        setWeapon("Blade of Olympus");
    }

    // Parameterized Constructor
    public DemiGod_Canillo(String name, int health, int strength, String title, String weapon){
        super(name, health);
        setStrength(strength);
        setTitle(title);
        setWeapon(weapon);
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
    private void atk(GameCharacter_Navarro enemy){
        // Ternary Operator Logic: 
        // if weapon IS (ignore cases) "fist", then print punch
        // if weapon is NOT (ignore cases) "fist", then attacked
        System.out.println((getWeapon().equalsIgnoreCase("fist")
        ? getName() + " punched " + enemy.getName() + "!" 
        : getName() + " attacked " + enemy.getName() + " with The " + getWeapon() + "!"));
        this.defending = false;
    }

    @Override
    public void attack(GameCharacter_Navarro enemy){
        atk(enemy);
    }

    // overloaded attack
    public void attack(GameCharacter_Navarro enemy, int damage){
        atk(enemy);
        System.out.println("dealt " + damage);
    }

    @Override
    public void defend(){
        CombatSystem_Navarro.super.defend();
        this.defending = true;
    }

    // Getters
    public double getStrength(){return this.strength;}
    public String getTitle(){return this.title;}
    public String getWeapon(){return this.weapon;}
    public boolean isDefending(){return this.defending;}

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

    public void setWeapon(String weapon){
        // sets the weapon to "Fist" if none is inputted
        if(weapon.isBlank() || weapon.equals(null)){
            System.out.println("Weapon set to: Fist");
            this.weapon = weapon;
            return; // stops the program so it doesn't go to the next code block
        }
        System.out.println("Weapon set to: " + weapon);
        this.weapon = weapon;
    }
}