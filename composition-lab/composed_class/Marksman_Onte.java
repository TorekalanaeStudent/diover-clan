package composed_class;

/**
 * Marksman_Onte HAS-A Hands_Navarro
 * Marksman_Onte HAS-A Gun_Magazine_Go
 * Marksman_Onte HAS-A Kulangot
 * @author (Vince Gian D. Onte)
 */

import component_class.Hands_Navarro;
import component_class.Gun_Magazine_Go;
import component_class.Kulangot;
public class Marksman_Onte {

    // Attributes
    private String marksmanName;
    private Hands_Navarro hands;
    private Gun_Magazine_Go magazine;
    private Kulangot kulangot;

    // Constructors
    public Marksman_Onte(String marksmanName, Hands_Navarro hands, Gun_Magazine_Go magazine, Kulangot kulangot) {
        this.marksmanName = marksmanName;
        this.hands = hands;
        this.magazine = magazine;
        this.kulangot = kulangot;
    }
    //Getters & Setters
    public String getMarksmanName() {
        return marksmanName;
    }
    public void setMarksmanName(String marksmanName) {
        this.marksmanName = marksmanName;
    }
    public Hands_Navarro hands() {
        return hands;
    }
    public void setHands(Hands_Navarro hands) {
        this.hands = hands;
    }
    public Gun_Magazine_Go magazine() {
        return magazine;
    }
    public void setMagazine(Gun_Magazine_Go magazine) {
        this.magazine = magazine;
    }
    public Kulangot kulangot() {
        return kulangot;
    }
    public void setKulangot(Kulangot kulangot) {
        this.kulangot = kulangot;
    }
    // Behaviors
    public void assessCombatReadiness() {
        System.out.println("\n=== " + marksmanName + " assessing combat readiness. ===");

        if(!hands.hasHands()){
            System.out.println("Critical issue: No hands detected.");
        } else {
            System.out.println("Hands are operational.");
        }
        System.out.println("Ammo available: " + magazine.getProjectileAmount());

        if (magazine.hasFeedingIssue()){
            System.out.println("Warning: Magazine Overload.");
        } else{
            System.out.println("Magazine condition is ready for combat.");
        }
    }

    public void steadyAim() {
        System.out.println(marksmanName + " steadies their aim");

        if (hands.hasHands()) {
            System.out.println("Grib stabilized using " + hands.getHandSize() + " hands.");
        } else {
            System.out.println("Unable to stabilize aim.");
        }
    }
    public void infuseProjectile() {
        System.out.println(marksmanName + " is preparing a round");
        if (!hands.hasHands()){
            System.out.println("Cannot coat round without hands.");
            return;
        } 
        System.out.println("Applying " + kulangot.getColor() + " kulangot coating to projectile...");
        kulangot.roll();
        System.out.println("Round successfully coated.");
    }
    public void loadInfusedAmmo(){
        System.out.println(marksmanName + " loading magazine");

        if (magazine.getProjectileAmount() <= 0) {
            System.out.println("Magazine is empty.");
            return;
        }
        if (magazine.hasFeedingIssue()) {
            System.out.println("Loading round failed due to feeding issue.");
        } else {
            System.out.println("Infused round is ready to fire.");
        }
    }

    public void executionPricisionShot() {
        System.out.println(marksmanName + " executing a pricise shot");
        if (magazine.getProjectileAmount() <= 0) {
            System.out.println("No rounds left to fire.");
            return;
        }
        magazine.launchProjectile();
        System.out.println("Target impacted with enhanced projectile.");
    }

    public void tacticalReport() {
        System.out.println("\n====== TACTICAL REPORT ======");
        System.out.println("Marksman : " + marksmanName);
        System.out.println("--- HANDS ---");
        hands.describe();
        System.out.println("--- KULANGOT ---");
        kulangot.describe();
        System.out.println("--- MAGAZINE ---");
        magazine.describe();
        System.out.println("=============================\n");
    }
}