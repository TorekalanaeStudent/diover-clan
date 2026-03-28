package main_class;

import component_class.Earwax_Cardeno;
import component_class.Finger_Nono;
import component_class.Kulangot;
import composed_class.Body_DeJuras;

/**
 * ============================================================
 *  The Composition Class
 *  @author DeJuras
 * ============================================================
 * === DESIGN ANALYSIS ===
 *
 * 1. HAS-A Relationships (Composition):
 *    - Body_DeJuras HAS-A Earwax_Cardeno
 *    - Body_DeJuras HAS-A Finger_Nono
 *    - Body_DeJuras HAS-A Kulangot
 *
 * 2. Classes Reused:
 *    - Earwax_Cardeno
 *    - Finger_Nono
 *    - Kulangot
 *
 * 3. How Composition Reduces Coupling:
 *    - Components can be changed without modifying Body_DeJuras.
 *    - Example: changing Finger or Kulangot does not break Body.
 *
 * 4. How High Cohesion is Implemented:
 *    - Each class has one responsibility:
 *      Earwax -> ear properties
 *      Finger -> finger actions
 *      Kulangot -> its own behavior
 *
 * 5. Why Inheritance is NOT Appropriate:
 *    - A Body is not a type of Earwax, Finger, or Kulangot.
 *    - So we use HAS-A instead of IS-A.
 *
 * ============================================================
 */

public class CompositionDemo_DeJuras {

    public static void main(String[] args) {

      
        System.out.println("BODY COMPOSITION DEMO");
    

        // Component Classes
        System.out.println("Component Classes Used:");
        System.out.println("Earwax_Cardeno");
        System.out.println("Finger_Nono");
        System.out.println("Kulangot\n");

        // Create Components
        Earwax_Cardeno ear = new Earwax_Cardeno(20, "Yellow", "Sticky", true);
        Finger_Nono finger = new Finger_Nono("Index", 70);
        Kulangot kul = new Kulangot("Green", "Small", true);

        // Create Composed Class
        Body_DeJuras body = new Body_DeJuras("Clint", 20, ear, finger, kul);

        // Show Info
        System.out.println("=== Initial Body State ===");
        body.showInfo();

        // Behavior Demo
        System.out.println("\n=== Finger Action ===");
        finger.bend();
        finger.straighten();

        System.out.println("\n=== Kulangot Action ===");
        kul.roll();
        kul.flick();

        System.out.println("\n=== Earwax Modification ===");
        ear.add(10);
        ear.clean(5);
        ear.showInfo();

        // LOW COUPLING DEMO
  
        System.out.println("LOW COUPLING DEMO: CHANGING COMPONENT");
      

        Kulangot newKul = new Kulangot("Dark Green", "Large", false);
        body.setKulangot(newKul);

        System.out.println("After replacing Kulangot:");
        body.showInfo();

        System.out.println("\n- System still works after replacing component -> LOW COUPLING!");

        System.out.println("END OF COMPOSITION DEMO");
  
    }
}