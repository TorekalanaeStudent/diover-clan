package interfaces;

/**
 
@author Arban, Jhave P.*/
public interface Laundry_Arban {

    // abstract methods
    void startWash();
    void stopWash();

    // default method
    default void showBrand(String brand) {
        System.out.println("Washing Machine: " + brand);
    }
}