package abstract_classes;

/**
 * @author Navarro, Vince Justine Navarro
 * @StillLizard0106
 */
public abstract class GameCharacter_Navarro {
		
		// Attributes
	 	protected String name;
	    protected int health;
	 
	    // Constructor
	    public GameCharacter_Navarro(String name, int health){
	        this.name   = name;
	        this.health = health;
	    }
	 
	    // Abstract method - this will be overridden
	    public abstract String getStatus(); //This will check if the user is still alive or dead.
	    public abstract String getRole(); //This will get your role/class
	    
	    // Concrete method
		//This make it so you can attack someone or be the one who takes the damage.
	    public void takeDamage(int amount) {
	        health -= amount;
	        System.out.println(name + " took " + amount + " damage! HP: " + health + " left!!");
	    }
	  
	    // Getters
	    public String getName()   { return name; }
	    public int    getHealth() { return health; }
	}
