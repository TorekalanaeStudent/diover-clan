/*
 * this program shows object collaboration between Order class by Jagunap and SellerEncap class by Nono.
 * Created by Faye Cardeño
 */

public class Main_Cardeno {

    public static void main(String[] args) {

        // using SellerEncap class
        System.out.println("=== Using SellerEncap Class by Nono ===");

        // creating seller objects
        SellerEncap seller1 = new SellerEncap(); // default seller
        SellerEncap seller2 = new SellerEncap("Faye Cardeno", "FC Tech Shop", 4.3); // my seller

        // using getters and setters
        System.out.println("\nSeller 1 name (default): " + seller1.getName());
        System.out.println("Seller 2 rating (before change): " + seller2.getRating());
        seller2.setRating(4.8); // updating rating
        System.out.println("Seller 2 rating (after change): " + seller2.getRating());

        // behaviors
        System.out.println("\nSeller 1 adding products:");
        seller1.addProduct();
        seller1.addProduct();
        seller1.displaySeller();

        System.out.println("\nSeller 2 information:");
        seller2.displaySeller();

        // testing invalid inputs
        System.out.println("\nTesting invalid rating for seller1 (6):");
        seller1.setRating(6); 

        // using Order_Two class
        System.out.println("\n=== Using Order_Two Class by Jagunap ===");

        // creating order objects
        Order_Two order1 = new Order_Two(); // default order
        Order_Two order2 = new Order_Two("O101", "Gaming Mouse", 950.0, 10); // parameterized order

        // using getters and setters
        System.out.println("\nOrder 1 name (default): " + order1.getName());
        System.out.println("Order 2 price (before change): " + order2.getPrice());
        order2.setPrice(900); // changing price
        System.out.println("Order 2 price (after change): " + order2.getPrice());

        // behaviors
        System.out.println("\nSelling 3 units of order2:");
        order2.sell(3);

        System.out.println("\nRestocking order2 by 5 units:");
        order2.restock(5);

        // testing invalid inputs
        System.out.println("\nTesting invalid price (-200) for order2:");
        order2.setPrice(-200); // invalid price

        System.out.println("\nTrying to sell 50 units of order2 (more than stock):");
        order2.sell(50); // should show error

        // display total objects
        System.out.println("\n=== Total Objects Created ===");
        Order_Two.printTotalOrders();
        SellerEncap.printTotalSellers();
    }
}