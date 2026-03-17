public class Main_Trespeces {

    public static void main(String[] args) {

        System.out.println("\n Ziggy's Chair Object");

        // Default constructor
        Chairs chair1 = new Chairs();

        // Parameterized constructor
        Chairs chair2 = new Chairs("ODD ATELIER", "Black", 45000.00, 50);

        // Overloaded constructor
        Chairs chair3 = new Chairs("BLISSOO", 12500.00);

        // Using behaviors
        chair1.changeColor("Black");
        chair2.changeColor("Red");

        chair1.displayDetails();
        System.out.println();
        chair2.displayDetails();
        System.out.println();
        chair3.displayDetails();

        // Using setters
        chair3.setColor("White");
        chair3.setStock(200);
        chair3.setPrice(11000.00);

        // Using getters
        System.out.println("Model: " + chair1.getModel());
        System.out.println("Color: " + chair1.getColor());
        System.out.println("Price: P" + chair2.getPrice());
        System.out.println("Stock: " + chair2.getStock());

        System.out.println("Updated Chair 3 Info:");
        System.out.println("Model: " + chair3.getModel());
        System.out.println("Color: " + chair3.getColor());
        System.out.println("Price: P" + chair3.getPrice());
        System.out.println("Stock: " + chair3.getStock());

        // Validation
        double newPrice = -500.00;
        if (newPrice < 0) {
            System.out.println("Error: Price cannot be negative.");
        } else {
            chair2.setPrice(newPrice);
        }

        int newStock = -10;
        if (newStock < 0) {
            System.out.println("Error: Stock cannot be negative.");
        } else {
            chair3.setStock(newStock);
        }

        // Static attribute
        System.out.println("Total Chairs Created: " + Chairs.totalChairs);

        System.out.println("\n Clint's Car Object");

        // Default constructor
        Cars car1 = new Cars();

        // Parameterized constructor
        Cars car2 = new Cars("Mazda", "RX-7", "Red", 0);

        // Using behaviors
        car1.accelerate();
        car2.accelerate();

        // Using setter
        car2.setSpeed(120);

        // Using getters
        System.out.println("Brand: " + car1.getCar());
        System.out.println("Model: " + car1.getModel());
        System.out.println("Color: " + car1.getColor());
        System.out.println("Speed: " + car1.getSpeed());

        // Display
        car1.displayCarInfo();
        System.out.println();
        car2.displayCarInfo();

        // Validation
        int newSpeed = -50;
        if (newSpeed < 0) {
            System.out.println("Error: Speed cannot be negative.");
        } else {
            car2.setSpeed(newSpeed);
        }
    }
}