package demo_class;

import component_class.Kulangot;
import component_class.Finger_Nono;
import component_class.Earwax_Cardeno;
import sub_class.EarwaxCleaner_Jagunap;
import composed_class.Support_Jagunap;

/**
 * Composition Demo of @author Jagunap
 *
 * 1. What are the HAS-A relationships?
 * - Support_Jagunap HAS-A Kulangot
 * - Support_Jagunap HAS-A Finger_Nono
 * - Support_Jagunap HAS-A Earwax_Cardeno
 *
 * 2. Which classes were reused?
 * - Kulangot, Finger_Nono, Earwax_Cardeno, and EarwaxCleaner_Jagunap
 *   were reused as components inside Support_Jagunap.
 *
 * 3. How does composition reduce coupling?
 * - The component objects can be changed or replaced (e.g. different
 *   finger, earwax amount, or kulangot properties) without modifying
 *   the Support_Jagunap class.
 *
 * 4. How did you implement high cohesion?
 * - Each class has a single responsibility:
 *   Finger_Nono handles finger movement,
 *   Kulangot handles rolling/flicking,
 *   Earwax_Cardeno manages earwax state,
 *   ClearwaxCleaner_Jagunap focuses on cleaning behavior.
 *
 * 5. How is cohesion maintained?
 * - Support_Jagunap coordinates the components but does not implement
 *   their internal behaviors.
 *
 * 6. Why is inheritance NOT appropriate here?
 * - Support_Jagunap is not a type of Finger, Kulangot, or Earwax.
 * - These are HAS-A relationships, not IS-A relationships.
 */

public class CompositionDemo_Jagunap {

    public static void main(String[] args) {

        // =========================
        // CREATE COMPONENT OBJECTS
        // =========================
        Finger_Nono finger = new Finger_Nono("Index Finger", 70);
        Kulangot kulangot = new Kulangot("Brown", "Small", true);

        // using subclass of Earwax_Cardeno
        EarwaxCleaner_Jagunap earwax =
                new EarwaxCleaner_Jagunap(60, "Yellow", "Sticky", true, "Vacuum");

        // =========================
        // CREATE COMPOSED OBJECT
        // =========================
        Support_Jagunap support =
                new Support_Jagunap("Support Jagunap", kulangot, finger, earwax);

        // =========================
        // DEMONSTRATE BEHAVIORS
        // =========================
        System.out.println("=== Initial Support Actions ===");
        support.pickNose();
        support.flickKulangot();
        support.cleanEar();
        support.statusReport();

        // =========================
        // SUBCLASS-SPECIFIC BEHAVIOR
        // =========================
        System.out.println("=== Using Clearwax Cleaner ===");
        earwax.showInfo();

        // =========================
        // LOW COUPLING DEMO
        // Modify component objects
        // =========================
        finger.bend();
        kulangot.setSticky(false);
        earwax.add(20);

        System.out.println("\n=== After Modifying Component Objects ===");
        support.cleanEar();
        support.statusReport();
    }
}