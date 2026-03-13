/*
* This class represents a seller in a marketplace or online selling system.
* It contains attributes such as the seller's name, shop name, rating, and product count.
* Created by Mary Angeline Nono
*/

public class Seller {
    // Private attributes
    private String name;
    private String shopName;
    private double rating;
    private int productCount;

    // Static attribute
    private static int totalSellers = 0;

    // Default constructor
    public Seller() {
        this("Unknown", "No Shop", 0.0); // call main constructor
    }

    // Constructor with parameters
    public Seller(String name, String shopName) {
        this(name, shopName, 0.0); // call main constructor
    }

    // Main constructor with all parameters
    public Seller(String name, String shopName, double rating) {
        this.name = name;
        this.shopName = shopName;

        // Use same validation as setter
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        } else {
            this.rating = 0.0;
        }

        this.productCount = 0;
        totalSellers++;
    }

    // Getters
    public String getName() { return name; }
    public String getShopName() { return shopName; }
    public double getRating() { return rating; }
    public int getProductCount() { return productCount; }
    public static int getTotalSellers() { return totalSellers; }

    // Setter with validation
    public void setRating(double newRating) {
        if (newRating >= 0 && newRating <= 5) {
            rating = newRating;
        } else {
            System.out.println("Invalid rating. Rating must be between 0 and 5.");
        }
    }

    // Behavior methods
    public void addProduct() { productCount++; }

    public void displaySeller() {
        System.out.println("Seller Name: " + name);
        System.out.println("Shop Name: " + shopName);
        System.out.println("Rating: " + rating);
        System.out.println("Products: " + productCount);
    }

    // Static behavior
    public static void printTotalSellers() {
        System.out.println("Total Sellers: " + totalSellers);
    }
}