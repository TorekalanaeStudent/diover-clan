package composted;

import component_class.Finger_Nono;
import component_class.Tissue_Ovejera;
import component_class.Kulangot;


public class Pahid_Obedoza {

    // Has-A Relationship
    private Finger_Nono useFinger;
    private Tissue_Ovejera useTissue;
    private Kulangot pickKulangot;

    private String isPerson;

    // Constructor injection
    public Pahid_Obedoza (Finger_Nono useFinger, Tissue_Ovejera useTissue, Kulangot pickKulangot, String isPerson) {
        this.useFinger = useFinger;
        this.useTissue = useTissue;
        this.pickKulangot = pickKulangot;
        this.isPerson = isPerson;
    }

    // Behaviors 
    public void hideKulangot() {
        if (pickKulangot != null) {
            System.out.println("Pick kulangot using " + useFinger.getName() + " Finger.");
            System.out.println("Wipe "+ pickKulangot.getSize() + " kulangot on " + (useTissue.isMoist() ? "Moist" : "Dry") + " tissue.");
        } else {
            System.out.println("Find Kulangot first!");
        }
    }

    public void displayPerson() {
        if (pickKulangot != null) {
            System.out.println("Kulangot is sticky: "+ pickKulangot.isSticky());
        }

        if (useFinger != null) {
            useFinger.straighten();
        }
    }

    public void rollKulangot() {
    if (pickKulangot != null) pickKulangot.roll();
}




}
