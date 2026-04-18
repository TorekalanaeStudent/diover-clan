package demo_class;

import abstract_classes.Gadget_Ovejera;
import interfaces.SmartphoneSystem_Ovejera;
import implementations.Samsung_Trespeces;
import implementations.Apple_Trespeces;

/**
 * @author Trespeces, Guillermo II O.
 * @willj067
 *
 *  Q1: What abstract class did you use?
 *    - The abstract class that I used is "Gadget_Ovejera.java".
 *
 *  Q2: What interface did you use?
 *    - The interface that I used is "SmartphoneSystem_Ovejera.java".
 *
 *  Q3: What methods did you override?
 *    - The methods that were overridden were: powerOn(), useGadget(),
 *      makeCall(), makeCall(String contact), sendMessage(), and connectToInternet()
 *
 *  Q4: What methods did you overload?
 *    - The method that I overloaded is: 'makeCall()', one with no parameters,
 *      and one with a String contact parameter.
 *
 *  Q5: Where does dynamic binding occur in your code?
 *    - Dynamic binding occurs when Gadget_Ovejera references (phone1, phone2)
 *      call powerOn() and useGadget() at runtime. Java decides which
 *      implementation to execute based on the actual object type.
 *
 *  Q6: Which shows polymorphism?
 *    - Polymorphism is shown when Samsung_Trespeces and Apple_Trespeces objects are 
 * 	    assigned to Gadget_Ovejera references, and their overridden methods behave 
 *	    differently despite being called the same way.
 *
 *  Q7: How does your design achieve low coupling?
 *    - Low coupling is achieved because Samsung_Trespeces and Apple_Trespeces
 *      are independent from each other, changing one does not affect the other.
 *
 *  Q8: How does your design achieve high cohesion?
 *    - High cohesion is achieved because each class has a focused responsibility,
 *      Gadget_Ovejera handles general gadget behavior, SmartphoneSystem_Ovejera
 *      defines smartphone-specific actions, and the implementations handle
 *      a specific behavior only.
 */

public class AbstractionPolyDemo_Trespeces {
    public static void main(String[] args) {
        System.out.println("=== Start ===");

        // implementations
        Samsung_Trespeces samsung = new Samsung_Trespeces("Galaxy S25 Ultra", "Samsung", 67, 110990);
        Apple_Trespeces apple = new Apple_Trespeces("iPhone 17 Pro Max", "Apple", 67, 146990);

        // display info
        samsung.displayInfo();
        System.out.println();
        apple.displayInfo();

        System.out.println("\n=== Powering On ===");

        // dynamic binding - runtime polymorphism
        Gadget_Ovejera phone1 = samsung;
        Gadget_Ovejera phone2 = apple;

        phone1.powerOn();
        phone2.powerOn();

        System.out.println("\n=== Using the Phones ===");
        phone1.useGadget();
        phone2.useGadget();

        System.out.println("\n=== Calls n' Messages ===");

        // overloaded
        samsung.makeCall();
        samsung.makeCall("Mommy");
        apple.makeCall();
        apple.makeCall("Ziggy Ovejera");

        samsung.sendMessage("Hello is this aura? From Samsung S25 Ultra fully paid.");
        apple.sendMessage("Hello this is aura! from iPhone 17 Pro Max fully paid!");
        System.out.println("\n=== Connecting to mikhha ===");
        samsung.connectToInternet();
        apple.connectToInternet();

        System.out.println("\n=== Notifications ===");

        // default interface methods
        samsung.checkNotifications();
        apple.checkNotifications();

        System.out.println("\n=== Charging ===");
        // concrete method from abstract class
        samsung.charge(25);
        apple.charge(1);

        System.out.println("\n=== DEMO Completed ===");
    }
}