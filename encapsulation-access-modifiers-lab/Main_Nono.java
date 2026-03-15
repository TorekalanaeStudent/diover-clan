public class Main_Nono {
    public static void main(String[] args) {

        // Object creations
        System.out.println("Creation of Jagunap's Order Objects:");

        // default constructor
        Order_Two order1 = new Order_Two();

        // parameterized constructor
        Order_Two order2 = new Order_Two("P1001", "Wireless Mouse", 350.00, 10);

        // using getters and setters
        System.out.println("\nUsing getters and setters:");

        System.out.println("Order 1 name: " + order1.getName());

        order2.setPrice(299.99);
        System.out.println("Order 2 updated price: " + order2.getPrice());

        System.out.println("Order 2 stock: " + order2.getStock());

        // behaviors (1)
        System.out.println("\nSelling items from Order 2:");
        order2.sell(3);

        // behaviors (2) with validation
        System.out.println("\nTrying to sell more than available stock:");
        order2.sell(100);

        // validation testing
        System.out.println("\nValidation Testing:");

        order2.setPrice(-150);   // invalid price
        order2.setStock(-5);     // invalid stock


        // restocking behavior
        System.out.println("\nRestocking items:");
        order2.restock(20);

        System.out.println("Current stock: " + order2.getStock());


        // display object information
        System.out.println("\nOrder Information:");
        System.out.println(order1);
        System.out.println(order2);


        // static behavior
        System.out.println("\nStatic Method:");
        Order_Two.printTotalOrders();

        System.out.println("\nAll in all Jagunap's Order class works well!");

	 // Study Session

        System.out.println("\nCreation of Cardeño Study Session Objects:");

        // default constructor
        StudySessionEncap session1 = new StudySessionEncap();

        // parameterized constructor
        StudySessionEncap session2 = new StudySessionEncap("Programming", 3, "Mary");

        // using getters and setters
        System.out.println("\nUsing getters and setters:");

        System.out.println("Session 1 subject: " + session1.getSubject());

        session2.setSubject("Java Programming");
        System.out.println("Session 2 updated subject: " + session2.getSubject());

        System.out.println("Session 2 student: " + session2.getStudentName());

        // behaviors
        System.out.println("\nSession 1 Details:");
        session1.displaySession();

        System.out.println("\nEnding Session 2...");
        session2.endSession();

        System.out.println("Session 2 Details:");
        session2.displaySession();

        // validation testing
        System.out.println("\nValidation Testing:");

        session2.setHours(-3);          // invalid hours
        session2.setStudentName("");    // invalid name
        session2.setSubject("");        // invalid subject

        // static attribute
        System.out.println("\nSchool: " + StudySessionEncap.getSchool());

        System.out.println("\nAll in all the Study Session system works well!");
    }
}