package demo_class;

import sub_class.CrookedNose_Obedoza;
import component_class.Finger_Nono;
import component_class.Tissue_Ovejera;
import component_class.Kulangot;
import composed_class.Pahid_Obedoza;


public class CompositionDemoSurname{

    public static void main(String[] args){
        
        System.out.println("====== Composition Demo: Pahid_Obedoza ======");

        // Initiate classmate's objects
        Finger_Nono finger = new Finger_Nono("Ziggy", 23);
        Tissue_Ovejera tissue = new Tissue_Ovejera("Puffs", 12, true);
        Kulangot kulangot = new Kulangot("Brown", "Medium", true);

        // Initiation of my composed class
        Pahid_Obedoza pahid = new Pahid_Obedoza(finger, tissue, kulangot, "Willj");

        System.out.println("=== Applying Pahid actions ===");
        pahid.hideKulangot();       // combines finger, tissue, and kulangot
        pahid.displayPerson();      // uses finger and shows sticky status
        pahid.rollKulangot();       // rolls the kulangot
        kulangot.flick();           // directly call a component method

        System.out.println("Demonstration of low coupling");
        Tissue_Ovejera theTissue = new Tissue_Ovejera("Scott", 25, true);
        pahid.setTissue(theTissue);
        pahid.hideKulangot();

        // Subclass demo
        System.out.println("\n--- Using Subclass: CrookedNose_Obedoza ---");
        CrookedNose_Obedoza specialFinger = new CrookedNose_Obedoza();
        pahid.setFinger(specialFinger);
        pahid.hideKulangot();
        specialFinger.straighten();



    }

}

/**
 Design Analysis
 1. What are the HAS-A relationships?
  - Pahid_Obedoza HAS-A Finger_Nono → uses the finger to pick or wipe.
  - Pahid_Obedoza HAS-A Tissue_Ovejera → uses tissue to wipe kulangot.
  - Pahid_Obedoza HAS-A Kulangot → picks and manipulates kulangot.

  2. Which classes were reused?
  - Finger, Tissue, Kulangot
  - Classes created by my classmates that weren't internally modified

  3. How does composition reduce coupling?
  - Components are swappable (Ex. We replace the tissue with newtissue)
  - Changing components does not require changing the the composed class

  4. How did you implement high cohesion?
  - Each components handles their own data and behaviors
  - Finger(Bend straighten), tissue(use/restock), kulangot(Roll)

  5. How is cohesion maintained?
  - every components focus on their own specific role. Like Pahid, it coordinates all components without
  doing unrelated tasks

  6. Why is inheritance NOT appropriate here?
  - Because instead of is-a relationship, it's a HAS-A
  - meaning to say Pahid is not a type of finger, tissue or kulangot.
  - it focuses instead on flexibility of the code and functions
  - Inheritance would force pahid to inherit unwanted behaviors
 */