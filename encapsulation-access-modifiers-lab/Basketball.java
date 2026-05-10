public class Basketball {

    // Attributes
    private String brand;
    private String color;
    private double price;
    private int stock;
    private boolean isAvailable;

    private static int totalBasketball = 0;

    // Default Constructor
    public Basketball() {

        brand = "Unknown";
        color = "Unknown";
        price = 0.0;
        stock = 1;
        isAvailable = true;
        totalBasketball++;

    }

    // Parameterized Constructor
    public Basketball(String brand, String color, double price, int stock) {

        this.brand = brand;
        this.color = color;
        this.price = price;
        this.stock = stock;
        this.isAvailable = true;
        totalBasketball++;

    }

    // Overloaded Constructor
    public Basketball(String brand, String color) {

        this.brand = brand;
        this.color = color;
        price = 0.0;
        stock = 1;
        isAvailable = true;
        totalBasketball++;

    }

    // Display Method
    public void displayInfo() {

        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
        System.out.println("Price: " + price);
        System.out.println("Stock: " + stock);
        System.out.println("Available: " + isAvailable);
        System.out.println();

    }

    // Method with parameters
    public void setInfo(String brand, String color, double price, int stock) {

        this.brand = brand;
        this.color = color;
        this.price = price;
        this.stock = stock;

    }
  // Behavior: Purchase basketball (reduces stock)
    public void purchaseBall(int quantity) {

        if (quantity > 0 && quantity <= stock) {
            stock -= quantity;
            System.out.println(quantity + " basketball(s) purchased.");
            System.out.println("Remaining stock: " + stock);
        } else {
            System.out.println("Not enough stock available.");
        }

    }

    // Behavior: Restock basketball (adds stock)
    public void restockBall(int quantity) {

        if (quantity > 0) {
            stock += quantity;
            System.out.println("Restocked " + quantity + " basketball(s).");
            System.out.println("New stock: " + stock);
        } else {
            System.out.println("Invalid restock amount.");
        }

    }
    // Static Method
    public static void displayTotalBasketball() {

        System.out.println("Total Basketball Products: " + totalBasketball);

    }

    // Getters

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {

        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price. Must be greater than 0.");
        }

    }

    public void setStock(int stock) {

        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("Invalid stock value.");
        }

    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

}
