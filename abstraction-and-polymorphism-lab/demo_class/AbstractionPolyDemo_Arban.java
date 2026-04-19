package demo_class;

import implementations.BasketballPlayer_Arban;
import implementations.FootballPlayer_Arban;
import abstract_classes.Athlete_Obedoza;
import interfaces.Competitive_Obedoza;

/**
 * @author Arban
 * 
 *  Q1: What abstract class did you create?
 *  WashingMachine_Arban.java
 *
 *  Q2: What interface did you create?
 *  Laundry_Arban.java
 *
 *  Q3: What methods did you override?
 *  performAcceleration(), reactToGameEvent(), compete()
 *
 *  Q4: What methods did you overload?
 *  compete(String, int, int) — BasketballPlayer & FootballPlayer
 *
 *  Q5: Where does dynamic binding occur in your code?
 *  - When performAcceleration() and compete() are called using
 *    Athlete_Obedoza and Competitive_Obedoza references.
 *
 *  Q6: Which shows polymorphism?
 *  - performAcceleration() and reactToGameEvent() behave differently
 *    depending on whether it's BasketballPlayer or FootballPlayer.
 *
 *  Q7: How does your design achieve low coupling?
 *  - Classes depend on abstraction (Athlete_Obedoza) and interface
 *    (Competitive_Obedoza), not concrete implementations.
 *
 *  Q8: How does your design achieve high cohesion?
 *  - Each class focuses only on its sport-specific behavior.
 */

public class AbstractionPolyDemo_Obedoza {
    public static void main(String[] args) {

        // Default Constructors
        BasketballPlayer_Arban bball = new BasketballPlayer_Arban();
        FootballPlayer_Arban football = new FootballPlayer_Arban();

        // Display Basketball Info
        System.out.println("==== BASKETBALL PLAYER ====");
        bball.rest();
        System.out.println("Position: " + bball.getPosition());
        System.out.println("Accuracy: " + bball.getShootingAccuracy());
        System.out.println("Level: " + bball.getPlayerLevel());

        System.out.println();

        // Display Football Info
        System.out.println("==== FOOTBALL PLAYER ====");
        football.rest();
        System.out.println("Position: " + football.getPosition());
        System.out.println("Accuracy: " + football.getPassingAccuracy());
        System.out.println("Level: " + football.getPlayerLevel());

        System.out.println();

        // Runtime Polymorphism via Abstract Class
        Athlete_Obedoza athleteOne = bball;
        Athlete_Obedoza athleteTwo = football;

        // Runtime Polymorphism via Interface
        Competitive_Obedoza compOne = bball;
        Competitive_Obedoza compTwo = football;

        System.out.println("==== ACCELERATION (via Abstract Class) ====");
        athleteOne.performAcceleration();
        athleteTwo.performAcceleration();

        System.out.println();

        System.out.println("==== GAME REACTION (via Abstract Class) ====");
        athleteOne.reactToGameEvent();
        athleteTwo.reactToGameEvent();

        System.out.println();

        System.out.println("==== COMPETE (via Interface) ====");
        compOne.compete("High", 90);
        compTwo.compete("Extreme", 95);

        System.out.println();

        // Interface default method
        System.out.println("==== CELEBRATION (Default Method) ====");
        compOne.celebrateVictory();
        compTwo.celebrateVictory();

        System.out.println();

        // Overloaded methods
        System.out.println("==== OVERLOADED COMPETE METHODS ====");
        bball.compete("Max", 99, 40);     // points
        football.compete("Elite", 97, 3); // assists

        System.out.println();

        // Actions
        System.out.println("==== GAME ACTIONS ====");
        bball.defendPlayer("Opponent A");
        bball.playOffense("Defender B");

        football.defendPlayer("Opponent X");
        football.playOffense("Teammate Y");

        System.out.println("==== FIN ====");
    }
}