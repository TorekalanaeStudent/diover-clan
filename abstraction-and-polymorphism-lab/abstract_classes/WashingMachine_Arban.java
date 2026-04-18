package abstract_classes;

/**
 * @author Arban, Jhave P.
 */
public abstract class WashingMachine_Arban {

    private String brand;

    // constructor
    WashingMachine_Arban(String brand) {
        this.brand = brand;
    }

    // abstract methods
    abstract void startWash();
    abstract void stopWash();

    // concrete method
    void showBrand() {
        System.out.println("Washing Machine: " + brand);
    }
}
