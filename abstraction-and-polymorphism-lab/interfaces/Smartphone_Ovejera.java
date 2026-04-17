package interfaces;

/**
 * @author Ovejera, Ziggy
 */

public interface SmartphoneSystem_Ovejera {

    // ABSTRACT METHODS
    void powerOn();

    void makeCall();

    void makeCall(String contact); // OVERLOADING

    void sendMessage(String message);

    void connectToInternet();

    // DEFAULT METHODS
    default void checkNotifications() {
        System.out.println("Checking notifications...");
    }

    default void batterySaver(int batteryLevel) {
        if (batteryLevel <= 20) {
            System.out.println("Battery Saver Mode Activated.");
        } else {
            System.out.println("Battery level is good.");
        }
    }
}