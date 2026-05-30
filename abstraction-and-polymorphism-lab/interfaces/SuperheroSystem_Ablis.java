package interfaces;

/**
 * @author Ablis, Margreleigne M.
 * @matidagreat
 */

public interface SuperheroSystem_Ablis {
    // abstarct methods
    void performAttack();
    void performAttack(String target); // Overloading
    void performAbility();

    // default method
    default void usePower() {
        System.out.println("The superhero uses their power!");
    }

    default void displaySpeed(int speed) {
        System.out.println("The superhero's speed is: " + speed + " MPH");
    }
}


