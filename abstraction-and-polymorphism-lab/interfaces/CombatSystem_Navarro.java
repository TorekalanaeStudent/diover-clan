package interfaces;

public interface CombatSystem_Navarro {

	    // Abstract method
	    void attack(GameCharacter_Navarro target);

	    // Default method
	    default void defend() {
	    	System.out.println("The Character takes a defensive stance!!!");
	    }
	}