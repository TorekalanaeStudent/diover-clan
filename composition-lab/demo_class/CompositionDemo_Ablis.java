package demo_class;

import component_class.Hands_Navarro;
import component_class.Leg_Canillo;
import component_class.Clothes_Obedoza;
import sub_class.TapeGrip_Ablis;
import composed_class.Gymnasts_Ablis;

/**
 * ============================================================
 *  The Composition Demo Class
 *  @author Ablis
 * ============================================================
 * === DESIGN ANALYSIS ===
 *
 * 1. HAS-A Relationships (Composition):
 *    - Gymnasts_Ablis HAS-A Hands_Navarro
 *    - Gymnasts_Ablis HAS-A Leg_Canillo
 *    - Gymnasts_Ablis HAS-A Clothes_Obedoza
 *
 * 2. Classes Reused:
 *    - Hands_Navarro
 *    - Leg_Canillo
 *    - Clothes_Obedoza
 *    - TapeGrip_Ablis
 *
 * 3. How Composition Reduces Coupling:
 *    - Components can be replaced freely, such as substituting TapeGrip_Ablis for Hands_Navarro
 *      without modifying Gymnasts_Ablis's implementation, achieving loose coupling.
 *
 * 4. How High Cohesion is Implemented:
 *    - Every class focuses on a well-defined purpose while collaborating effectively.
 *
 * 5. How Cohesion is Maintained:
 *    - Hands_Navarro manages hand-related attributes and behaviors.
 *    - Leg_Canillo manages leg-related attributes and behaviors.
 *    - Clothes_Obedoza manages clothing-related attributes and behaviors.
 *
 * 6. Why Inheritance is NOT Appropriate Here:
 *    - A Gymnast does not represent a category of Hands, Legs, or Clothes.
 *    - Inheritance (IS-A Relationship) should only be used when truly applicable.
 *    - Implementing extends would result in strong coupling: modifications to Hands_Navarro
 *      could unexpectedly disrupt Gymnasts_Ablis, even for minor or unrelated updates.
 *
 * ============================================================
 */
public class CompositionDemo_Ablis {
    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("GYMNAST COMPOSITION DEMO. ROAD TO OLYMPIC GOLD!");
        System.out.println("================================================\n");

        //  Component classes
        System.out.println("Component Classes Used:");
        System.out.println("Hands_Navarro by Navarro");
        System.out.println("Leg_Canillo by Canillo");
        System.out.println("Clothes_Obedoza by Obedoza\n");

        // Create components
        Hands_Navarro hands = new Hands_Navarro("Dark Brown", "Medium", true);
        Leg_Canillo leg = new Leg_Canillo(5, 30.0, 18.0);
        Clothes_Obedoza clothes = new Clothes_Obedoza("Leotards", "Medium", "Blue", 45.99);

        // Create composed class using components
        Gymnasts_Ablis gymnast = new Gymnasts_Ablis("Ablis", false, true, clothes, leg, hands);

        // Call the Methods
        System.out.println("=== The Gymnast prepares for performance ===");
        gymnast.performanceReport();
        System.out.println(" ");

        System.out.println("=== Gymnast performs a flip successfully! ===");
        gymnast.performSuccess();
        System.out.println(" ");

        System.out.println("=== Gymnast failed to perform a flip ===");
        gymnast.performFailure();
        System.out.println(" ");

        gymnast.performanceReport();

        // LOW COUPLING DEMO — swapping component with subclass
        System.out.println("================================================");
        System.out.println("LOW COUPLING DEMO: SWAPPING THE HANDS");
        System.out.println("================================================\n");

        // TapeGrip_Ablis IS-A Hands_Navarro 
        TapeGrip_Ablis tapeGrip = new TapeGrip_Ablis("Dark Brown", "Medium", true, "Loop");

        gymnast.setHands(tapeGrip);
        gymnast.setGymnastName("Ablis (The Tape Grip Edition)");

        System.out.println("=== Re-prepare for performance with new hands");
        gymnast.performanceReport();

        System.out.println("\n=== Perform with tape grip (enhanced grip) ===");
        gymnast.performSuccess();

        System.out.println("\n=== Final status report with swapped component");
        gymnast.performanceReport();

        System.out.println("- System still works after swap = LOW COUPLING\n");

        System.out.println("================================================");
        System.out.println("BEHAVIOR CHANGE DEMO: UPDATING LEG STATE");
        System.out.println("================================================\n");

        System.out.println("Before modification:");
        leg.describe();
        leg.setLegSize(35.0);
        leg.setRunSpeed(20.0);

        System.out.println("\nAfter modification:");
        leg.describe();

        System.out.println("\n- Gymnast can still perform without any code changes = LOW COUPLING!");
        gymnast.performSuccess();

        System.out.println("\n================================================");
        System.out.println("END OF COMPOSITION DEMO! You are now a GOLD OLYMPIC GYMNAST!");
        System.out.println("================================================");
    }
}