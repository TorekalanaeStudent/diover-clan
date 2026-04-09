package implementations;
 
import abstract_classes.Bender_Canillo;
import interfaces.BendingSystem_Canillo;

/**
 * @author Navarro, Vince Justine
 * @StillLizard0106
 */

public class FireBending_Navarro extends Bender_Canillo implements BendingSystem_Canillo {
	// Default Constructor 
    public FireBending_Navarro(){
    	super();
	    setName("Dio");
	    setElementStyle("FireBender");
	    setHP(100);
	    setAge(20);
	    }

    
	//Parameterized Constructor
	public FireBending_Navarro (String name, String elementStyle, int health, int age) {
		super();
		setName(name);
		setElementStyle(elementStyle);
		setHP(health);
		setAge(age);
		}
		
	//Abstract Method
	 @Override
	    public void heal(int heal) {
	        if (heal < 0) {
	            System.out.println("FireBending Heal must cannot be negative.");
	            return;
	        }
	        int newHP = Math.min(getHP() + heal, 100);  // cannot exceed max HP
	        setHP(newHP);
	        System.out.println(getName()
	                + " channels his inner flame and heals " + heal
	                + " HP! Current HP: " + getHP());
	    }
	 //Interface Methods
	 	@Override
	    public void performAttack() {
	        System.out.println(getName()
	                + " launches a fire spark!");
	    }
	    
	    @Override
	    public void performAttack(String target) {
	        System.out.println(getName()
	                + " hits a fire spark directly at " + target + "!");
	    } 
	    
	    @Override
	    public void performDefense() {
	        System.out.println(getName()
	                + " raises a wall of fire as a shield!");
	    }
	     
	    @Override
	    public void performSpecialAttack() {
	        System.out.println(getName()
	                + " unleashes the Blazing sun!!");
	    }

		@Override
		public void meditate() {
	    System.out.println(getName() + " meditates inner fire..");
		}
	    
	  //Overloaded method
	    public void describe() {
	        System.out.println("Bender Info");
	        System.out.println("Name    : " + getName());
	        System.out.println("Element : " + getElementStyle());
	        System.out.println("HP      : " + getHP());
	        System.out.println("Age     : " + getAge());
	    }
	 
	    
	    public void describe(String title) {
	        System.out.println("=== " + title + " ===");
	        describe();  
	    }
	 
	   
	    public void describe(String title, String battleCry) {
	        describe(title);
	        System.out.println("Battle cry: \"" + battleCry + "\"");
	    }
	}
	

