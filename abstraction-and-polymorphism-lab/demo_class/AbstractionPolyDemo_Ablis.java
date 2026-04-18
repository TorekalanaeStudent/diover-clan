/**
 * Author: Ablis, Margreleigne M.
 * Classes used by: Rajan Kurt Gedoria and Ablis, Margreleigne M.
 * Demonstration class for Abstraction and Polymorphism Lab
 * 
 * 
 * *=====Code-Based Analysis=====*
 *1. What abstract class did you create?
 * - I created The Superhero_Ablis class and I used Flashlight_Gedoria 
 *   and LightSystem_Gedoria for the implementation.
 * 
 *2. What interface did you create?
 * - I created the SuperheroSystem_Ablis and I used Flashlight_Gedoria 
 *   and LightSystem_Gedoria for the implementation.
 * 
 *3. What methods did you override? 
 * - showBatteryStatus(), turnOn(), turnOff(), showModel()
 *   from Flashlight_Gedoria and LightSystem_Gedoria
 * 
 *4. What methods did you overload?
 * - describe() from StageLight_Ablis and SpotLight_Ablis
 * 
 *5. Where does dynamic binding occur in your code?
 * - In Flashlight_Gedoria calls light.showBatteryStatus() and LightSystem_Gedoria calls
 *   system.turnOn(), system.turnOff(), system.showModel()
 * 
 *6. Which part shows polymorphism?
 * - Flashlight_Gedoria and LightSystem_Gedoria calls the same method on
 *   StageLight_Ablis and Spotlight_Ablis but each behaviour is different based on the
 *   implementation of the method in each class.
 *      
 *7. How does your design achieve low coupling?
 * - This demo class used Flashlight_Gedoria and LightSystem_Gedoria 
 *   instead of directly using StageLight_Ablis and SpotLight_Ablis. 
 *
 *8. How does your design achieve high cohesion?
 * - Flashlight_Gedoria: shared flashlight behaviour
 * - LightSystem_Gedoria: shared light system behaviour
 * - StageLight_Ablis: specific stage light behaviour
 * - SpotLight_Ablis: specific spotlight behaviour
 * - This Demo Class runs or demonstrates the features of the above classes.
 * ========================================================================================
 */

package demo_class;

import implementations.SpotLight_Ablis;
import implementations.StageLight_Ablis;
import abstract_classes.Flashlight_Gedoria;
import interfaces.LightSystem_Gedoria;

public class AbstractionPolyDemo_Ablis {

    public static void main(String[] args) {

        // Default constructors
        StageLight_Ablis stageDef = new StageLight_Ablis();
        SpotLight_Ablis spotDef = new SpotLight_Ablis();

        // Parameterized constructors
        StageLight_Ablis stagePar = new StageLight_Ablis("StageLight Ultra", 90, 80, "Red", true);
        SpotLight_Ablis spotPar = new SpotLight_Ablis("SpotLight B", 70, "Wide", 20, false);

        // method overloading
        System.out.println("--- METHOD OVERLOADING ---");
        System.out.println();
        stagePar.describe("Stage Light Profile", "A stage light used for illuminating large areas on stage.");
        System.out.println();
        spotPar.describe("Spot Light Profile", "A spotlight used to focus on specific areas on stage.");
        System.out.println();

        // method overriding
        System.out.println("--- METHOD OVERRIDING ---");
        System.out.println();
        stageDef.showBatteryStatus();
        stageDef.turnOn();
        stageDef.turnOff();
        System.out.println();
        spotDef.showBatteryStatus();
        spotDef.turnOn();
        spotDef.turnOff();
        System.out.println();

        // default interface methods
        System.out.println("--- DEFAULT INTERFACE METHODS ---");
        stageDef.showModel(stageDef.getModel());
        spotDef.showModel(spotDef.getModel());
        System.out.println();

        // dynamic binding: flashlight_gedoria
        System.out.println("--- DYNAMIC BINDING: Flashlight_Gedoria ---");
        Flashlight_Gedoria[] lights = {
            new StageLight_Ablis("StageLight X", 95, 90, "Green", false),
            new SpotLight_Ablis("SpotLight Y", 80, "Narrow", 15, false)
        };

        for (Flashlight_Gedoria light : lights) {
            light.showBatteryStatus();
        }
        System.out.println();

        // dynamic binding: LightSystem_Gedoria
        System.out.println("--- DYNAMIC BINDING: LightSystem_Gedoria ---");
        LightSystem_Gedoria[] systems = {
            new StageLight_Ablis("StageLight X", 95, 90, "Green", false),
            new SpotLight_Ablis("SpotLight Y", 80, "Wide", 30, false)
        };

        for (LightSystem_Gedoria system : systems) {
            system.turnOn();
            system.turnOff();
            system.showModel("Ablis Light");
            System.out.println();
        }
    }
}
