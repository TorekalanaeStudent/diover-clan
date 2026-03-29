package composed_class;

import component_class.Kulangot;
import component_class.Ilong_Onte;
import component_class.Earwax_Cardeno;

/**
 * Composed Class
 * Mage_Nono HAS-A Kulangot
 * Mage_Nono HAS-A Ilong_Onte
 * Mage_Nono HAS-A Earwax_Cardeno
 * @author Mary Angeline Nono
 */

public class Mage_Nono {

    // Attributes
    private String mageName;
    private Kulangot kulangot;
    private Ilong_Onte ilong;
    private Earwax_Cardeno earwax;

    // Constructor
    public Mage_Nono(String mageName, Kulangot kulangot, Ilong_Onte ilong, Earwax_Cardeno earwax) {
        this.mageName = mageName;
        this.kulangot = kulangot;
        this.ilong = ilong;
        this.earwax = earwax;
    }

    // Getters & Setters
    public String getMageName() {
        return mageName;
    }

    public void setMageName(String mageName) {
        this.mageName = mageName;
    }

    public Kulangot getKulangot() {
        return kulangot;
    }

    public void setKulangot(Kulangot kulangot) {
        this.kulangot = kulangot;
    }

    public Ilong_Onte getIlong() {
        return ilong;
    }

    public void setIlong(Ilong_Onte ilong) {
        this.ilong = ilong;
    }

    public Earwax_Cardeno getEarwax() {
        return earwax;
    }

    public void setEarwax(Earwax_Cardeno earwax) {
        this.earwax = earwax;
    }

    // Behaviors
    public void pickNose() {
        System.out.println(mageName + " casts Nose Pick Spell...");
        ilong.sniff();
        kulangot.roll();
    }

    public void flickKulangot() {
        System.out.println(mageName + " casts Flick Spell...");
        kulangot.flick();
    }

    public void cleanEar() {
        System.out.println(mageName + " casts Ear Cleanse Spell...");
        earwax.clean(10);
        earwax.showInfo();
    }

    public void addEarwax(int value) {
        System.out.println(mageName + " accumulates magical earwax...");
        earwax.add(value);
    }

    public void statusReport() {
        System.out.println("\n====== MAGE STATUS REPORT ======");
        System.out.println("Mage       : " + mageName);
        kulangot.describe();
        ilong.displayInfo();
        earwax.showInfo();
        System.out.println("================================\n");
    }
}