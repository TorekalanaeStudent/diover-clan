package abstract_classes;

/**
 * @author Arban, Jhave P.
 * @jhavearban-ctrl
 */
public abstract class WashingMachine_Arban {

    String brand;
    this.brand = brand;

// abstract method
abstract void startWash();
abstract void stopWash();

// concrete method
void showBrand()
    System.out.println("Washing Machine: " + brand);

}