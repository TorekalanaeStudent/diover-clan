package implementations;

import abstract_classes.GameCharacter_Navarro;
import interfaces.CombatSystem_Navarro;

/**
 * @author Canillo, Diover Vincent
 * @TorekalanaeStudent
 */

public class GreekGod_Canillo extends GameCharacter_Navarro implements CombatSystem_Navarro{

    private String innateDomain; // can be sea like sky, underworld, earth, stuff like that
    private String sacredWeapon; // like the trident and stuff 
    private boolean immortal; // full god so most likely immortal (can be killed with divine weapons)
    private boolean defending;

    // Default Constructor
    public GreekGod_Canillo(){
        super("Zeus", 100);
        innateDomain = "Sky";
        sacredWeapon = "Thunderbolt";
        immortal = true;
    }

    // Overloaded Constructor
    public GreekGod_Canillo(String name, int health, String innateDomain, String sacredWeapon){
        super(name, health);
        setDomain(innateDomain);
        setSacredWeapon(sacredWeapon);
        setImmortal(true);
    }

    // Parameterized Constructor
    public GreekGod_Canillo(String name, int health, String innateDomain, String sacredWeapon, boolean immortal){
        super(name, health);
        setDomain(innateDomain);
        setSacredWeapon(sacredWeapon);
        setImmortal(immortal);
    }

    // OVERRIDES
    // --- ABSTRACT CLASS ---
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

    @Override
    public String getRole(){
        return "God of " + getDomain();
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
    public String getDomain(){return this.innateDomain;}
    public String getWeapon(){return this.sacredWeapon;}
    public boolean isImmortal(){return this.immortal;}
    public boolean isDefending(){return this.defending;}

    // Setters
    public void setDomain(String domain){
        // rule validation again, if blank will set it to default
        if(domain.isBlank() || domain.equals(null)){
            System.out.println("Innate Domain set to: Sky");
            this.innateDomain = "Sky";
            return;
        }
        System.out.println("Innate Domain set to: " + domain);
        this.innateDomain = domain;
    }

    public void setSacredWeapon(String sacredWeapon){
        // rule validation again, if blank will set it to fist again lol
        if(sacredWeapon.isBlank() || sacredWeapon.equals(null)){
            System.out.println("Sacred Weapon set to: Fist");
            this.innateDomain = "Fist";
            return;
        }
        System.out.println("Sacred Weapon set to: " + sacredWeapon);
        this.sacredWeapon = sacredWeapon;
    }

    public void setImmortal(boolean immortal){
        this.immortal = immortal;
    }

}