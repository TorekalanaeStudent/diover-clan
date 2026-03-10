public class Selling {

    String productName;
    int quantity;
    String sellerName;

    public static String store = "Online Shop";

    public Selling() {
        this.productName = "Tennis";
        this.quantity = 1;
        this.sellerName = "Anonymous";
    }

    public Selling(String productName) {
        this.productName = productName;
        this.quantity = 1;
        this.sellerName = "Anonymous";
    }

    public Selling(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
        this.sellerName = "Anonymous";
    }

    public Selling(String productName, int quantity, String sellerName) {
        this.productName = productName;
        this.quantity = quantity;
        this.sellerName = sellerName;
    }

    public void displaySelling() {
        System.out.println("Seller: " + sellerName);
        System.out.println("Product: " + productName);
        System.out.println("Quantity: " + quantity);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return this.productName;
    }

    public static String getStore() {
        return store;
    }
}