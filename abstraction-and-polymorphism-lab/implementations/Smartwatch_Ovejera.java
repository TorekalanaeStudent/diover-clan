package implementations;

import abstract_classes.WearableDevice_Onte;
import interfaces.DeviceSystem_Onte;

/**
 * @author Ovejera, Ziggy
 */

public class Smartwatch_Ovejera extends WearableDevice_Onte implements DeviceSystem_Onte {

    // Default Constructor
    public Smartwatch_Ovejera() {
        super();
        setDeviceName("Galaxy Watch");
        setBatteryLife(100);
    }

    // Parameterized Constructor
    public Smartwatch_Ovejera(String name, double battery) {
        super();
        setDeviceName(name);
        setBatteryLife(battery);
    }

    // ================= ABSTRACT METHOD =================
    @Override
    public void monitorHealth() {
        System.out.println(getDeviceName() + " is tracking heart rate.");
    }

    // ✅ REQUIRED INTERFACE METHOD (FIXES YOUR ERROR)
    @Override
    public void syncData(String device) {
        System.out.println(getDeviceName() + " is syncing data with " + device + ".");
    }

    // ================= OVERLOADING =================
    public void monitorHealth(String mode) {
        System.out.println(getDeviceName() + " is monitoring in " + mode + " mode.");
    }

    // Extra Method
    public void sendNotification(String message) {
        System.out.println(getDeviceName() + ": " + message);
    }
}