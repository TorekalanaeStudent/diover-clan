package composed_class;

import component_class.Kulangot;
import component_class.Finger_Nono;
import component_class.Earwax_Cardeno;

/**
 * Composed Class
 * Support_Jagunap HAS-A Kulangot
 * Support_Jagunap HAS-A Finger_Nono
 * Support_Jagunap HAS-A Earwax_Cardeno
 * 
 * @author Jagunap
 */
public class Support_Jagunap {

    // =========================
    // ATTRIBUTES
    // =========================
    private String supportName;
    private Kulangot kulangot;
    private Finger_Nono finger;
    private Earwax_Cardeno earwax;

    // =========================
    // CONSTRUCTOR
    // =========================
    public Support_Jagunap(String supportName, Kulangot kulangot,
                           Finger_Nono finger, Earwax_Cardeno earwax) {
        this.supportName = supportName;
        this.kulangot = kulangot;
        this.finger = finger;
        this.earwax = earwax;
    }

    // =========================
    // GETTERS & SETTERS
    // =========================
    public String getSupportName() {
        return supportName;
    }

    public void setSupportName(String supportName) {
        this.supportName = supportName;
    }

    public Kulangot getKulangot() {
        return kulangot;
    }

    public void setKulangot(Kulangot kulangot) {
        this.kulangot = kulangot;
    }

    public Finger_Nono getFinger() {
        return finger;
    }

    public void setFinger(Finger_Nono finger) {
        this.finger = finger;
    }

    public Earwax_Cardeno getEarwax() {
        return earwax;
    }

    public void setEarwax(Earwax_Cardeno earwax) {
        this.earwax = earwax;
    }

    // =========================
    // BEHAVIORS
    // =========================
    public void pickNose() {
        System.out.println(supportName + " performs nose picking support...");
        finger.bend();
        kulangot.roll();
        finger.straighten();
    }

    public void flickKulangot() {
        System.out.println(supportName + " flicks the kulangot!");
        kulangot.flick();
    }

    public void cleanEar() {
        System.out.println(supportName + " cleans the ear...");
        earwax.clean(10);
        earwax.showInfo();
    }

    public void addEarwax(int value) {
        System.out.println(supportName + " accumulates earwax...");
        earwax.add(value);
    }

    public void statusReport() {
        System.out.println("\n====== SUPPORT STATUS REPORT ======");
        System.out.println("Support Name : " + supportName);
        kulangot.describe();
        System.out.println("Finger Used  : " + finger.getName() + 
                           " (Length: " + finger.getLength() + "mm)");
        earwax.showInfo();
        System.out.println("==================================\n");
    }
}