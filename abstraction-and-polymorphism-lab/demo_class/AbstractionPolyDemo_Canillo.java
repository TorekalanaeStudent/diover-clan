package demo_class;

import implementations.DemiGod_Canillo;
import implementations.GreekGod_Canillo;
import abstract_classes.GameCharacter_Navarro;
import interfaces.CombatSystem_Navarro;
import components.Ability_Canillo;

/**
 * @author Canillo, Diover Vincent L.
 * @TorekalanaeStudent
 * 
 *  Q1: What abstract class did you create?
 *  A1: The abstract class that I created is: Ability_Canillo.java
 * 
 *  Q2: What interface did you create?
 *  A2: The interface that I created is: BendingSystem_Canillo.java
 * 
 *  Q3: What methods did you override?
 *  A3: The methods that were overriden were: getRole(), attack(), and defend()
 * 
 *  Q4: What methods did you overload?
 *  A4: The method that I overloaded is: attack()
 * 
 *  Q5: Where does dynamic binding occur in your code?
 *  A5: Dynamic Binding occurs through line 54-55
 * 
 *  Q6: Which shows polymorphism?
 *  A6: Polymorphism was shown when the battle started
 * 
 *  Q7: How does your design achieve low coupling
 *  A7: Low coupling was achieved because of how Ability and the implementation classes 
 *      are independent to each other
 * 
 *  Q8: How does your design achieve high cohesion?
 *  A8: High cohesion was achieved because of how even if Ability is changed
 *      I don't need to change the implemented class at all (DemiGod_Canillo, GreekGod_Canillo)
 */

public class AbstractionPolyDemo_Canillo{
    public static void main(String[] args){
        System.out.println("=== Creating Phase ===");

        // Composition Objects:
        Ability_Canillo rage = new Ability_Canillo("Spartan Rage", 100);
        Ability_Canillo thunder = new Ability_Canillo("Divine Thunder", 120);

        // Implemnetation Objects:
        // Kratos:
        DemiGod_Canillo Kratos = new DemiGod_Canillo("Kratos", 100, 900, "God of War", "Blades of Chaos", rage);
        // Zeus:
        GreekGod_Canillo Zeus = new GreekGod_Canillo("Zeus", 100, "Sky", "Thunderbolt", true, thunder);

        // Printing of Character Info:
        System.out.println(Kratos.getName() + " - " + Kratos.getRole());
        System.out.println("Status: " + Kratos.getStatus());

        System.out.println(); // Formatting Purposes

        System.out.println(Zeus.getName() + " - " + Zeus.getRole());
        System.out.println("Status: " + Zeus.getStatus());

        // Battle starts
        // runtime polymorphism
        GameCharacter_Navarro fighter1 = Kratos;
        GameCharacter_Navarro fighter2 = Zeus;

        Kratos.attack(fighter2);    // Composition attack with DemiGod
        Zeus.defend();              // interface default method here

        Zeus.attack(fighter1);      // Composition again with GreekGod naman
        Kratos.defend();            // interface default method ulit for kratos

        // demonstration ng mga overloaded methods:
        Kratos.attack(fighter2, 75);
        Zeus.attack(fighter1, 60);

        // new status after the battle
        System.out.println("\n=== STATUS ===\n" 
        + Kratos.getName() + ": " + Kratos.getStatus() + "\n"
         + Zeus.getName() + ": " + Zeus.getStatus());

        // end game stuff
        System.out.println("\n=== DEMO COMPLETED ===");
    }
}