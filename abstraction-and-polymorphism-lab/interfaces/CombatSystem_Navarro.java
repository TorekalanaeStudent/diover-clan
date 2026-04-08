package interfaces;

import abstract_classes.GameCharacter_Navarro;

public interface CombatSystem_Navarro {

	    // Abstract method
	    void attack(GameCharacter_Navarro target); // overloading

	    // Default method
	    default void defend() {
	    	System.out.println("The Character takes a defensive stance!!!");
	    }
	}