package interfaces;

/**
 * @author Nono, Mary Angeline B.
 */

public interface FireAvatarSystem_Nono {

    // Abstract Methods
    void useSkill(int cost);
    void useSkill(int cost, String target); 
    void performAttack();
    void performAttack(String target); 
    void performDefense();
    void performSpecialAttack();

    String getAvatarType();

    
    // Default Methods
    default void meditate() {
        System.out.println("Avatar is meditating to restore energy...");
    }
    
    default void displayAffinity(String affinity) {
        System.out.println("Avatar affinity: " + affinity);
    }
}