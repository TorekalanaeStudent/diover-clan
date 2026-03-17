public class Main_Ovejera {

    public static void main(String[] args){

        // RAM Objects
        RamStick r1 = new RamStick();
        RamStick r2 = new RamStick();

        //Assisted by AI

        r1.setModel("Corsair Vengeance");
        r1.setSpeed(3200);
        r1.setCapacity(16);
        r1.setType("DDR4");
        r1.setManufacturer("Corsair");
        r1.setAvailable(true);

        r2.setModel("Kingston Fury");
        r2.setSpeed(3600);
        r2.setCapacity(32);
        r2.setType("DDR5");
        r2.setManufacturer("Kingston");
        r2.setAvailable(false);

        System.out.println("=== recreation of margreleien ramstik ===");
        r1.displayInfo();
        System.out.println("-----------------");
        r2.displayInfo();

        System.out.println("\n============================\n");

        // Car using default constructor
        Cars carA = new Cars();
        System.out.println("Car A Details:");
        carA.displayCarInfo();
        System.out.println();

        // Car using parameterized constructor
        Cars carB = new Cars("Toyota", "Vios", "Red", 70);
        System.out.println("Car B Details:");
        carB.displayCarInfo();
        System.out.println();

        // Accessing Car Information (Getters)
        System.out.println("Brand : " + carB.getBrand());
        System.out.println("Model : " + carB.getModel());
        System.out.println("Color : " + carB.getColor());
        System.out.println("Current Speed : " + carB.getSpeed());
        System.out.println();

        // Updating Speed Using Setter
        carA.setSpeed(30);
        System.out.println("Updated Car A:");
        carA.displayCarInfo();
        System.out.println();

        // Car behavior
        System.out.println("Car B accelerating...");
        carB.accelerate();
        carB.accelerate();
        carB.displayCarInfo();
        System.out.println();

        // Validation test
        System.out.println("=== Invalid Speed Test ===");
        carB.setSpeed(-20); // should not change
        System.out.println("Car B Speed After Invalid Input: " + carB.getSpeed());
        System.out.println();

        // Additional cars
        System.out.println("=== Additional Cars ===");

        Cars carC = new Cars("Nissan", "Sentra", "Yellow", 60);
        Cars carD = new Cars("Hyundai", "Accent", "Black", 85);

        System.out.println("\nCar C:");
        carC.displayCarInfo();

        System.out.println("\nCar D:");
        carD.displayCarInfo();
    }
}