package demo_class;

import component_class.Kulangot;
import component_class.Earwax_Cardeno;
import component_class.Handkerchief_Gedoria;
import sub_class.AuraHandkerchief_Go;
import composed_class.Plate_Go;

/**
 * ============================================================
 *  The Composition Class
 *  @author Sean Ethan G. Go
 * ============================================================
 * === DESIGN ANALYSIS ===
 *
 * 1. HAS-A Relationships (Composition):
 *    - Plate_Go HAS-A Kulangot
 *    - Plate_Go HAS-A Earwax_Cardeno
 *    - Plate_Go HAS-A Handkerchief_Gedoria
 *
 * 2. Classes Reused:
 *    - Kulangot
 *    - Earwax_Cardeno
 *    - Handkerchief_Gedoria
 *    - AuraHandkerchief_Go (subclass for swapping demo)
 *
 * 3. How Composition Reduces Coupling:
 *    - Any component can be replaced without modifying Plate_Go.
 *    - Example: AuraHandkerchief_Go can replace Handkerchief_Gedoria
 *      using set_handkerchief(), and the system still works.
 *    - This shows LOW COUPLING because Plate_Go depends only on
 *      the Handkerchief_Gedoria type, not a specific implementation.
 *
 * 4. How High Cohesion is Implemented:
 *    - Each class has a single responsibility:
 *        - Kulangot handles its own attributes (color, size, stickiness).
 *        - Earwax_Cardeno handles amount, texture, and color.
 *        - Handkerchief_Gedoria handles its own state and properties.
 *        - Plate_Go is only responsible for displaying contents.
 *
 * 5. How Cohesion is Maintained:
 *    - Each component manages its own behavior and data.
 *    - Plate_Go does not interfere with internal logic of components.
 *    - Changes in one class (e.g., Kulangot state) do not affect others.
 *
 * 6. Why Inheritance is NOT Appropriate Here:
 *    - A Plate is not a type of Kulangot, Earwax, or Handkerchief.
 *    - These are HAS-A relationships, not IS-A relationships.
 *    - Using inheritance (extends) would create tight coupling.
 *    - Composition allows flexible and independent components.
 *
 * ============================================================
 */

public class CompositionDemo_Go {

    public static void main(String[] args) {

        System.out.println("================================================");
        System.out.println("Plate Composition Demo - Showcase");
        System.out.println("================================================\n");

        // ========================================================
        // Default Plate
        // ========================================================
        Plate_Go defaultPlate = new Plate_Go();

        System.out.println("=== Default Plate ===");
        defaultPlate.displayPlateContents();

        // ========================================================
        // Custom Plate
        // ========================================================
        Kulangot kulangot = new Kulangot("Brown", "Tiny", false);
        Earwax_Cardeno earwax = new Earwax_Cardeno(3, "Dark Yellow", "Mushy", true);
        Handkerchief_Gedoria handkerchief = new Handkerchief_Gedoria("Red", "Medium", true);

        Plate_Go customPlate = new Plate_Go("Mystery Platter", kulangot, earwax, handkerchief);

        System.out.println("\n=== Custom Plate ===");
        customPlate.displayPlateContents();

        // ========================================================
        // Low Coupling Demo (Option 1 - Subclass Swap)
        // ========================================================
        System.out.println("\n================================================");
        System.out.println("Low Coupling Demo: Handkerchief Subclass Swap");
        System.out.println("================================================");

        System.out.println("\nBefore swap:");
        customPlate.displayPlateContents();

        // Swap with subclass (AuraHandkerchief)
        AuraHandkerchief_Go aura = new AuraHandkerchief_Go(); // uses default constructor
        customPlate.set_handkerchief(aura);
        customPlate.set_plateDish("Aura Special Platter");

        System.out.println("\nAfter swap:");
        customPlate.displayPlateContents();

        // Subclass-specific behavior
        System.out.println("\n=== Fancy Handkerchief Special Action ===");
        aura.flutter();

        // ========================================================
        // Behavior Change Demo (Cohesion)
        // ========================================================
        System.out.println("\n================================================");
        System.out.println("Behavior Change Demo: Modifying of Component State");
        System.out.println("================================================");

        System.out.println("\nBefore modification:");
        kulangot.setColor("Brown");
        kulangot.setSize("Tiny");
        kulangot.setSticky(false);
        kulangot.describe();

        System.out.println("\nAfter modification:");
        kulangot.setColor("Dark Green");
        kulangot.setSize("Extra Large");
        kulangot.setSticky(true);
        kulangot.describe();

        System.out.println("\nPlate after Kulangot modification:");
        customPlate.displayPlateContents();

        // ========================================================
        // Final Confirmation
        // ========================================================
        System.out.println("\n================================================");
        System.out.println("Final Confirmation");
        System.out.println("================================================");

        System.out.println("- Handkerchief replaced with subclass → system still works");
        System.out.println("- Components modified independently → no Plate_Go changes needed");
        System.out.println("\n→ Low Coupling and High Cohesion is real.");

        System.out.println("\n================================================");
        System.out.println("End of Demo");
        System.out.println("================================================");
    }
}