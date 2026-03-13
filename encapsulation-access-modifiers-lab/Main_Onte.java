public class Main_Onte {
    public static void main(String[] args) {

        System.out.println("\n Malig's Book Object");

        // Default Constructor
        Books book1 = new Books();

        // Parameterized Constructor
        Books book2 = new Books("Pride and Prejudice", "Jane Austen", 500); // 

        // Validating Getters and Setters
        System.out.println("\n This will check the getters of setters of the input.");
        book1.setTitle("Onte's Personal Diary"); 
        System.out.println("Book 1 title: " + book1.getTitle()); 
        System.out.println("Book 2 title: " + book2.getTitle());

        book1.setAuthor("Vince Onte"); 
        System.out.println("Book 1 author: " + book1.getAuthor()); 

        book1.setPages(250);
        System.out.println("Book 1 pages: " + book1.getPages());

        // Behaviours checking
        System.out.println("\n Checking the behaviour methods: \n");
        book1.borrowBook(); // "Book borrowed successfully"
        book1.borrowBook(); // "Book is already borrowed."
        book1.returnBook(); // "Book returned successfully."
        book2.borrowBook(); // "Book borrowed successfully."

        // Validation testing
        System.out.println("\n Validation Testing: \n");
        book1.setTitle("");  // "Invalid title."
        book1.setAuthor(null); // "Invalid author."
        book1.setPages(-100); // "Pages must be greater than 0."

        // Static test
        System.out.println("Total Books Created: " + Books.getTotalBooks()); // should be 2

        System.out.println("\n Overall result: This was good and Malig was able to implement setters, behaviours, and static");
    
        System.out.println("\nGo's Gun Rack Objects");

        // Default constructor
        GunRack gun1 = new GunRack(); 
        // Prints nothing yet; creates gun1 with default values ("Unknown", 0, etc.)

        // Parameterized constructor
        GunRack gun2 = new GunRack("AK-47", 1947, 600, "7.62mm", 85, "Izhmash");
        // Prints nothing yet; gun2 has specific values

        // Overloaded constructor
        GunRack gun3 = new GunRack("Desert Eagle", "Magnum Research");
        // Prints nothing yet; gun3 has model and manufacturer, rest default

        // Getters and Setters testing
        System.out.println("\nChecking getters and setters:");

        gun1.setModel("M16");
        System.out.println("Gun 1 model: " + gun1.getModel()); 
        // Prints: Gun 1 model: M16

        gun1.setManufacturer("Colt");
        System.out.println("Gun 1 manufacturer: " + gun1.getManufacturer());
        // Prints: Gun 1 manufacturer: Colt

        gun1.setYear(1964);
        System.out.println("Gun 1 year: " + gun1.getYear());
        // Prints: Gun 1 year: 1964

        gun1.setRoundsPerMinute(700);
        System.out.println("Gun 1 RPM: " + gun1.getRoundsPerMinute());
        // Prints: Gun 1 RPM: 700

        gun1.setCaliber("5.56mm");
        System.out.println("Gun 1 caliber: " + gun1.getCaliber());
        // Prints: Gun 1 caliber: 5.56mm

        gun1.setPenetration(70);
        System.out.println("Gun 1 penetration: " + gun1.getPenetration());
        // Prints: Gun 1 penetration: 70

        gun1.setAvailable(true);
        System.out.println("Gun 1 available: " + gun1.isAvailable());
        // Prints: Gun 1 available: true

        // Displaying info
        System.out.println("\nDisplaying Gun Information:");
        gun1.displayInfo(); 
        // Prints all attributes of gun1
        gun2.displayInfo(); 
        // Prints all attributes of gun2
        gun3.displayInfo(); 
        // Prints all attributes of gun3

        // Validation Testing
        System.out.println("\nValidation Testing:");
        gun1.setYear(-10);           
        // Prints: Invalid year. Year must be greater than 0
        gun1.setRoundsPerMinute(-500); 
        // Prints: Invalid RPM. Value must be greater than 0.
        gun1.setPenetration(-20);      
        // Prints: Invalid Penetration value. Value must be greater than 0.

        // Using setInfo method
        System.out.println("\nUsing setInfo to update Gun 3:");
        gun3.setInfo("Glock 19", 1988, 1200, "9mm", 50, "Glock GmbH");
        gun3.displayInfo(); 
        // Prints updated info for gun3: Glock 19, 1988, 1200 RPM, 9mm, 50 penetration, Glock GmbH

        System.out.println("\nStatic test:");
        GunRack.displayTotalStock(); // Already prints: Gun Choices: 3     

        System.out.println("\nOverall Result: GunRack class tested with setters, getters, validation, and static stock.");
        // Prints: Overall Result: GunRack class tested with setters, getters, validation, and static stock.
    }
}