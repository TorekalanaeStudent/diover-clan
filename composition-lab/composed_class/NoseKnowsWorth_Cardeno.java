package composed_class;

import component_class.Finger_Nono;
import component_class.AppraisalSystem_Caneda;
import component_class.Kulangot;

public class NoseKnowsWorth_Cardeno {

    // HAS-A relationships (composition)
    private Finger_Nono finger;
    private AppraisalSystem_Caneda appraisal;
    private Kulangot kulangot;

    // Constructor using composition
    public NoseKnowsWorth_Cardeno(Finger_Nono finger, AppraisalSystem_Caneda appraisal, Kulangot kulangot) {
        this.finger = finger;
        this.appraisal = appraisal;
        this.kulangot = kulangot;
    }

    // Getters
    public Finger_Nono getFinger() { return finger; }
    public AppraisalSystem_Caneda getAppraisal() { return appraisal; }
    public Kulangot getKulangot() { return kulangot; }

    // Setters
    public void setFinger(Finger_Nono finger) { this.finger = finger; }
    public void setAppraisal(AppraisalSystem_Caneda appraisal) { this.appraisal = appraisal; }
    public void setKulangot(Kulangot kulangot) { this.kulangot = kulangot; }

    // Perform inspection
    // Cohesion: only handles inspection
    // Coupling: uses only public methods of component classes
    public void doInspection() {
        System.out.println("\nStarting inspection...");

        System.out.println("Finger in action:");
        finger.bend();
        System.out.println("Finger '" + finger.getName() + "' is inspecting.");

        System.out.println("Kulangot in action:");
        kulangot.roll();
        kulangot.flick();

        System.out.println("Appraising item:");
        appraisal.itemAppraisal();

        finger.straighten();
        System.out.println("Inspection complete.\n");
    }

    // Show status
    // Cohesion: only reports status
    // Coupling: accesses components via public getters
    public void showStatus() {
        System.out.println("\n--- STATUS REPORT ---");
        System.out.println("Finger bent? " + finger.isBent());
        System.out.println("Item: " + appraisal.getNameItem() +
                           ", Buyer: " + appraisal.getUserBuyerName() +
                           ", Active? " + appraisal.getUserActivity());
        System.out.println("Kulangot color: " + kulangot.getColor() +
                           ", size: " + kulangot.getSize() +
                           ", sticky? " + kulangot.isSticky());
        System.out.println("--------------------\n");
    }
}