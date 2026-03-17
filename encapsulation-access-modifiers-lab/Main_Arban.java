public class Main_Arban {
    public static void main (String [] args){

        System.out.println("+++ De Juras Class +++");
        
       // Car using default constructor
        Cars carA = new Cars();
        System.out.println("Car A Details:");
        carA.displayCarInfo();
        System.out.println();

        // Car using parameterized constructor
        Cars carB = new Cars("Nissan", "GTR R34", "Blue", 70);
        System.out.println("Car B Details:");
        carB.displayCarInfo();
        System.out.println();

        //Accessing Car Information (Getters) 
        System.out.println("Brand : " + carB.getCar());
        System.out.println("Model : " + carB.getModel());
        System.out.println("Color : " + carB.getColor());
        System.out.println("Current Speed : " + carB.getSpeed());
        System.out.println();


        //Updating Speed Using Setter
        carA.setSpeed(30);
        System.out.println("Updated Car A:");
        carA.displayCarInfo();
        System.out.println();

      
      
        // car behavior
        System.out.println("Car B accelerating...");
        carB.accelerate();
        carB.accelerate();
        System.out.println();


        System.out.println("=== Invalid Speed Test ===\n");

        carB.setSpeed(-20); // should not change
        System.out.println("Car B Speed After Invalid Input: " + carB.getSpeed());
        System.out.println();


        System.out.println("=== Additional Cars ===\n");

        Cars carC = new Cars("Honda", "Civic Type R", "Red", 60);
        Cars carD = new Cars("Mazda", "RX-7", "Yellow", 85);

        System.out.println("Car C:");
        carC.displayCarInfo();
        System.out.println();

        System.out.println("Car D:");
        carD.displayCarInfo();

         System.out.println("\n=== Using Chairs Class made by Ovejera ===");

        // creating chair objects
        Chairs chair1 = new Chairs(); // default constructor
        Chairs chair2 = new Chairs("OfficePro", "Black", 2500.0, 20); // parameterized constructor
        Chairs chair3 = new Chairs("GamingChair", 3500.0); // overloaded constructor

        // using getters
        System.out.println("\nChair1 Model (default): " + chair1.getModel());
        System.out.println("Chair2 Price (before change): " + chair2.getPrice());

        // using setters
        chair2.setPrice(2300);
        System.out.println("Chair2 Price (after change): " + chair2.getPrice());

        // behaviors
        System.out.println("\nDisplaying Chair2 Details:");
        chair2.displayDetails();

        System.out.println("\nChanging Chair3 Color:");
        chair3.changeColor("Blue");

        // testing setters
        System.out.println("\nChanging Chair1 Stock:");
        chair1.setStock(850);
        System.out.println("Chair1 New Stock: " + chair1.getStock());

        // display the total objects
        System.out.println("\n=== Total Objects Created ===");
        Chairs.displayTotalChairs();
    }
}
