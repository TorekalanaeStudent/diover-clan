package interfaces;

/**
 * @author Trespeces, Guillermo II O.
 * @willj067
 */

public interface Capturable_Trespeces {

    // abstract method - will be overridden
    void capture();

    // default method
    default void captureMessage() {
        System.out.println("A piece has been captured!");
    }
}