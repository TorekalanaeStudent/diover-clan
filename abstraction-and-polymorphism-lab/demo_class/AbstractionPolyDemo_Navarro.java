package demo_class;

import implementations.FireBending_Navarro;
import implementations.WaterBending_Navarro;
import abstract_classes.Bender_Canillo;
import interfaces.BendingSystem_Canillo;

/**
 * =============================================================================
 * @author Navarro, Vince Justine
 * @StillLizard0106
 * 
 *=====Code-Based Analysis=====
 *1. What abstract class did you create?
 * - I created The GameCharacter_Navarro class and used Bender_Canillo for the implementation.
 * 
 *2. What interface did you create?
 * - I created The Combatable_Navarro and used BendingSystem_Canillo for the implementation.
 * 
 *3. What methods did you override? 
 * - Methods Overridden:
 * - { heal(), performAttack(), performDefense(), performSpecialAttack() }
 * 
 *4. What methods did you overload?
 * - Methods Overloaded:
 * - (describe)
 * 
 *5. Where does dynamic binding occur in your code?
 * - Dynamic binding occurs in the Bender_Canillo[]and BendingSystem_Canillo[] loops when -
 *   heal(10) and f.performAttack() are called through parent/interface references. 
 *      
 *6. Which part shows polymorphism?
 * - Both Bender_Canillo[] and BendingSystem_Canillo[] - store different object types (Fire and Water benders) under
 *   one reference type, and basically the same method call produces different output.
 *      
 *7. How does your design achieve low coupling?
 * - The battle() method and the arrays only reference Bender_Canillo and BendingSystem_Canillo not the concrete class directly.
 *
 *8. How does your design achieve high cohesion?
 * - Basically each class has one job: 
 * - Bender_Canillo manages methods and attributes, 
 * - BendingSystem_Canillo defines the combat system,
 * - FireBending_Navarro handles fire logic 
 * - WaterBending_Navarro handles water logic
 * - The demo class just runs the program
 *
 *=====Code-Based Analysis=====
 *
 * DEMO PROGRAM — AbstractionPolyDemo_Navarro.java
 *=============================================================================
 */
public class AbstractionPolyDemo_Navarro {
	
	
	// MAIN
    public static void main(String[] args) {

        // Default constructors
        FireBending_Navarro  fireDef   = new FireBending_Navarro();
        WaterBending_Navarro waterDef  = new WaterBending_Navarro();

        // Parameterized constructors
        FireBending_Navarro  fireParam  =
                new FireBending_Navarro("Dio", "FireBender", 90, 18);
        WaterBending_Navarro waterParam =
                new WaterBending_Navarro("Jojo", "WaterBender", 95, 17);


        //METHOD OVERLOADING
        System.out.println("METHOD OVERLOADING:");
        System.out.println();
        fireParam.describe("Fire Bender Profile", "The World will be engulfed in flames!");
        System.out.println();
        waterParam.describe("Water Bender Profile", "Be Water!");
        System.out.println();


        //METHOD OVERRIDING
        System.out.println("METHOD OVERRIDING: heal():");
        fireDef.takeDamage(30);          // HP drops to 70
        fireDef.heal(20);                // FireBending_Navarro.heal() is called
        waterParam.takeDamage(40);       // HP drops to 55
        waterParam.heal(25);             // WaterBending_Navarro.heal() is called
        System.out.println();
        
        System.out.println("METHOD OVERRIDING: BendingSystem_Canillo:");
        fireParam.performAttack();
        fireParam.performAttack("Jojo");
        fireParam.performDefense();
        fireParam.performSpecialAttack();
        System.out.println();
        waterDef.performAttack();
        waterDef.performAttack("Dio");
        waterDef.performDefense();
        waterDef.performSpecialAttack();
        System.out.println();
  
        // Default interface methods
        System.out.println("Default Interface Methods");
        fireDef.meditate();
        fireDef.displayElement(fireDef.getElementStyle());
        System.out.println();

        // DYNAMIC BINDING for abstract class
        System.out.println("DYNAMIC BINDING: Bender_Canillo ");

        Bender_Canillo[] benders = {
            new FireBending_Navarro("Azula",  "FireBender",  100, 16),
            new FireBending_Navarro("Iroh",   "FireBender",   80, 60),
            new WaterBending_Navarro("Katara", "WaterBender",  90, 16),
            new WaterBending_Navarro("Hama",  "WaterBender",  75, 55)
        };

        System.out.println("Calling heal(10) on each bender through");
        for (Bender_Canillo b : benders) {
            b.takeDamage(20);   
            b.heal(10);       
        }
        System.out.println();
        //DYNAMIC BINDING for interface class
        System.out.println("DYNAMIC BINDING: BendingSystem_Canillo ");
        BendingSystem_Canillo[] fighters = {
            new FireBending_Navarro("Dio", "FireBender", 90, 18),
            new WaterBending_Navarro("Jojo", "WaterBender", 95, 17)
        };

        System.out.println("Calling performAttack() through interface reference:");
        for (BendingSystem_Canillo f : fighters) {
            f.performAttack();         
            f.performSpecialAttack();
            System.out.println();
        }
    }

    // OVERLOADED
    public static void battle(Bender_Canillo attacker, Bender_Canillo defender) {
        System.out.println(attacker.getName()
                + "  vs  " + defender.getName() + "  [Single Round]");
        System.out.println("─".repeat(50));

        // Dynamic binding: actual performAttack() called depends on runtime type
        ((BendingSystem_Canillo) attacker).performAttack(defender.getName());
        defender.takeDamage(15);

        System.out.println("  → " + defender.getName()
                + "'s remaining HP: " + defender.getHP());
    }
 }
    
