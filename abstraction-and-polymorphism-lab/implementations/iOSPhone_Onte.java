package implementations;

import abstract_classes.Gadget_Ovejera;
import interfaces.SmartphoneSystem_Ovejera;

/**
 * @author Onte, Vince Gian D.
 * iPhone Implementation
 */

public class iOSPhone_Onte extends Gadget_Ovejera implements SmartphoneSystem_Ovejera {

    // Attributes
    private FaceID faceID; // Composition object
    private int storage; // Storage in GB
    private int ram; // RAM in GB
    private String iosVersion; // iOS version
    private boolean isLocked; // Lock status

    // Default Constructor
    public iOSPhone_Onte() {
        super("iPhone 15 Pro", "Apple", 100, 80000);

        this.faceID = new FaceID();
        setStorage(256);
        setRam(8);
        setIosVersion("iOS 17");
        this.isLocked = true;
    }

    // Parameterized Constructor
    public iOSPhone_Onte(String name, String brand, int battery, int price,
                        int storage, int ram, String iosVersion) {

        super(name, brand, battery, price);

        this.faceID = new FaceID();
        setStorage(storage);
        setRam(ram);
        setIosVersion(iosVersion);
        this.isLocked = true;
    }

    // Overrides from Abstract Class
    @Override
    public void powerOn() {
        System.out.println(getName() + " is powering on (iOS System)...");
    }

    @Override
    public void useGadget() {
        System.out.println("Using iPhone applications...");
    }

    // Interface Methods
    @Override
    public void makeCall() {
        System.out.println("Calling recent contact...");
    }

    // Overloaded Method
    @Override
    public void makeCall(String contact) {
        System.out.println("Calling " + contact + " via FaceTime...");
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending iMessage: " + message);
    }

    @Override
    public void connectToInternet() {
        System.out.println("Connecting to WiFi (iOS)...");
    }

    // Composition method
    public void unlockWithFaceID() {
        faceID.scanFace();
        this.isLocked = false;
        System.out.println("iPhone unlocked.");
    }

    // Getters
    public int getStorage() { return storage; }
    public int getRam() { return ram; }
    public String getIosVersion() { return iosVersion; }
    public boolean isLocked() { return isLocked; }

    // Setters with NULL SAFETY + VALIDATION

    public void setStorage(int storage) {
        if (storage <= 0) {
            System.out.println("Invalid storage!");
            return;
        }
        System.out.println("Storage set to: " + storage + "GB");
        this.storage = storage;
    }

    public void setRam(int ram) {
        if (ram <= 0) {
            System.out.println("Invalid RAM!");
            return;
        }
        System.out.println("RAM set to: " + ram + "GB");
        this.ram = ram;
    }

    public void setIosVersion(String iosVersion) {

        // NULL + EMPTY CHECK
        if (iosVersion == null || iosVersion.isBlank()) {
            System.out.println("Invalid iOS version!");
            this.iosVersion = "Unknown iOS";
            return;
        }

        System.out.println("iOS Version set to: " + iosVersion);
        this.iosVersion = iosVersion;
    }
}

//Component class for Low Coupling
class FaceID {

    public void scanFace() {
        System.out.println("Face recognized successfully.");
    }
}