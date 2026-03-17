package parent_class;
/**
 * 
 * Parent (Base) Class
 *
 * Represents the concept of a Game Character
 * This class is made by Vince Justine Navarro.
 */

public class RPG_Character_Navarro {
	
		// Attributes
	    String name;   
	    String alignment;   
	    int health;
	    int maxHealth;
	    int level;        
	    int attackPower;  
	    int defense;   
	    int mana;
	    
	    // Constructor
	    public RPG_Character_Navarro(String name, String alignment, int health, int attackPower, int defense, int mana) {
	        this.name       = name;
	        this.alignment    = alignment;	
	        this.health     = health;
	        this.maxHealth   = health;
	        this.level      = 1;
	        this.attackPower = attackPower;
	        this.defense    = defense;
	        this.mana = mana;
	    }
	        
	    // Behaviors (Methods) 
	    //This can be Overridden	
	    public void attack(RPG_Character_Navarro target) {
	        int damage = Math.max(0, this.attackPower - target.defense);
	        target.health -= damage;
	        System.out.println(name + " attacks " + target.name + " for " + damage + " damage!");
	    }
	    
	    public void heal(int amount) {
	        this.health = Math.min(this.health + amount, this.maxHealth);
	        System.out.println(name + " heals for " + amount + " HP. " +  "Current HP: " + health + "/" + maxHealth);
	    }
	    
	    
	    //Display the stats   
	    public void displayStats() {
	        System.out.println("==========================================");
	        System.out.println("  Name        : " + name);
	        System.out.println("  Alignment   : " + alignment);
	        System.out.println("  Level       : " + level);
	        System.out.println("  HP          : " + health + "/" + maxHealth);
	        System.out.println("  Attack      : " + attackPower);
	        System.out.println("  Defense     : " + defense);
	        System.out.println("  Mana        : " + mana);
	        System.out.println("==========================================");
	    }   
	        
	    //Checks if the character is still alive.
	    public boolean isAlive() {
	        return this.health > 0;
	    	}
	    }