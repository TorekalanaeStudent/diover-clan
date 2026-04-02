package interfaces;

/**
 * @author Canillo, Diover Vincent L.
 * @TorekalanaeStudent 
 */

public interface BendingSystem_Canillo{

    // Abstract Method
    void performAttack();
    
    void performAttack(String target); // Overloading

    void performDefense();

    void performSpecialAttack();

    // Default Method
    default void meditate(){
        System.out.println("Meditating..");
    }

    default void displayElement(String elementStyle){
        System.out.println("Bender controls: " + elementStyle);
    }
}