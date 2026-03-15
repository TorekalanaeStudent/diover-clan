// Product.java (created by Janelle Jagunap)

public class Product {

    // === Static attribute ===
    private static int totalProducts = 0; // Counts how many Product objects were created

    // === Private attributes (Strong Encapsulation) ===
    private String productId;
    private String name;
    private double price;
    private int stock;
    private String status; // e.g., "Available", "Out of Stock"

    // === Constructors ===

    // 1) Default constructor
    public Product() {
        this.productId = "N/A";
        this.name = "Unnamed Product";
        this.price = 0.0;
        this.stock = 0;
        this.status = "Unavailable";
        totalProducts++; // Count the object
    }

    // 2) Parameterized constructor
    public Product(String productId, String name, double price, int stock) {

        // Validation rules
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }

        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative.");
        }

        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.status = (stock > 0) ? "Available" : "Out of Stock";

        totalProducts++; // Count the object
    }

    // === Getters ===
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public String getStatus() { return status; }

    // === Setters with Validation ===
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Error: Price cannot be negative.");
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {    // Object invariant: stock must NEVER be negative
            this.stock = stock;
            updateStatus();
        } else {
            System.out.println("Error: Stock cannot be negative.");
        }
    }

    // No setter for name or ID to preserve product identity

    // === Behaviors (Methods) ===

    // 1) Method to reduce stock
    public void sell(int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }

        if (quantity > stock) {
            System.out.println("Not enough stock available.");
            return; // Prevent invalid state
        }

        stock -= quantity;
        updateStatus();
        System.out.println("Sold " + quantity + " unit(s). Remaining stock: " + stock);
    }

    // 2) Method to restock
    public void restock(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid restock amount.");
            return;
        }

        stock += amount;
        updateStatus();
        System.out.println("Restocked " + amount + ". Current stock: " + stock);
    }

    // Helper method to update product status
    private void updateStatus() {
        status = (stock > 0) ? "Available" : "Out of Stock";
    }

    // === Static Method ===
    public static void printTotalProducts() {
        System.out.println("Total Product objects created: " + totalProducts);
    }

    // === toString Override ===
    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", status='" + status + '\'' +
                '}';
    }
}