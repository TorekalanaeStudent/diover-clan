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
    }
}
