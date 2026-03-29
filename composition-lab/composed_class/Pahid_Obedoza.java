package composed_class;

import component_class.Finger_Nono;
import component_class.Tissue_Ovejera;
import component_class.Kulangot;


public class Pahid_Obedoza {

    // Has-A Relationship
    private Finger_Nono useFinger;
    private Tissue_Ovejera useTissue;
    private Kulangot pickKulangot;

    private String wipePerson;

    // Constructor injection
    public Pahid_Obedoza (Finger_Nono useFinger, Tissue_Ovejera useTissue, Kulangot pickKulangot, String wipePerson) {
        this.useFinger = useFinger;
        this.useTissue = useTissue;
        this.pickKulangot = pickKulangot;
        this.wipePerson = wipePerson;
    }

    // Setters for low coupling demonstration
    public void setFinger(Finger_Nono finger) { this.useFinger = finger; }
    public void setTissue(Tissue_Ovejera tissue) { this.useTissue = tissue; }
    public void setKulangot(Kulangot kulangot) { this.pickKulangot = kulangot; }

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
        else System.out.println("No kulangot to roll!");
    }

}
