package demo_class;

/**
 * =============================================================================
 * @author Ovejera, Ziggy
 *
 * =====Code-Based Analysis=====
 * 1. Abstract Class:
 * - Gadget_Ovejera is the base class.
 *
 * 2. Interface:
 * - SmartphoneSystem defines system behaviors.
 *
 * 3. Overridden Methods:
 * - powerOn(), syncData()
 *
 * 4. Overloaded Methods:
 * - powerOn(String), powerOn(int)
 *
 * 5. Dynamic Binding:
 * - Occurs in Gadget_Ovejera[] and SmartphoneSystem[] loops.
 *
 * 6. Polymorphism:
 * - Different objects stored in same reference type.
 *
 * 7. Low Coupling:
 * - Uses abstract class and interface references.
 *
 * 8. High Cohesion:
 * - Each class has one responsibility.
 * =============================================================================
 */

public class AbstractionPolyDemo_Ovejera {

    // ================= ABSTRACT CLASS =================
    static abstract class Gadget_Ovejera {
        private String name;
        private int battery;

        public Gadget_Ovejera(String name, int battery) {
            this.name = name;
            this.battery = battery;
        }

        public String getName() {
            return name;
        }

        public int getBattery() {
            return battery;
        }

        public abstract void powerOn();
    }

    // ================= INTERFACE =================
    interface SmartphoneSystem {
        void syncData(String device);

        default void autoBackup() {
            System.out.println("Data automatically backed up.");
        }
    }

    // ================= IMPLEMENTATION 1 =================
    static class Smartphone_Ovejera extends Gadget_Ovejera implements SmartphoneSystem {

        public Smartphone_Ovejera(String name, int battery) {
            super(name, battery);
        }

        @Override
        public void powerOn() {
            System.out.println(getName() + " is powering ON.");
        }

        @Override
        public void syncData(String device) {
            System.out.println(getName() + " syncing with " + device);
        }

        // OVERLOADED
        public void powerOn(String mode) {
            System.out.println(getName() + " powering ON in " + mode);
        }
    }

    // ================= IMPLEMENTATION 2 =================
    static class DeviceSystem_Ovejera extends Gadget_Ovejera implements SmartphoneSystem {

        public DeviceSystem_Ovejera(String name, int battery) {
            super(name, battery);
        }

        @Override
        public void powerOn() {
            System.out.println(getName() + " system booting...");
        }

        @Override
        public void syncData(String device) {
            System.out.println(getName() + " syncing system with " + device);
        }

        // OVERLOADED
        public void powerOn(int level) {
            System.out.println(getName() + " boot level: " + level);
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        Smartphone_Ovejera phone = new Smartphone_Ovejera("iPhone", 80);
        DeviceSystem_Ovejera system = new DeviceSystem_Ovejera("Android System", 90);

        // METHOD OVERLOADING
        System.out.println("METHOD OVERLOADING:");
        phone.powerOn("Gaming Mode");
        system.powerOn(5);
        System.out.println();

        // METHOD OVERRIDING
        System.out.println("METHOD OVERRIDING:");
        phone.powerOn();
        system.powerOn();
        System.out.println();

        // INTERFACE METHODS
        System.out.println("INTERFACE METHODS:");
        phone.syncData("Laptop");
        system.syncData("Cloud");
        System.out.println();

        // DEFAULT METHOD
        System.out.println("DEFAULT INTERFACE METHOD:");
        phone.autoBackup();
        System.out.println();

        // DYNAMIC BINDING (ABSTRACT CLASS)
        System.out.println("DYNAMIC BINDING (Gadget_Ovejera):");

        Gadget_Ovejera[] gadgets = {
            new Smartphone_Ovejera("Samsung", 70),
            new DeviceSystem_Ovejera("System A", 60)
        };

        for (Gadget_Ovejera g : gadgets) {
            g.powerOn();
        }

        System.out.println();

        // DYNAMIC BINDING (INTERFACE)
        System.out.println("DYNAMIC BINDING (SmartphoneSystem):");

        SmartphoneSystem[] systems = {
            new Smartphone_Ovejera("Pixel", 85),
            new DeviceSystem_Ovejera("Main System", 95)
        };

        for (SmartphoneSystem s : systems) {
            s.syncData("Server");
        }
    }
}