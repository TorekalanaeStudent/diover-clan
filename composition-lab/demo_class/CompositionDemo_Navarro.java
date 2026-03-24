package component_class;

import component_class.Gun_Magazine_Go
import component_class.AppraisalSystem_Caneda
import component_class.Kulangot
import sub_class.Musket_Navarro
import composed_class.Dragoon_Navarro

/**
 * ============================================================
 *  The Composition Class
 *  @author NavarroVinceJustine
 * ============================================================
 * === DESIGN ANALYSIS ===
 *
 * 1. HAS-A Relationships (Composition):
 *    - Dragoon_Navarro HAS-A Gun_Magazine_Go
 *    - Dragoon_Navarro HAS-A AppraisalSystem_Caneda
 *    - Dragoon_Navarro HAS-A Kulangot
 *
 * 2. Classes Reused:
 *    - Gun_Magazine_Go
 *    - Kulangot
 *    - AppraisalSystem_Caneda
 *    - Musket_Navarro
 *
 * 3. How Composition Reduces Coupling:
 *    - Basically, Any component can be swapped like for example, Musket_Navarro in place of Gun_Magazine_Go
 *      without changing Dragoon_Navarro's code. so it becomes Low Coupling.
 *
 * 4. How High Cohesion is Implemented:
 *    - By having Each class has one clear responsibility and all the class work together.
 *
 * 5. How Cohesion is Maintained:
 *    - Gun_Magazine_Go handles the magazine logic.
 *    - AppraisalSystem_Caneda handles item valuation logic.
 *    - Kulangot handles its own properties and actions.
 *
 * 6. Why Inheritance is NOT Appropriate Here:
 *    - A Dragoon is not a type of Magazine, Appraisal System, or Kulangot.
 *    - Inheritance (IS-A Relationship) only
 *    - Using extends here would create tight coupling: changing Gun_Magazine_Go
 *      would directly break Dragoon_Navarro, even for unrelated changes.
 *
 * ============================================================
 */
public class CompositionDemo_Navarro {

    public static void main(String[] args) {

        System.out.println("================================================");
        System.out.println("DRAGOON COMPOSITION DEMO");
        System.out.println("================================================\n");
        
        // The Component classes
        System.out.println("Component Class Used:");
        System.out.println("Gun_Magazine_Go by Seth Go");
        System.out.println("Kulangot by Sir");
        System.out.println("AppraisalSystem_Caneda by Ramil Caneda \n");
        
        Gun_Magazine_Go standardMagazine = new Gun_Magazine_Go("9mm rounds", 15);

        AppraisalSystem_Caneda appraisal = new AppraisalSystem_Caneda(
                "Dragoon Saber ", 5200, "King's Armory", true);
        
        Kulangot kulangot = new Kulangot("greenish-yellow", "large", true);

        Dragoon_Navarro dragoon = new Dragoon_Navarro(
                "Dragoon Zieg Seth ", standardMagazine, appraisal, kulangot);

        // Call the Methods
        System.out.println("=== The Dragoon prepares for deployment ===");
        dragoon.prepareForDeployment();
        System.out.println(" ");

        System.out.println("=== Dragoon fires 2 times at the enemy!! ===");
        dragoon.fire();
        dragoon.fire();
        System.out.println(" ");

        System.out.println("=== Dragoon deploys secret biological weapon ===");
        dragoon.flickAtEnemy();
        
        dragoon.statusReport();

        // LOW COUPLING DEMO — Swap component with subclass
        System.out.println("================================================");
        System.out.println("LOW COUPLING DEMO: SWAPPING THE MAGAZINE");
        System.out.println("================================================\n");

        // Musket_Navarro IS-A Gun_Magazine_Go (subclass), so it fits perfectly
        Musket_Navarro musket = new Musket_Navarro("musket ball", 5, "Brown Bess Flintlock");

        dragoon.setMagazine(musket);
        dragoon.setDragoonName("Dragoon Zieg Reyes (The Musket Edition)");

        System.out.println("=== Re-prepare for deployment with new the gun and magazine");
        dragoon.prepareForDeployment();

        System.out.println("\n=== Fire with musket (overridden behavior) ===");
        dragoon.fire();
        dragoon.fire();

        System.out.println("\n=== Final status report with swapped component");
        dragoon.statusReport();

        System.out.println("- System still works after swap, it means LOW COUPLING confirmed!\n");

        System.out.println("================================================");
        System.out.println("BEHAVIOR CHANGE DEMO: UPDATING KULANGOT STATE");
        System.out.println("================================================\n");

        System.out.println("Before modification:");
        kulangot.describe();
        kulangot.setColor("dark green");
        kulangot.setSize("extra large");
        kulangot.setSticky(false);

        System.out.println("\nAfter modification:");
        kulangot.describe();

        System.out.println("\n- Dragoon can still flick it without any code changes → LOW COUPLING!");
        dragoon.flickAtEnemy();
        
        System.out.println("\n================================================");
        System.out.println("END OF COMPOSITION DEMO");
        System.out.println("================================================");
    }
}