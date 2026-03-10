public class Selling { 
    /*
    * This class represents a product with a name, price, brand, and status.
    * Created by Rich Matthew Malig
    */

    String productName;
    double price;
    String brand;
    String status;

    public static String store = "Online Shop";

    public Selling() {
        this.productName = "Tennis";
        this.price = 100.0;
        this.brand = "Nike";
        this.status = "Available";
    }

    public Selling(String productName) {
        this.productName = productName;
        this.price = 100.0;
        this.brand = "Nike";
        this.status = "Available";
    }

    public Selling(String productName, double price) {
        this.productName = productName;
        this.price = price;
        this.brand = "Nike";
        this.status = "Available";
    }

    public Selling(String productName, double price, String brand, String status) {
        this.productName = productName;
        this.price = price;
        this.brand = brand;
        this.status = status;
    }

    public void displaySelling() {
        System.out.println("Product: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Brand: " + brand);
        System.out.println("Status: " + status);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductName() {
        return this.productName;
    }

    public static String getStore() {
        return store;
    }
}