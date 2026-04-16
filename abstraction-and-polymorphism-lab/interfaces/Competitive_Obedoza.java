package interfaces;

/**
 * @author Obedoza, John Kyle B.
 * 
 */

public interface Competitive_Obedoza {
    
    // Abstract Method
    void compete (String focused, int adrenalineLevels);
    
    // Default method
    default void celebrateVictory() {
        System.out.println("Raises trophy and celebrates with the team!");
        System.out.println("Screams in super sayan mode!");
    }
}