package sub_class;

import parent_class.Gun_Go;

/**
 *
 * Child (Subclass) Class — extends Gun (Bonus 2x)
 * This class is made by Seth.
 * IS-A Relationship: An SVD IS-A Gun.
 *
* This is made by Vince Justin Navarro
 *   
 */
public class SVD_Navarro extends Gun_Go {

    //  Added Attributes (Unique to SVD)
    int zoomLevel;       
    boolean isSuppressed; 

    // --- Constructor ---
    public SVD_Navarro() {
        this.name         = "SVD";
        this.caliber      = "7.62x54mmR";
        this.capacity     = 10;
        this.zoomLevel    = 10;
        this.isSuppressed = false;
    }

    // Overridden Methods

    @Override
    public void shoot() {
        System.out.println(name + " - Seth fires a precise single shot of " + caliber
                + (isSuppressed ? " - *pew*" : " - HEADSHOT!"));
    }

    @Override
    public void reload() {
        System.out.println(name + " - Seth swaps in a fresh " + capacity
                + "-round box magazine of " + caliber + ".");
    }

    // New Behaviors 

    public void scope() {
        System.out.println(name + " - Seth scopes in at " + zoomLevel + "x magnification. Target acquired!.");
    }
    public void holdBreath() {
        System.out.println(name + " - Seth steadies his breath. Shot accuracy increased to 100%!.");
    }

     // New method
    public void toggleSuppressor() {
        isSuppressed = !isSuppressed;
        System.out.println(name + " suppressor: " + (isSuppressed ? "ON " : "OFF "));
    }

}
