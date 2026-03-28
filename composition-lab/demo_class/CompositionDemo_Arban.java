package composed_class;

import component_class.Finger_Nono;
import component_class.Handkerchief_Gedoria;
import component_class.Kulangot;

/**
 * Student Composition Demo
 * @author: @jhavearban-ctrl (Arban, Jhave P.)
 * Design Analysis

1. What are the HAS-A relationships?

Student_Arban HAS-A Finger_Nono → uses the finger to pick the nose.
Student_Arban HAS-A Handkerchief_Gedoria → uses the handkerchief to clean the nose.
Student_Arban HAS-A Kulangot → interacts with and manipulates kulangot.

2. Which classes were reused?

Finger_Nono, Handkerchief_Gedoria, Kulangot
These are component classes that can be reused without modifying their internal code

3. How does composition reduce coupling?

Components are easily swappable (e.g., replacing the handkerchief with another instance)
Changes in component classes do not affect the Student_Arban class
The main class depends on behavior, not implementation

4. How did you implement high cohesion?

Each component handles its own responsibility:
Finger_Nono → bending action
Handkerchief_Gedoria → cleaning and folding
Kulangot → rolling/manipulation
Student_Arban only coordinates these actions

5. How is cohesion maintained?

Each class focuses on a single, clear purpose
Student_Arban manages actions (pick and clean) without handling internal logic of components
Component classes do not overlap responsibilities

6. Why is inheritance NOT appropriate here?

The relationship is HAS-A, not IS-A
Student_Arban is not a type of finger, handkerchief, or kulangot
Composition allows flexibility and reusability
Inheritance would introduce unnecessary or incorrect behaviors
 */
public class CompositionDemo_Arban {

    public static void main(String[] args) {

        String barrier = "================================================";

        System.out.println(barrier + "\nSTUDENT COMPOSITION DEMO\n" + barrier + "\n");

        // Component classes
        System.out.println("Component Classes Used:");
        System.out.println("Finger_Nono, Handkerchief_Gedoria, Kulangot\n");

        // Create components
        Finger_Nono finger = new Finger_Nono();
        Handkerchief_Gedoria handkerchief = new Handkerchief_Gedoria();
        Kulangot kulangot = new Kulangot();

        // Student composition
        Student_Arban student1 = new Student_Arban("Arban", finger, handkerchief, kulangot);

        // Variable: name
        String studentName = student1.getStudentName();

        System.out.println("=== Scenario: Student feels something in their nose ===");
        System.out.println(studentName + " seems uncomfortable...\n");

        // Action: picking nose
        System.out.println("=== " + studentName + " starts picking nose ===");
        student1.pickNose();
        System.out.println(" ");

        System.out.println(barrier);
        System.out.println("AFTER PICKING NOSE");
        System.out.println(barrier);
        System.out.println(" ");

        // Action: cleaning
        System.out.println("=== " + studentName + " cleans using handkerchief ===");
        student1.cleanUsingHandkerchief();
        System.out.println(" ");

        System.out.println(barrier);
        System.out.println("CHANGING COMPONENT (LOW COUPLING DEMO)");
        System.out.println(barrier + "\n");

        // Replace handkerchief (demonstrating low coupling)
        Handkerchief_Gedoria newHandkerchief = new Handkerchief_Gedoria();
        student1.setHandkerchief(newHandkerchief);

        System.out.println(studentName + " now uses a different handkerchief:");
        student1.cleanUsingHandkerchief();
        System.out.println(" ");

        System.out.println("=== Student demo complete! ===");
        System.out.println(barrier);
    }
}