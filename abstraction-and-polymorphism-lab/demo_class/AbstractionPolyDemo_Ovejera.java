package demo_class;

import implementations.Smartphone_Ovejera;
import implementations.DeviceSystem_Ovejera;
import abstract_classes.Gadget_Ovejera;
import interfaces.SmartphoneSystem;

/**
 * =============================================================================
 * @author Ovejera, Ziggy
 * 
 * =====Code-Based Analysis=====
 * 1. What abstract class did you use?
 * - Gadget_Ovejera is used as the base class for all devices.
 * 
 * 2. What interface did you use?
 * - SmartphoneSystem is used to define system-related behaviors.
 * 
 * 3. What methods did you override?
 * - powerOn(), powerOff(), syncData()
 * 
 * 4. What methods did you overload?
 * - powerOn() with different parameters
 * 
 * 5. Where does dynamic binding occur?
 * - In loops using Gadget_Ovejera[] and SmartphoneSystem[]
 *   where methods are called through parent/interface references.
 * 
 * 6. Which part shows polymorphism?
 * - Arrays store different objects under one reference type
 *   and produce different outputs.
 * 
 * 7. How does your design achieve low coupling?
 * - The demo uses abstract class and interface references
 *   instead of concrete classes directly.
 * 
 * 8. How does your design achieve high cohesion?
 * - Each class has a single responsibility:
 *   - Gadget_Ovejera → base structure
 *   - SmartphoneSystem → system behavior
 *   - Implementations → device logic
 *   - Demo → runs the program
 * =============================================================================
 */

public class AbstractionPolyDemo_Ovejera {

    public static void main(String[] args) {

        // Default constructors
        Smartphone_Ovejera phoneDef = new Smartphone_Ovejera();
        DeviceSystem_Ovejera systemDef = new DeviceSystem_Ovejera();

        // Parameterized constructors
        Smartphone_Ovejera phoneParam =
                new Smartphone_Ovejera("iPhone", 80);

        DeviceSystem_Ovejera systemParam =
                new DeviceSystem_Ovejera("Android System", 90);


        // ================= METHOD OVERLOADING =================
        System.out.println("METHOD OVERLOADING:");
        phoneParam.powerOn("Gaming Mode");
        systemParam.powerOn(5);
        System.out.println();


        // ================= METHOD OVERRIDING =================
        System.out.println("METHOD OVERRIDING:");
        phoneDef.powerOn();
        systemDef.powerOn();
        System.out.println();


        // ================= INTERFACE METHODS =================
        System.out.println("INTERFACE METHODS:");
        phoneParam.syncData("Laptop");
        systemParam.syncData("Cloud");
        System.out.println();


        // ================= DEFAULT INTERFACE METHOD =================
        System.out.println("DEFAULT INTERFACE METHOD:");
        phoneDef.autoBackup();
        System.out.println();


        // ================= DYNAMIC BINDING (ABSTRACT CLASS) =================
        System.out.println("DYNAMIC BINDING (Gadget_Ovejera):");

        Gadget_Ovejera[] gadgets = {
            new Smartphone_Ovejera("Samsung", 75),
            new DeviceSystem_Ovejera("System A", 65),
            new Smartphone_Ovejera("Huawei", 60),
            new DeviceSystem_Ovejera("System B", 50)
        };

        for (Gadget_Ovejera g : gadgets) {
            g.powerOn(); // dynamic binding
        }

        System.out.println();


        // ================= DYNAMIC BINDING (INTERFACE) =================
        System.out.println("DYNAMIC BINDING (SmartphoneSystem):");

        SmartphoneSystem[] systems = {
            new Smartphone_Ovejera("Pixel", 85),
            new DeviceSystem_Ovejera("Main System", 95)
        };

        for (SmartphoneSystem s : systems) {
            s.syncData("Main Server"); // dynamic binding
        }

        System.out.println();
    }

    // ================= OVERLOADED METHOD =================
    public static void deviceInteraction(Gadget_Ovejera g1, Gadget_Ovejera g2) {
        System.out.println(g1.getName() + " interacts with " + g2.getName());

        ((SmartphoneSystem) g1).syncData(g2.getName());
    }
}