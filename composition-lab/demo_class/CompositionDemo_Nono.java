package component_class;

import component_class.Kulangot;
import component_class.Ilong_Onte;
import component_class.Earwax_Cardeno;
import composed_class.Mage_Nono;
import sub_class.Mask_Nono;

/**
 * ============================================================
 *  The Composition Class of
 *  @author Mary Angeline Nono
 * ============================================================
 * === DESIGN ANALYSIS ===
 *
 * 1. HAS-A Relationships (Composition):
 *    - Mage_Nono HAS-A Kulangot
 *    - Mage_Nono HAS-A Ilong_Onte
 *    - Mage_Nono HAS-A Earwax_Cardeno
 *
 * 2. Classes Reused:
 *    - Kulangot
 *    - Ilong_Onte
 *    - Earwax_Cardeno
 *    - Mask_Nono 
 *
 * 3. How Composition Reduces Coupling:
 *    - Components can be replaced (ex: Mask_Nono instead of Ilong_Onte)
 *      without changing Mage_Nono code → LOW COUPLING
 *
 * 4. How High Cohesion is Implemented:
 *    - Each class has a single responsibility
 *
 * 5. Why Inheritance is NOT Used:
 *    - Mage is not a type of Kulangot, Ilong, or Earwax
 *    - So we use HAS-A instead of IS-A
 *
 * ============================================================
 */

public class CompositionDemo_Nono {

    public static void main(String[] args) {

        System.out.println("================================================");
        System.out.println("MAGE COMPOSITION DEMO");
        System.out.println("================================================\n");

        // Component classes
        System.out.println("Component Classes Used:");
        System.out.println("Kulangot");
        System.out.println("Ilong_Onte");
        System.out.println("Earwax_Cardeno\n");

        Kulangot kulangot = new Kulangot("green", "medium", true);
        Ilong_Onte ilong = new Ilong_Onte("Pointed", "Small", false);
        Earwax_Cardeno earwax = new Earwax_Cardeno(50, "yellow", "soft", true);

        Mage_Nono mage = new Mage_Nono(
                "Mage Angeline", kulangot, ilong, earwax);

        // === DEMO ACTIONS ===
        System.out.println("=== Mage starts actions ===");
        mage.pickNose();
        System.out.println();

        mage.flickKulangot();
        System.out.println();

        mage.cleanEar();
        System.out.println();

        mage.statusReport();

        // =====================================================
        // LOW COUPLING DEMO (Swap Ilong → Mask_Nono)
        // =====================================================
        System.out.println("================================================");
        System.out.println("LOW COUPLING DEMO: SWAPPING NOSE");
        System.out.println("================================================\n");

        Mask_Nono mask = new Mask_Nono("Medium", "Yes", false, "N95");

        mage.setIlong(mask); // subclass used instead of original
        mage.setMageName("Mage Angeline (Masked)");

        System.out.println("=== Mage with mask ===");
        mage.pickNose(); // still works
        mask.amoy();

        System.out.println("\n- System still works after swap → LOW COUPLING!\n");

        // =====================================================
        // BEHAVIOR CHANGE DEMO
        // =====================================================
        System.out.println("================================================");
        System.out.println("BEHAVIOR CHANGE DEMO: MODIFY KULANGOT");
        System.out.println("================================================\n");

        System.out.println("Before:");
        kulangot.describe();

        kulangot.setColor("dark green");
        kulangot.setSize("large");
        kulangot.setSticky(false);

        System.out.println("\nAfter:");
        kulangot.describe();

        System.out.println("\n- Mage still uses it without changing code!");
        mage.flickKulangot();

        System.out.println("\n================================================");
        System.out.println("END OF DEMO");
        System.out.println("================================================");
    }
}