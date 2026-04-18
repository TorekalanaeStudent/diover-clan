package abstract_classes;

/**
 * @author Arban, Jhave P.
 */
public abstract class WashingMachine_Arban {

    private String brand;

    // constructor
    public WashingMachine_Arban(String brand) {
        this.brand = brand;
    }

    // abstract methods
    public abstract void startWash();
    public abstract void stopWash();

    // concrete method
    public void showBrand() {
        System.out.println("Washing Machine: " + brand);
    }
}
