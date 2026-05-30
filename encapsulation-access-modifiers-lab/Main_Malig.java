public class Main_Malig {

    public static void main(String[] args) {
        //ElectricKettle
        // Creating an object using the default constructor
        ElectricKettle kettle1 = new ElectricKettle();

        // Creating an object using the parameterized constructor
        ElectricKettle kettle2 = new ElectricKettle("Philips", 1500);

        // Using methods (behaviors)
        kettle1.unlockLid();
        kettle1.pourLiquid(500);
        kettle1.setTemperatureCel(80);

        kettle1.drinkLiquid(200);

        // Display information using getters
        System.out.println("Brand: " + kettle1.getBrand());
        System.out.println("Capacity: " + kettle1.getCapacityMl());
        System.out.println("Current Volume: " + kettle1.getCurrentVolumeMl());
        System.out.println("Temperature: " + kettle1.getTemperatureCel());

        // Static attribute example
        System.out.println("Total Kettles Created: " + ElectricKettle.getTotalKettleCreated());

        //LibraryComputer
         

        // Create object using default constructor
        LibraryComputer comp1 = new LibraryComputer();

        // Create object using overloaded constructor
        LibraryComputer comp2 = new LibraryComputer("white", 5, 1);

        // Create object using parameterized constructor
        LibraryComputer comp3 = new LibraryComputer(true, "gray", false, 7, 3);

        // Display computer details
        System.out.println("Computer 1 Details:");
        comp1.compDetails();

        System.out.println("\nComputer 2 Details:");
        comp2.compDetails();

        System.out.println("\nComputer 3 Details:");
        comp3.compDetails();

        // Using setters
        comp1.setUsed(true);
        comp1.setPrice(15);
        comp1.setLibStatus(1);

        // Using getters
        System.out.println("\nUpdated Computer 1 Info:");
        System.out.println("Used: " + comp1.getUsed());
        System.out.println("Price per hour: " + comp1.getPrice());
        System.out.println("Library Status: " + comp1.getLibStatus());

        // Show total computers in the library
        System.out.println("Total Library Computers: " + comp1.getQuantity());
    
    }
}

