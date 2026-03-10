// Order.java (this class is created by Janelle Jagunap)
public class Order {
    // Static field to count how many Order objects were created
    static int totalOrders = 0;

    // Attributes (instance fields)
    String orderId;
    String customerName;
    String productName;
    int quantity;
    double price;
    String orderDate;

    // === Constructors ===

    // 1) Default constructor
    public Order() {
        this.orderId = "N/A";
        this.customerName = "Unknown";
        this.productName = "Unknown";
        this.quantity = 0;
        this.price = 0.0;
        this.orderDate = "0000-00-00";
        totalOrders++; // increment static counter
    }

    // 2) Parameterized constructor (common fields)
    public Order(String orderId, String customerName, String productName, int quantity, double price, String orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.orderDate = orderDate;
        totalOrders++; // increment static counter
    }

    // === Getters and Setters ===
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

    // === Behaviors (Methods) ===

    // Method without parameters: print a simple summary
    public void printSummary() {
        System.out.println("Order Summary -> ID: " + orderId +
                ", Customer: " + customerName +
                ", Product: " + productName +
                ", Qty: " + quantity +
                ", Price: " + price +
                ", Date: " + orderDate +
                ", Total: " + getTotalAmount());
    }

    // Method with parameters: apply a discount percentage to price
    public void applyDiscount(double percent) {
        // percent e.g., 10 means 10% off
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid discount percent: " + percent);
            return;
        }
        double discountAmount = price * (percent / 100.0);
        price = price - discountAmount;
        System.out.println("Applied " + percent + "% discount. New price per item: " + price);
    }

    // Compute total amount
    public double getTotalAmount() {
        return quantity * price;
    }

    // Static method to print total objects created
    public static void printTotalOrders() {
        System.out.println("Total Order objects created: " + totalOrders);
    }

    // Helpful toString() override for quick printing
    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}
