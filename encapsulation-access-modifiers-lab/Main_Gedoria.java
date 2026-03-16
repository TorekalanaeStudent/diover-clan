public class Main_Gedoria {
    public static void main(String[] args) {

        System.out.println("Creation of RAM Stick Objects:");

        // default constructor
        RamStick ram1 = new RamStick();

        // parameterized constructor
        RamStick ram2 = new RamStick("Vengeance LPX", 3200, 16, "DDR4", "Corsair");

        // overloaded constructor
        RamStick ram3 = new RamStick("Trident Z", "G.Skill");

        // getters and setters
        System.out.println("\nUsing getters and setters:");
        ram1.setModel("Kingston Fury");
        System.out.println("RAM 1 Model: " + ram1.getModel());

        ram2.setManufacturer("Corsair Inc.");
        System.out.println("RAM 2 Manufacturer: " + ram2.getManufacturer());

        System.out.println("RAM 3 Model: " + ram3.getModel());

        // using display method
        System.out.println("\nDisplaying RAM Information:");
        System.out.println("RAM 1 Info:");
        ram1.displayInfo();

        System.out.println("RAM 2 Info:");
        ram2.displayInfo();

        System.out.println("RAM 3 Info:");
        ram3.displayInfo();

        // using method with parameters
        System.out.println("Updating RAM 3 Information:");
        ram3.setInfo("Trident Z RGB", 3600, 32, "DDR4", "G.Skill");
        ram3.displayInfo();

        // validation testing
        System.out.println("Validation Testing:");
        ram1.setSpeed(-100);   // invalid
        ram2.setCapacity(-16); // invalid

        // availability behavior
        System.out.println("\nChanging Availability:");
        ram2.setAvailable(false);
        System.out.println("RAM 2 Available: " + ram2.isAvailable());

        // static method
        System.out.println("\nTotal RAM Stock:");
        RamStick.displayTotalStock();

        System.out.println("\nAClass created by Ablis.");
    }
}
