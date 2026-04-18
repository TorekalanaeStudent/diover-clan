// Interface by: Rajan Kurt O. Gedoria

package interfaces;

public interface LightSystem_Gedoria {

    // abstract methods
    void turnOn();
    void turnOff();

    // default method
    default void showModel(String model) {
        System.out.println("Flashlight Model: " + model);
    }
}