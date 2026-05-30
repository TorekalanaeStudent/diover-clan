package composed_class;

import component_class.Clothes_Obedoza;
import component_class.Finger_Nono;
import component_class.Kulangot;
import composed_class.Person_Ovejera;

/**
 * Composition Demo
 * @author: Ovejera
 */
public class CompositionDemo_Ovejera {

    public static void main(String[] args) {

        String barrier = "================================================";

        System.out.println(barrier + "\nPERSON COMPOSITION DEMO\n" + barrier + "\n");

        // Component classes
        System.out.println("Component Classes Used:");
        System.out.println("Clothes_Obedoza, Finger_Nono, Kulangot\n");

        // Create components
        Clothes_Obedoza clothes = new Clothes_Obedoza("Shirt", "Medium", "Green", 350);
        Finger_Nono finger = new Finger_Nono("Index Finger", 90);
        Kulangot kulangot = new Kulangot("Green", "Small", true);

        // Composition
        Person_Ovejera person1 = new Person_Ovejera("Ziggy", clothes, finger, kulangot);

        // Variable
        String name = person1.getPersonName();

        System.out.println("=== Daily Routine Begins ===");
        System.out.println(name + " is getting ready...\n");

        // Outfit preparation
        System.out.println("=== " + name + " prepares outfit ===");
        person1.prepareOutfit();
        System.out.println(" ");

        // Buying clothes
        System.out.println("=== " + name + " tries to buy clothes ===");
        person1.buyClothes();
        System.out.println(" ");

        System.out.println(barrier);
        System.out.println("FINGER ACTIONS");
        System.out.println(barrier + "\n");

        // Finger actions
        System.out.println("=== " + name + " uses finger ===");
        person1.useFinger();
        System.out.println(" ");

        System.out.println(barrier);
        System.out.println("KULANGOT MODE");
        System.out.println(barrier + "\n");

        // Kulangot attack 😂
        System.out.println("=== " + name + " prepares kulangot attack ===");
        person1.flickKulangot();
        System.out.println(" ");

        // Status report
        System.out.println("=== STATUS REPORT ===");
        person1.statusReport();

        // LOW COUPLING DEMO
        System.out.println(barrier);
        System.out.println("LOW COUPLING DEMO: CHANGING CLOTHES");
        System.out.println(barrier + "\n");

        // Swap clothes (low coupling demo)
        Clothes_Obedoza newClothes = new Clothes_Obedoza("Jacket", "Large", "Black", 600);
        person1.setClothes(newClothes);

        System.out.println(name + " changed outfit:");
        person1.prepareOutfit();
        System.out.println(" ");

        System.out.println("=== Demo Complete! ===");
        System.out.println(barrier);
    }
}