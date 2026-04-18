package demo_class;

import implementations.AndroidPhone_Onte;
import implementations.iOSPhone_Onte;
import abstract_classes.Gadget_Ovejera;
import interfaces.SmartphoneSystem_Ovejera;

/**
 * @author Onte, Vince Gian D.
 * @vinceonte
 *
 * Code Biased Analysis
 *
 * 1. What abstract class did you create?
 * - I created WearableDevice_Onte abstract class
 *
 * 2. What interface did you create?
 * - I created DeviceSystem_Onte interface
 *
 * 3. What methods did you override?
 * - The methods overridden are powerOn(), useGadget(), makeCall(), sendMessage(), and connectToInternet()
 *
 * 4. What methods did you overload?
 * - The methods overridden is makeCall(String contact)
 *
 * 5. Where does dynamic binding occur in your code?
 * - The dynamic binding occur in my code when Gadget_Ovejera and SmartphoneSystem_Ovejera
 *   references call powerOn(), useGadget(), and makeCall().
 *
 * 6. Which part shows polymorphism?
 * - Gadget_Ovejera phone1 = new AndroidPhone_Onte();
 * - SmartphoneSystem_Ovejera device1 = new iOSPhone_Onte();
 *
 * 7. How does your design achieve low coupling?
 * - The demo class works with these general types, so it does not depend on Android or iOS implementations.
 *
 * 8. How does your design achieve high cohesion?
 * - Each class has a single function:
 *   AndroidPhone handles Android behavior
 *   iOSPhone handles iOS behavior
 *   Gadget_Ovejera handles shared structure
 *   SmartphoneSystem_Ovejera defines actions
 */

public class AbstractionPolyDemo_Onte {

    public static void main(String[] args) {

        System.out.println("\nDemo Start");

        String barrier = "=================================";

        System.out.println(barrier + "\n=== ANDROID CLASS OUTPUT ===\n" + barrier);

        AndroidPhone_Onte android = new AndroidPhone_Onte();
        android.powerOn();
        android.useGadget();
        android.makeCall("Six");
        android.sendMessage("Hello Six");

        System.out.println("\n" + barrier + "\n=== iOS CLASS OUTPUT ===\n" + barrier);

        iOSPhone_Onte ios = new iOSPhone_Onte();
        ios.powerOn();
        ios.useGadget();
        ios.makeCall("Seven");
        ios.sendMessage("Hello Seven");

        System.out.println("\n" + barrier + "\n=== ABSTRACT CLASS OUTPUT ===\n" + barrier);

        Gadget_Ovejera g1 = android;
        Gadget_Ovejera g2 = ios;

        g1.powerOn();
        g1.useGadget();
        g2.powerOn();
        g2.useGadget();

        System.out.println("\n" + barrier + "\n=== INTERFACE OUTPUT ===\n" + barrier);

        SmartphoneSystem_Ovejera m1 = android;
        SmartphoneSystem_Ovejera m2 = ios;

        m1.sendMessage("Message from Six via interface");
        m2.sendMessage("Message from Seven via interface");

        System.out.println("\n" + barrier + "\n=== DYNAMIC BINDING ===\n" + barrier);

        Gadget_Ovejera device1 = new AndroidPhone_Onte();
        Gadget_Ovejera device2 = new iOSPhone_Onte();

        device1.powerOn();
        device1.useGadget();
        System.out.println(barrier);
        device2.powerOn();
        device2.useGadget();
        System.out.println(barrier);
        SmartphoneSystem_Ovejera phone1 = new AndroidPhone_Onte();
        SmartphoneSystem_Ovejera phone2 = new iOSPhone_Onte();
        System.out.println(barrier);
        phone1.sendMessage("Dynamic Binding from Six");
        phone2.sendMessage("Dynamic Binding from Seven");

        System.out.println("\n" + barrier + "\n===DEMO COMPLETE===\n" + barrier);
    }
}