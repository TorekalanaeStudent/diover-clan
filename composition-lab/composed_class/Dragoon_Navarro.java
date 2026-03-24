package composed_class;

import component_class.Gun_Magazine_Go;
import component_class.AppraisalSystem_Caneda;
import component_class.Kulangot;

/**
 * Composed Class
 * Dragoon_Navarro HAS-A Gun_Magazine_Go
 * Dragoon_Navarro HAS-A AppraisalSystem_Caneda
 * Dragoon_Navarro HAS-A Kulangot
 * @author NavarroVinceJustine
 */
public class Dragoon_Navarro {

    // Attributes
    private String dragoonName;
    private Gun_Magazine_Go magazine;         
    private AppraisalSystem_Caneda appraisal;  
    private Kulangot kulangot;                

    // Constructor
    public Dragoon_Navarro(String dragoonName, Gun_Magazine_Go magazine, AppraisalSystem_Caneda appraisal, Kulangot kulangot) {
        this.dragoonName = dragoonName;
        this.magazine = magazine;
        this.appraisal = appraisal;
        this.kulangot = kulangot;
    }

    // Getters & Setters
    public String getDragoonName() {
        return dragoonName;
    }

    public void setDragoonName(String dragoonName) {
        this.dragoonName = dragoonName;
    }

    public Gun_Magazine_Go getMagazine() {
        return magazine;
    }

    public void setMagazine(Gun_Magazine_Go magazine) {
        this.magazine = magazine;
    }

    public AppraisalSystem_Caneda getAppraisal() {
        return appraisal;
    }

    public void setAppraisal(AppraisalSystem_Caneda appraisal) {
        this.appraisal = appraisal;
    }

    public Kulangot getKulangot() {
        return kulangot;
    }

    public void setKulangot(Kulangot kulangot) {
        this.kulangot = kulangot;
    }

    // Behaviors

    public void prepareForDeployment() {
        System.out.println("=== " + dragoonName + " is preparing for deployment!!! ===");
        magazine.inspectProjectile();
        magazine.inspectFeedingIssue();
        appraisal.itemAppraisal();
    }

   
    public void fire() {
        System.out.println(dragoonName + " fires!");
        magazine.launchProjectile();
    }

  
    public void flickAtEnemy() {
        System.out.println(dragoonName + " reaches for their kulangot......");
        kulangot.roll();
        kulangot.flick();
    }

 
    public void statusReport() {
        System.out.println("\n====== DRAGOON STATUS REPORT ======");
        System.out.println("Dragoon  : " + dragoonName);
        magazine.describe();
        kulangot.describe();
        appraisal.isitemAppraised();
        System.out.println("===================================\n");
    }
}
