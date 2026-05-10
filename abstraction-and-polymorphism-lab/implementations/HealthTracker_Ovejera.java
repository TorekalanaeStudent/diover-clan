package implementations;

import abstract_classes.WearableDevice_Onte;
import interfaces.DeviceSystem_Onte;

/**
 * @author ziggyovejera
 */

public class HealthTracker_Ovejera extends WearableDevice_Onte implements DeviceSystem_Onte {

    // Default Constructor
    public HealthTracker_Ovejera() {
        super();
        setDeviceName("FitTrack Pro");
        setBatteryLife(100);
    }

    // Parameterized Constructor
    public HealthTracker_Ovejera(String name, double battery) {
        super();
        setDeviceName(name);
        setBatteryLife(battery);
    }

    // ================= ABSTRACT METHOD =================
    @Override
    public void monitorHealth() {
        System.out.println(getDeviceName() + " is tracking calories and steps.");
    }

    // ================= INTERFACE METHOD =================
    @Override
    public void syncData(String device) {
        System.out.println(getDeviceName() + " is syncing health data with " + device + ".");
    }

    // ================= OVERLOADED METHOD =================
    public void monitorHealth(String activity) {
        System.out.println(getDeviceName() + " is tracking " + activity + ".");
    }

    // ================= EXTRA METHODS =================
    public void alertUser() {
        System.out.println(getDeviceName() + " sends a health alert notification.");
    }

    // ================= DESCRIBE METHODS =================
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