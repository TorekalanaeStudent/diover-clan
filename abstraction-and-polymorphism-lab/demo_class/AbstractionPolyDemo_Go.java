package demo_class;

import implementations.SmartWatch_Go;
import implementations.Exoskeleton_Go;
import abstract_classes.WearableDevice_Onte;
import interfaces.DeviceSystem_Onte;

/*
 * @author Go Sean Ethan G.
 * @SethPlaysBadly
 * 
 * Q1: What abstract class did you create?
 * A1: The abstract class that I created is Gun_Go.java
 * 
 * Q2: What interface did you create?
 * A2: The interface that I created is GunSystem_Go.java
 * 
 * Q3: What methods did you override?
 * A3: The methods that were overridden are monitorHealth() and syncData()
 * 
 * Q4: What methods did you overload?
 * A4: The methods that I overloaded are charge() and boostPower()
 * 
 * Q5: Where does dynamic binding occur in your code?
 * A5: Dynamic binding occurs when WearableDevice_Onte references point to SmartWatch_Go and Exoskeleton_Go objects.
 * 
 * Q6: Which shows polymorphism?
 * A6: Polymorphism is shown when the two wearable devices perform their respective monitorHealth() outputs differently, despite the same call in.
 * 
 * Q7: How does your design achieve low coupling?
 * A7: Low coupling is achieved because WearableDevice_Onte and DeviceSystem_Onte are independent contracts used by multiple devices.
 * 
 * Q8: How does your design achieve high cohesion?
 * A8: High cohesion is achieved because each class focuses only on its own behavior (health tracking or exoskeleton control) without affecting others.
 */

public class AbstractionPolyDemo_Go {

    public static void main(String[] args) {

        System.out.println("=== Device Instantiation and Attribution of Values ===");

        // Create wearable devices
        SmartWatch_Go watch = new SmartWatch_Go("Smart Watch X", 85, 78);
        Exoskeleton_Go suit = new Exoskeleton_Go("ExoSuit Mk1", 90, 7);

        // Display initial status
        watch.displayStatus();
        System.out.println();
        suit.displayStatus();

        System.out.println("\n=== Syncing ===");

        // Interface method usage
        watch.syncData("Phone");
        suit.syncData("Command System");

        System.out.println("\n=== Health Monitoring ===");

        // Overridden abstract method/runtime polymorphism
        WearableDevice_Onte device1 = watch;
        WearableDevice_Onte device2 = suit;

        device1.monitorHealth();
        device2.monitorHealth();

        System.out.println("\n=== Overloading Demo ===");

        // Method overloading
        watch.charge();
        watch.charge(15);

        suit.boostPower();
        suit.boostPower(9);

        System.out.println("\n=== Final Status ===");

        watch.displayStatus();
        System.out.println();
        suit.displayStatus();

        System.out.println("\n=== Demo Complete ===");
    }
}