package demo_class;

import implementations.AutomaticWasher_DeJuras;
import implementations.DrumWasher_DeJuras;
import abstract_classes.WashingMachine_Arban;
import interfaces.Laundry_Arban;

/**
 * @author DeJuras
 * 
 *  Q1: What abstract class did you create?
 *  Vehicles_DeJuras.java
 *
 *  Q2: What interface did you create?
 *  VehicleSystem_DeJuras.java
 *
 *  Q3: What methods did you override?
 *  startWash(), stopWash()
 *
 *  Q4: What methods did you overload?
 *  startWash(int time), stopWash(int program, int time) — AutomaticWasher
 *  startWash(double time), stopWash(double time, boolean autoStop) — DrumWasher
 *
 *  Q5: Where does dynamic binding occur in your code?
 *  - When startWash() and stopWash() are called on WashingMachine_Arban
 *    and Laundry_Arban references pointing to AutomaticWasher and
 *    DrumWasher objects at runtime.
 *
 *  Q6: Which shows polymorphism?
 *  - startWash() and stopWash() behave differently depending on which
 *    machine calls them — AutomaticWasher prints wash program info,
 *    DrumWasher prints wash mode and load capacity.
 *
 *  Q7: How does your design achieve low coupling?
 *  - Both implementations depend on the abstract class and interface,
 *    not on each other's internal details.
 *
 *  Q8: How does your design achieve high cohesion?
 *  - Each class handles only its own washing behavior and attributes,
 *    keeping responsibilities focused and separate.
 */

public class AbstractionPolyDemo_DeJuras {
    public static void main(String[] args) {

        // Default Constructor(s)
        AutomaticWasher_DeJuras autoWasher = new AutomaticWasher_DeJuras();
        DrumWasher_DeJuras drumWasher = new DrumWasher_DeJuras();

        // Display AutomaticWasher Info
        System.out.println("==== " + autoWasher.getBrand().toUpperCase() + " AUTOMATIC WASHER ====");
        autoWasher.showBrand();
        System.out.println("Wash Program: " + autoWasher.getWashProgram());
        System.out.println("Capacity: " + autoWasher.getCapacity() + " kg");
        System.out.println("Status: " + autoWasher.getStatus());

        System.out.println();

        // Display DrumWasher Info
        System.out.println("==== " + drumWasher.getBrand().toUpperCase() + " DRUM WASHER ====");
        drumWasher.display();

        System.out.println();

        // Runtime Polymorphism via Abstract Class — dynamic binding
        WashingMachine_Arban washerOne = autoWasher;
        WashingMachine_Arban washerTwo = drumWasher;

        // Runtime Polymorphism via Interface — dynamic binding
        Laundry_Arban laundryOne = autoWasher;
        Laundry_Arban laundryTwo = drumWasher;

        System.out.println("==== STARTING WASH (via Abstract Class) ====");
        washerOne.startWash(); // calls AutomaticWasher's startWash()
        washerTwo.startWash(); // calls DrumWasher's startWash()

        System.out.println();

        System.out.println("==== STARTING WASH (via Interface) ====");
        laundryOne.startWash(); // dynamic binding through Laundry_Arban
        laundryTwo.startWash(); // dynamic binding through Laundry_Arban

        System.out.println();

        // Interface default method
        System.out.println("==== SHOW BRAND (via Interface Default Method) ====");
        laundryOne.showBrand(autoWasher.getBrand());
        laundryTwo.showBrand(drumWasher.getBrand());

        System.out.println();

        // Overloaded methods
        System.out.println("==== OVERLOADED WASH METHODS ====");
        autoWasher.startWash(30);           // startWash with time
        autoWasher.stopWash(2, 60);         // stopWash with program and time
        drumWasher.startWash(45.5);         // startWash with double time
        drumWasher.stopWash(15.0, true);    // stopWash with time and autoStop

        System.out.println();

        // Stopping both machines via interface
        System.out.println("==== STOPPING WASH (via Interface) ====");
        laundryOne.stopWash(); // calls AutomaticWasher's stopWash()
        laundryTwo.stopWash(); // calls DrumWasher's stopWash()

        System.out.println();

        // Updated status after stopping
        System.out.println("==== UPDATED STATUS ====");
        System.out.println("==== " + autoWasher.getBrand().toUpperCase() + " AUTOMATIC WASHER ====");
        System.out.println("Status: " + autoWasher.getStatus());

        System.out.println();

        System.out.println("==== " + drumWasher.getBrand().toUpperCase() + " DRUM WASHER ====");
        System.out.println("Running: " + drumWasher.getIsRunning());

        System.out.println("==== FIN ====");
    }
}
