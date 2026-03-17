package sub_class;

import parent_class.Gun_go;

/**
 * 
 * Child (Subclass) Class — extends Gun 
 *	This class is made by Seth
 * IS-A Relationship: An M4 IS-A Gun.
 *
 * This is made by Vince Justin Navarro
 *   
 */
public class M4_Navarro extends Gun_Go {
 
    // Added Attributes (unique to M4) 
    String fireMode;      // "Single", "Burst", or "Auto"
    boolean hasSuppressor;
 
    // Constructor
    public M4_Navarro() {
        this.name          = "M4A1";
        this.caliber       = "5.56x45mm NATO";
        this.capacity      = 30;
        this.fireMode      = "Auto";
        this.hasSuppressor = false;
    }
 
    // Overridden Methods
 
    @Override
    public void shoot() {
        switch (fireMode) {
            case "Single":
                System.out.println(name + " - Seth fires a single round of "
                        + caliber + (hasSuppressor ? " - *pfft*" : " CRACK!"));
                break;
            case "Burst":
                System.out.println(name + " - Seth fires a 3-round burst of "
                        + caliber + (hasSuppressor ? " - *pfft pfft pfft*" : " CRACK! CRACK! CRACK!"));
                break;
            case "Auto":
                System.out.println(name + " - Seth fires a full-auto fire — " + capacity
                        + " rounds of " + caliber + (hasSuppressor ? " - *brrrp*" : " - BRRRAAAAHH!"));
                break;
        }
    }
 
    @Override
    public void reload() {
        System.out.println(name + " - Seth drops the empty mag and slaps in a fresh "
                + capacity + "-round " + caliber + " magazine.");
    }
 
    // New Behaviors
    public void switchFireMode() {
        switch (fireMode) {
            case "Single": fireMode = "Burst";  break;
            case "Burst":  fireMode = "Auto";   break;
            case "Auto":   fireMode = "Single"; break;
        }
        System.out.println(name + " - Seth switches fire mode to: " + fireMode);
    }
 
   //New Method 
    public void attachSuppressor() {
        hasSuppressor = !hasSuppressor;
        System.out.println(name + " suppressor: " + (hasSuppressor ? "ATTACHED" : "REMOVED "));
    }
 
}