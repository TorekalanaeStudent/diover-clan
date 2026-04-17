package implementations;

import abstract_classes.WearableDevice_Onte;
import interfaces.DeviceSystem_Onte;
/**
 * @author ziggyovejera
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

    // ================= OVERLOADED METHOD =================
    public void monitorHealth(String mode) {
        System.out.println(getDeviceName() + " is monitoring in " + mode + " mode.");
    }

    // ================= EXTRA METHODS =================
    public void sendNotification(String message) {
        System.out.println(getDeviceName() + " shows notification: " + message);
    }

    // Overloaded describe method
    public void describe() {
        System.out.println("Device Info");
        System.out.println("Name    : " + getDeviceName());
        System.out.println("Battery : " + getBatteryLife() + "%");
    }

    public void describe(String title) {
        System.out.println("=== " + title + " ===");
        describe();
    }

    public void describe(String title, String note) {
        describe(title);
        System.out.println("Note: " + note);
    }
}