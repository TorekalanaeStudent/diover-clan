package demo_class;

import abstract_classes.Delivery_Cardeno;
import interfaces.DeliverySystem_Cardeno;
import implementations.StandardDelivery_Jagunap;
import implementations.PremiumDelivery_Jagunap;
import components.DeliveryService_Jagunap;

/**
 * @author Jagunap, Janelle
 *
 * ===================== CODE-BASED ANALYSIS =====================
 *
 * Q1: What abstract class did you create?
 * A1: I did not create the abstract class. I used Delivery_Cardeno,
 *     which was created by Cardeno.
 *
 * Q2: What interface did you create?
 * A2: I did not create the interface. I used DeliverySystem_Cardeno,
 *     which was created by Cardeno.
 *
 * Q3: What methods did you override?
 * A3: The overridden methods are:
 *     - deliver()
 *     - calculateETA()
 *     - confirmDelivery()
 *     - updateStatus()
 *     - cancelDelivery()
 *     - trackLocation()
 *
 * Q4: What methods did you overload?
 * A4: Method overloading is demonstrated through different behaviors
 *     of the same abstract/interface method names implemented
 *     differently in StandardDelivery_Jagunap and PremiumDelivery_Jagunap.
 *
 * Q5: Where does dynamic binding occur in your code?
 * A5: Dynamic binding occurs when Delivery_Cardeno and
 *     DeliverySystem_Cardeno references are assigned to different
 *     concrete implementations at runtime (see lines in main()).
 *
 * Q6: Which part shows polymorphism?
 * A6: Polymorphism is shown when both delivery objects are treated
 *     as Delivery_Cardeno and DeliverySystem_Cardeno types but execute
 *     different behaviors.
 *
 * Q7: How does your design achieve low coupling?
 * A7: Low coupling is achieved because the component class
 *     (DeliveryService_Jagunap) depends only on the abstract class
 *     Delivery_Cardeno, not on concrete implementations.
 *
 * Q8: How does your design achieve high cohesion?
 * A8: High cohesion is achieved because each class has a single,
 *     focused responsibility: delivery logic, service logic,
 *     or abstraction/interface definition.
 * ===============================================================
 */

public class AbstractionPolyDemo_Jagunap {

    public static void main(String[] args) {

        System.out.println("=== DELIVERY SYSTEM DEMO START ===\n");

        // =========================
        // Component Objects (Composition)
        // =========================
        DeliveryService_Jagunap basicService =
                new DeliveryService_Jagunap("Basic Handling", 50);

        DeliveryService_Jagunap premiumService =
                new DeliveryService_Jagunap("Priority Insurance", 300);

        // =========================
        // Concrete Implementations
        // =========================
        StandardDelivery_Jagunap standardDelivery =
                new StandardDelivery_Jagunap(
                        "Books Package",
                        "Laguna",
                        "Book Store",
                        "Student",
                        5,
                        basicService
                );

        PremiumDelivery_Jagunap premiumDelivery =
                new PremiumDelivery_Jagunap(
                        "Laptop Package",
                        "Cebu",
                        "Tech Company",
                        "Client",
                        "Elite Courier",
                        true,
                        true,
                        premiumService
                );

        // =========================
        // Dynamic Binding (Abstract Reference)
        // =========================
        Delivery_Cardeno delivery1 = standardDelivery;
        Delivery_Cardeno delivery2 = premiumDelivery;

        DeliverySystem_Cardeno system1 = standardDelivery;
        DeliverySystem_Cardeno system2 = premiumDelivery;

        // =========================
        // Polymorphic Behavior
        // =========================
        delivery1.track();
        delivery1.calculateETA();
        delivery1.deliver();

        System.out.println();

        delivery2.track();
        delivery2.calculateETA();
        delivery2.deliver();

        System.out.println("\n=== STATUS CHECK ===\n");

        system1.updateStatus();
        system1.confirmDelivery();

        System.out.println();

        system2.updateStatus();
        system2.confirmDelivery();

        // =========================
        // Interface Default Methods
        // =========================
        System.out.println("\n=== SUPPORT SERVICES ===\n");
        system1.contactSupport();
        system2.openHelpCenter();

        System.out.println("\n=== DEMO COMPLETED ===");
    }
}