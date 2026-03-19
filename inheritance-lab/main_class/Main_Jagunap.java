package main_class;

import sub_class.Painting_Jagunap;
import sub_class.Sculpture_Jagunap;
import parent_class.ArtPiece_Cardeno;

public class Main_Jagunap {
    public static void main(String[] args) {

        System.out.println("=== Painting Object ===");
        Painting_Jagunap p = new Painting_Cardeno();
        p.display();             // inherited
        p.evaluate();            // inherited
        p.description();         // overridden
        p.analyzeBrushwork();    // new behavior

        System.out.println("\n=== Sculpture Object ===");
        Sculpture_Jagunap s = new Sculpture_Cardeno();
        s.display();             // inherited
        s.evaluate();            // inherited
        s.description();         // overridden
        s.inspectMaterial();     // new behavior

        System.out.println("\n=== Dynamic Binding Demo ===");
        ArtPiece_Cardeno art1 = new Painting_Jagunap();
        ArtPiece_Cardeno art2 = new Sculpture_Jagunap();

        // runtime polymorphism
        art1.description();  // Painting version runs
        art2.description();  // Sculpture version runs

        
        // 1. What is the IS-A relationship in your program?
        // This line of code shows the IS-A relationship because a Painting_Cardeno IS-A ArtPiece_Cardeno
        // and a Sculpture_Cardeno IS-A ArtPiece_Cardeno.
        // Example: Painting_Cardeno p = new Painting_Cardeno();
        // This means Painting_Cardeno is a type of ArtPiece_Cardeno.

        // 2. Which method was overridden?
        // The description() method was overridden in both Painting_Cardeno and Sculpture_Cardeno.
        // Each subclass provides its own version of the method.

        // 3. What happens during dynamic binding?
        // During dynamic binding, the method that gets executed depends on the actual object type,
        // NOT the reference type. 
        // Example: ArtPiece_Cardeno art = new Painting_Cardeno();
        // art.description(); 
        // This runs the Painting_Cardeno version of description() at runtime.

        // 4. What methods were inherited from the parent class?
        // The subclass inherits these methods from ArtPiece_Cardeno:
        // - display()
        // - evaluate()
        // - description()  (but subclasses override it with their own version)

        // 5. What new behavior did the subclass introduce?
        // Painting_Cardeno introduced the new behavior: analyzeBrushwork()
        // Sculpture_Cardeno introduced the new behavior: inspectMaterial()
        
    }
}
