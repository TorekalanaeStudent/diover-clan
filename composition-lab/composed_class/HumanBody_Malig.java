package composed_class;

import component_class.Ilong_Onte;
import component_class.Hands_Navarro;
import component_class.Kulangot;

public class HumanBody_Malig {

    private String name;
    private boolean isAwake;
    private boolean comboReady;

    private Ilong_Onte nose;
    private Hands_Navarro hands;
    private Kulangot kulangot;

    public HumanBody_Malig(String name, boolean isAwake,
                          Ilong_Onte nose,
                          Hands_Navarro hands,
                          Kulangot kulangot) {
        this.name = name;
        this.isAwake = isAwake;
        this.nose = nose;
        this.hands = hands;
        this.kulangot = kulangot;
    }

    public void wakeUp() {
        isAwake = true;
        System.out.println(name + " woke up.");
    }

    public void prepareCombo() {
        if (!isAwake) {
            System.out.println("Wake up first!");
            return;
        }
        comboReady = true;
        System.out.println("Combo ready...");
    }

    public void executeCombo() {
        if (!comboReady) {
            System.out.println("Combo not ready!");
            return;
        }

        System.out.println(" ULTIMATE MOVE ");

        if (hands.hasHands()) {
            hands.pickingYourNose();
            kulangot.flick();
        } else {
            System.out.println("No hands ");
        }
    }

    public void fullRoutine() {
        wakeUp();
        nose.sniff();
        nose.cleanNose();
        hands.usingHands();
        kulangot.roll();
        prepareCombo();
        executeCombo();
    }

    // LOW COUPLING (replace component)
    public void setNose(Ilong_Onte nose) {
        this.nose = nose;
    }
}