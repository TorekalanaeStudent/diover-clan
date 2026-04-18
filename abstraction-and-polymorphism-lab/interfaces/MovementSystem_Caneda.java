package interfaces;

/**
 * @author Caneda, Ramil Jr M.
 * @Rcaneda
 */

public interface MovementSystem_Caneda {

    //Abstract Methods

    //Abstract method #1 will slow character movement
    void slowDownMoving();
    
    //Abstract method #2 will start character movement
    void startMoving();

    //Default Method
    
    //Default method #1 will stop chracter movement

    default void stopMovement(){
        
    }
        
}
