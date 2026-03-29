package composed_class;

import component_class.Clothes_Obedoza;
import component_class.Finger_Nono;
import component_class.Kulangot;

/**
 * Composed Class
 * Person_Ovejera HAS-A Clothes_Obedoza
 * Person_Ovejera HAS-A Finger_Nono
 * Person_Ovejera HAS-A Kulangot
 */
public class Person_Ovejera {

    // Attributes
    private String personName;
    private Clothes_Obedoza clothes;
    private Finger_Nono finger;
    private Kulangot kulangot;

    // Constructor
    public Person_Ovejera(String personName, Clothes_Obedoza clothes, Finger_Nono finger, Kulangot kulangot) {
        this.personName = personName;
        this.clothes = clothes;
        this.finger = finger;
        this.kulangot = kulangot;
    }

    // =========================
    // GETTERS & SETTERS
    // =========================
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Clothes_Obedoza getClothes() {
        return clothes;
    }

    public void setClothes(Clothes_Obedoza clothes) {
        this.clothes = clothes;
    }

    public Finger_Nono getFinger() {
        return finger;
    }

    public void setFinger(Finger_Nono finger) {
        this.finger = finger;
    }

    public Kulangot getKulangot() {
        return kulangot;
    }

    public void setKulangot(Kulangot kulangot) {
        this.kulangot = kulangot;
    }

    // =========================
    // BEHAVIORS
    // =========================

    // Preparing outfit
    public void prepareOutfit() {
        System.out.println("=== " + personName + " is preparing an outfit ===");
        clothes.describe();
        clothes.chooseColor();
    }

    // Buying clothes
    public void buyClothes() {
        System.out.println(personName + " is trying to buy clothes...");
        clothes.buyClothing();
    }

    // Using finger actions
    public void useFinger() {
        System.out.println(personName + " is using their finger...");
        finger.bend();
        finger.straighten();
    }

    // Kulangot combo 
    public void flickKulangot() {
        System.out.println(personName + " is preparing kulangot attack...");
        kulangot.roll();
        kulangot.flick();
    }

    // Status report
    public void statusReport() {
        System.out.println("\n====== PERSON STATUS REPORT ======");
        System.out.println("Name: " + personName);
        clothes.describe();
        kulangot.describe();
        System.out.println("Finger Bent: " + finger.isBent());
        System.out.println("=================================\n");
    }
}