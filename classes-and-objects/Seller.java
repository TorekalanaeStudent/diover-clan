public class Seller {

    // Attributes
    String name;
    String shopName;
    double rating;

    // Static attribute
    static int totalSellers = 0;

    // Default Constructor
    Seller() {
        name = "Unknown";
        shopName = "No Shop";
        rating = 0.0;
        totalSellers++;
    }

    // Parameterized Constructor
    Seller(String name, String shopName) {
        this.name = name;
        this.shopName = shopName;
        rating = 0.0;
        totalSellers++;
    }

    // Overloaded Constructor
    Seller(String name, String shopName, double rating) {
        this.name = name;
        this.shopName = shopName;
        this.rating = rating;
        totalSellers++;
    }

    // Method without parameters
    void displaySeller() {
        System.out.println("Seller Name: " + name);
        System.out.println("Shop Name: " + shopName);
        System.out.println("Rating: " + rating);
    }

    // Method with parameter
    void setRating(double newRating) {
        rating = newRating;
    }

    // Static method
    static void printTotalSellers() {
        System.out.println("Total Sellers: " + totalSellers);
    }
}