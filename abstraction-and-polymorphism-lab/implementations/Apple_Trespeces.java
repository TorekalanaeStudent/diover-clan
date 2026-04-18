package implementations;

import abstract_classes.Gadget_Ovejera;
import interfaces.SmartphoneSystem_Ovejera;

/**
 * @author Trespeces, Guillermo II O.
 * @willj067
 */

public class Apple_Trespeces extends Gadget_Ovejera implements SmartphoneSystem_Ovejera {

    // constructor
    public Apple_Trespeces(String name, String brand, int batteryLevel, int price) {
        super(name, brand, batteryLevel, price);
    }

    @Override
    public void powerOn() {
        System.out.println(getName() + " is powering on... Hello from iOS 26!");
    }

    @Override
    public void useGadget() {
        System.out.println(getName() + " is now in use.");
        batterySaver(getBatteryLevel());
    }

    @Override
    public void makeCall() {
        System.out.println(getName() + " is calling...");
    }

    @Override
    public void makeCall(String contact) {
        System.out.println(getName() + " is calling " + contact + " via FaceTime Audio...");
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(getName() + " sent via iMessage: \"" + message + "\"");
    }

    @Override
    public void connectToInternet() {
        System.out.println(getName() + " connected to the internet via mobile data or WiFi.");
    }
}