package implementations;

import abstract_classes.Gadget_Ovejera;
import interfaces.SmartphoneSystem_Ovejera;

/**
 * @author Onte, Vince Gian D.
 * AndroidPhone Implementation
 */

public class AndroidPhone_Onte extends Gadget_Ovejera implements SmartphoneSystem_Ovejera {

    // Attributes
    private Camera camera; // Camera object
    private int storage; // Storage in GB
    private int ram; // RAM in GB
    private String osVersion; // Android version
    private boolean isLocked; // Status

    // Default Constructor
    public AndroidPhone_Onte() {
        super("Samsung Galaxy S26", "Samsung", 100, 72990);

        this.camera = new Camera();
        setStorage(512);
        setRam(16);
        setOsVersion("Android 14");
        this.isLocked = true;
    }

    // Parameterized Constructor
    public AndroidPhone_Onte(String name, String brand, int battery, int price,
                             int storage, int ram, String osVersion) {

        super(name, brand, battery, price);

        this.camera = new Camera();
        setStorage(storage);
        setRam(ram);
        setOsVersion(osVersion);
        this.isLocked = true;
    }

    // Overrides on Abstract Class
    @Override
    public void powerOn() {
        System.out.println(getName() + " is turning on.");
    }

    @Override
    public void useGadget() {
        System.out.println("Using the Android phone.");
    }

    // Overrides on Interface
    @Override
    public void makeCall() {
        System.out.println("Calling last dialed number");
    }

    // Overloaded method
    @Override
    public void makeCall(String contact) {
        System.out.println("Calling: " + contact + "...");
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending message: " + message);
    }

    @Override
    public void connectToInternet() {
        System.out.println("Connecting to WiFi (Android)...");
    }

    // Composition method
    public void takePicture() {
        camera.capture();
    }

    // Additional behavior
    public void unlockPhone() {
        this.isLocked = false;
        System.out.println("Phone unlocked.");
    }

    // Getters
    public int getStorage() { return storage; }
    public int getRam() { return ram; }
    public String getOsVersion() { return osVersion; }
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

    public void setOsVersion(String osVersion) {

        // NULL + EMPTY CHECK (FIXED)
        if (osVersion == null || osVersion.isBlank()) {
            System.out.println("Invalid OS version!");
            this.osVersion = "Unknown Android";
            return;
        }

        System.out.println("OS Version set to: " + osVersion);
        this.osVersion = osVersion;
    }
}

//Component class for Low Coupling
class Camera {

    public void capture() {
        System.out.println("Android camera captured a photo.");
    }
}