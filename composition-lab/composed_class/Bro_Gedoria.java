package composed_class;

import component_class.Bibig_Malig;
import component_class.Hands_Navarro;
import component_class.Kulangot;

/**
 * Composed Class: Bro_Gedoria
 * Using Bibig_Malig, Hands_Navarro, Kulangot
 * Rajan Kurt O. Gedoria
 * Done with the help of AI
 *HAS-A relationships:
*Bro_Gedoria has a Bibig_Malig, Hands_Navarro, and Kulangot as its components.
*Classes reused:
*The classes Bibig_Malig, Hands_Navarro, and Kulangot are reused through composition.
*How composition reduces coupling:
*Composition reduces coupling by allowing Bro_Gedoria to interact with components only through their public interfaces without depending on their internal details.
*How high cohesion is implemented:
*High cohesion is implemented by keeping Bro_Gedoria focused on coordinating its components’ behaviors without mixing unrelated responsibilities.
*How cohesion is maintained:
*Cohesion is maintained by delegating specific tasks to the component classes, ensuring each class handles its own focused behavior.
*Inheritance was not used as Bro_Gedoria is not a type of its components
 */
public class Bro_Gedoria {

    // Attributes
    private boolean gutom; // is hungry
    private boolean busy;  // is currently busy

    private Bibig_Malig bibig;   // mouth component
    private Hands_Navarro hands; // hands component
    private Kulangot kulangot;   // kulangot component

    // DEFAULT CONSTRUCTOR
    public Bro_Gedoria() {
        gutom = false;
        busy = false;

        bibig = new Bibig_Malig("Idle", 100);
        hands = new Hands_Navarro("Brown", "Medium", true);
        kulangot = new Kulangot("Green", "Small", true);
    }

    // PARAMETERIZED CONSTRUCTOR
    public Bro_Gedoria(boolean gutom, Bibig_Malig bibig,
                       Hands_Navarro hands, Kulangot kulangot) {
        this.gutom = gutom;
        this.bibig = bibig;
        this.hands = hands;
        this.kulangot = kulangot;
        this.busy = false;
    }

    // Getters
    public boolean isGutom() {
        return gutom;
    }

    public boolean isBusy() {
        return busy;
    }

    public Bibig_Malig getBibig() {
        return bibig;
    }

    public Hands_Navarro getHands() {
        return hands;
    }

    public Kulangot getKulangot() {
        return kulangot;
    }

    // Setters
    public void setGutom(boolean gutom) {
        this.gutom = gutom;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public void setBibig(Bibig_Malig bibig) {
        this.bibig = bibig;
    }

    public void setHands(Hands_Navarro hands) {
        this.hands = hands;
    }

    public void setKulangot(Kulangot kulangot) {
        this.kulangot = kulangot;
    }

    // Behavior Methods

    public void speak() {
        System.out.println("Bro is about to speak...");
        bibig.talk();
        busy = true;
    }

    public void eat() {
        if (busy) {
            System.out.println("Bro is busy! Cannot eat right now.");
        } else {
            System.out.println("Bro starts eating...");
            bibig.eat();
            gutom = false;
        }
    }

    public void pickNose() {
        System.out.println("Bro is picking their nose...");
        hands.pickingYourNose();
    }

    public void useHands() {
        hands.usingHands();
    }

    public void inspectKulangot() {
        System.out.println("Bro inspects the kulangot...");
        kulangot.describe();
    }

    public void flickKulangot() {
        System.out.println("Bro prepares to flick the kulangot...");
        kulangot.flick();
    }

    // Combined routine
    public void fullRoutine() {
        System.out.println("=== Bro Full Routine ===");
        speak();
        useHands();
        pickNose();
        inspectKulangot();
        flickKulangot();
    }
}
