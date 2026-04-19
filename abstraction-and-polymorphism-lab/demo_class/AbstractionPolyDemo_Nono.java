package demo_class;

import implementations.SmartFan_Nono;
import implementations.SmartLight_Nono;
import abstract_classes.Device_Jagunap;
import interfaces.EnergyEfficient_Jagunap;

/**
 * @author Nono, Mary Angeline B.
 *
 * Q1: What abstract class did you create?
 * A1: AvatarCore_Nono
 *
 * Q2: What interface did you create?
 * A2: FireAvatarSystem_Nono
 *
 * Q3: What methods did you override?
 * A3: performTask(), getDeviceType(), energyUsagePerTask()
 *
 * Q4: What methods did you overload?
 * A4: compareDevices() method (3 versions)
 *
 * Q5: Where does dynamic binding occur?
 * A5: In Device_Jagunap references (device1, device2)
 *
 * Q6: Which shows polymorphism?
 * A6: SmartFan and SmartLight used as Device_Jagunap
 *
 * Q7: Low coupling?
 * A7: Uses abstract/interface instead of concrete classes
 *
 * Q8: High cohesion?
 * A8: Each class has a single responsibility
 */

public class AbstractionPolyDemo_Nono {

    public static void main(String[] args) {

        System.out.println("=== Creating Phase ===");

        // Objects
        SmartFan_Nono fan = new SmartFan_Nono("Turbo Fan", 90, 5);
        SmartLight_Nono light = new SmartLight_Nono("LED Light", 85, 75);

        System.out.println(fan.getDeviceName() + " - " + fan.getDeviceType());
        System.out.println(light.getDeviceName() + " - " + light.getDeviceType());

        // =========================
        // Runtime Polymorphism
        // =========================
        Device_Jagunap device1 = fan;
        Device_Jagunap device2 = light;

        System.out.println("\n=== DEVICE OPERATION ===");

        device1.powerOn();
        device1.performTask();

        device2.powerOn();
        device2.performTask();

        // =========================
        // Interface Usage
        // =========================
        System.out.println("\n=== ENERGY CHECK ===");

        EnergyEfficient_Jagunap e1 = fan;
        EnergyEfficient_Jagunap e2 = light;

        e1.displayEnergyRating();
        e2.displayEnergyRating();

        // =========================
        // METHOD OVERLOADING DEMO
        // =========================
        System.out.println("\n=== METHOD OVERLOADING ===");

        compareDevices(device1, device2);
        System.out.println();

        compareDevices(device1, device2, "Detailed Comparison");
        System.out.println();

        compareDevices(device1, device2, "Full Report", true);

        // =========================
        // END
        // =========================
        System.out.println("\n=== DEMO COMPLETED ===");
    }

    // =========================
    // OVERLOADED METHODS
    // =========================

    // Version 1: Basic comparison
    public static void compareDevices(Device_Jagunap d1, Device_Jagunap d2) {
        System.out.println(d1.getDeviceName() + " vs " + d2.getDeviceName());
        System.out.println("Type: " + d1.getDeviceType()
                + " | " + d2.getDeviceType());
    }

    // Version 2: With title
    public static void compareDevices(Device_Jagunap d1, Device_Jagunap d2, String title) {
        System.out.println("=== " + title + " ===");
        compareDevices(d1, d2);
    }

    // Version 3: Full detailed comparison
    public static void compareDevices(Device_Jagunap d1, Device_Jagunap d2,
                                      String title, boolean showEnergy) {
        compareDevices(d1, d2, title);

        if (showEnergy) {
            System.out.println("\nEnergy Usage:");
            System.out.println(d1.getDeviceName() + ": "
                    + ((EnergyEfficient_Jagunap) d1).energyUsagePerTask());

            System.out.println(d2.getDeviceName() + ": "
                    + ((EnergyEfficient_Jagunap) d2).energyUsagePerTask());
        }
    }
}