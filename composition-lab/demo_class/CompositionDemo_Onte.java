package demo_class;

import component_class.Hands_Navarro;
import component_class.Gun_Magazine_Go;
import component_class.Kulangot;
import sub_class.GhillieSuit_Onte;
import composed_class.Marksman_Onte;

/**
 * Marksman Composition Demo
 * Author: Onte, Vince Gian D.
 */

public class CompositionDemo_Onte {

    public static void main(String[] args) {
        System.out.println("\n=== Marksman Composition Demo ===\n");

        // Components
        Hands_Navarro hands = new Hands_Navarro("Tan", "Large", true);
        Gun_Magazine_Go magazine = new Gun_Magazine_Go("Bullet", 25);
        Kulangot kulangot = new Kulangot("green", "small", true);

        // Composed Objects
        Marksman_Onte marksman = new Marksman_Onte("Vince", hands, magazine, kulangot);
        GhillieSuit_Onte ghillieSuit = new GhillieSuit_Onte("Large", "Green", 1500.0, 8);

        String name = marksman.getMarksmanName();
        System.out.println("Marksman Name: " + name + "\n");

        // Marksman Methods
        marksman.tacticalReport();
        System.out.println();
        marksman.assessCombatReadiness();
        System.out.println();
        marksman.steadyAim();
        System.out.println();
        marksman.infuseProjectile();
        System.out.println();
        marksman.loadInfusedAmmo();
        System.out.println();
        marksman.executionPricisionShot();

        // Divider
        System.out.println("\n=====================================\n");

        // === GHILLIE SUIT DEMO ===
        System.out.println("=== Ghillie Suit Demo ===\n");

        System.out.println("--- Default Behavior Checks ---\n");
        ghillieSuit.describe();
        System.out.println();
        ghillieSuit.chooseColor();
        System.out.println();
        ghillieSuit.buyClothing();

        System.out.println("\n--- Stealth Ability ---\n");
        ghillieSuit.hide();

        System.out.println("\n--- Camouflage Effectiveness Check ---\n");
        if (ghillieSuit.getCamoLevel() >= 7) {
            System.out.println("Result: High stealth capability detected.");
        } else {
            System.out.println("Result: Stealth capability is moderate or low.");
        }

        System.out.println("\n=== End of Demo ===\n");
    }
}

/**
 * Design Analysis Answers:
 
  1. What are the HAS-A relationships?
  - Marksman HAS-A Hands_Navarro that uses the hands to hold and operate the gun.
  - Marksman HAS-A Gun_Magazine_Go that uses the magazine to load and infuse ammo.
  - Marksman HAS-A Kulangot that uses the kulangot to infuse the ammo for an enhanced shot.

  2. Which classes were reused?
  - Hands_Navarro, Gun_Magazine_Go, Kulangot
  - GhillieSuit_Onte to demonstrate a composed class with a subclass

  3. How does composition reduce coupling?
  - Composition reduces coupling because Marksman only uses the component classes
    instead of depending on their internal code, so changes in components will not
    break the Marksman class easily.

  4. How did you implement high cohesion?
  -  Each class has its own job and only focuses on what it is made for.

  5. How is cohesion maintained?
 -   Cohesion is maintained because each class only handles its own responsibility, 
    like Hands for handling, Magazine for ammo, and Kulangot for coating, without mixing tasks.
 

  6. Why is inheritance NOT appropriate here?
  - Because Marksman and its components are not “is-a” relationship, they are “has-a”, so composition is better.
 */