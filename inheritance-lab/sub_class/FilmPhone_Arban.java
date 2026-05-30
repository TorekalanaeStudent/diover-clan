package sub_class;

import parent_class.Smartphone_Gedoria;

public class FilmPhone_Arban extends Smartphone_Gedoria {

    // Additional attributes (film/camera related)
    private int cameraMP;
    private int storageCapacity;

    // Default Constructor
    public FilmPhone_Arban() {
        super("Samsung", "S25 Ultra", "Android", false);
        cameraMP = 0;
        storageCapacity = 0;
    }

    // Parameterized Constructor
    public FilmPhone_Arban(boolean powerStatus, int cameraMP, int storageCapacity) {
        super("Samsung", "S25 Ultra", "Android", powerStatus);
        this.cameraMP = cameraMP;
        this.storageCapacity = storageCapacity;
    }

    // Display specs
    public void displaySpecs() {
        System.out.println("=== Film Phone Specs ===");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("OS: " + operatingSystem);
        System.out.println("Power Status: " + (powerStatus ? "ON" : "OFF"));
        System.out.println("Camera: " + cameraMP + "MP");
        System.out.println("Storage: " + storageCapacity + "GB");
    }

    // Film Mode
    public void enableFilmMode() {
        if (powerStatus) {
            System.out.println("Film Mode Activated 🎬");
            System.out.println("4K Recording Enabled");
            System.out.println("Stabilization ON");
        } else {
            System.out.println("Cannot enable Film Mode. Phone is OFF.");
        }
    }
}