public class Product {
    // Attributes
    String name;
    double price;
    String category;
    int stock;
    // The Static attribute
    static int totalProducts = 0;

    // This is the Default constructor
    Product() {
        name = "Samsung A16";
        price = 15000.0;
        category = "Phones";
        stock = 15;
        totalProducts++;
    }

    // Parameterized constructor
    Product(String name, double price, String category, int stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
        totalProducts++;
    }

    // Overloaded constructor
    Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.category = "General";
        this.stock = 0; // default stock
        totalProducts++;
    }

    // The Behavior without parameters
    void displayDetails() {
        System.out.println("Product: " + name);
        System.out.println("Price: P" + price);
        System.out.println("Category: " + category);
        System.out.println("Stock: " + stock);
    }

    // Behavior with parameters
    void applyDiscount(double percent) {
        double discounted = price - (price * percent / 100);
        price = discounted;
        System.out.println(name + " is now on sale at $" + price + " after " + percent + "% discount.");
    }

    // Static method
    static String getTotalProducts() {
        return "Total Products Created: " + totalProducts;
    }
}
