
public class Order {
    // Attributes
    private String orderId;        // Unique ID for the order
    private String customerName;   // Name of the customer
    private String productName;    // Product ordered
    private int quantity;          // Number of items ordered
    private double price;          // Price per item

    // Constructor
    public Order(String orderId, String customerName, String productName, int quantity, double price, String orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method to compute total amount
    public double getTotalAmount() {
        return quantity * price;
    }
}