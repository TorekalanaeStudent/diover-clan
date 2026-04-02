package demo_class;

import component_class.AppraisalSystem_Caneda;
import component_class.Kulangot;
import sub_class.Thumb_Cardeno; 
import composed_class.NoseKnowsWorth_Cardeno;

/** Composition Demo of @author @flcardeno (Cardeño, Faye L.)

1. What are the HAS-A relationships?
- NoseKnowsWorth_Cardeno HAS-A Finger_Nono 
- NoseKnowsWorth_Cardeno HAS-A AppraisalSystem_Caneda
- NoseKnowsWorth_Cardeno HAS-A Kulangot

2. Which classes were reused?
- Finger_Nono, AppraisalSystem_Caneda, Kulangot, and Thumb_Cardeno were reused as 
components inside NoseKnowsWorth_Cardeno.

3. How does composition reduce coupling?
- We can change the attributes or state of the component objects (like increasing thumb 
strength or changing Kulangot color) without breaking the composed class.

4. How did you implement high cohesion?
- Each component class handles its own specific behaviors (ex. bend() of Finger_Nono, 
grip() of Thumb_Cardeno, itemAppraisal() of AppraisalSystem_Caneda, roll() and flick() 
of Kulangot).

5. How is cohesion maintained?
- NoseKnowsWorth_Cardeno doesn't mix unrelated functionality.

6. Why is inheritance NOT appropriate here?
- Inheritance is meant for “IS-A” relationships, but NoseKnowsWorth_Cardeno is not a
type of Finger, AppraisalSystem, or Kulangot and;
- Using inheritance would create unnecessary dependencies and reduce flexibility.

*/
 

public class CompositionDemo_Cardeno {

    public static void main(String[] args) {

        // create the components
        Thumb_Cardeno thumb = new Thumb_Cardeno("Right Thumb", 75, 90); // child of Finger_Nono
        AppraisalSystem_Caneda appraisal = new AppraisalSystem_Caneda("Diamond Ring", 6000, "Jumong De la Cruz", true); 
        Kulangot kulangot = new Kulangot("Green", "Small", true); 

        // create the composed object
        NoseKnowsWorth_Cardeno inspectionSystem = new NoseKnowsWorth_Cardeno(thumb, appraisal, kulangot);

        // performing the inspection
        System.out.println("Performing inspection:");
        inspectionSystem.doInspection();

        // used to call the subclass (grip is a specific behavior of Thumb_Cardeno)
        thumb.grip();

        // to show the status of all the components
        inspectionSystem.showStatus();

        /** - low coupling demo -
        for bonus points, i updated the component objects (simulates behavior change)
        i changed the attributes of the components to show that the system still works
        */
        thumb.setStrength(100); 
        appraisal.setItemValue(3000); 
        kulangot.setColor("Yellow"); 
        kulangot.setSticky(false);  

        System.out.println("After modifying component objects:");

        // re-running the inspection and show the status
        inspectionSystem.doInspection();
        inspectionSystem.showStatus();
        
        // to show that the subclass behavior still works
        thumb.grip();
    }
}