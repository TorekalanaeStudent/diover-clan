public class Coffee {

    // Attributes
    String name;
    double price;
    String category;
    String size;
    int stock;

    // Static attribute
    static int totalAmount = 0;

    // This is Fixed/Default Constructor
    Product(){
        name = "Latte";
        price = 60.99;
        size = "Medium";
        category = "Coffee";
        stock = 25;
        totalAmount++;
    }

    // This Parameterized constructor
    Product(String name, double price, String size, String category, int stock){
        this.name = name;
        this.price = price;
        this.size = size;
        this.category = category;
        this.stock = stock;
        totalAmount++;
    }

    // This Overload Constructor
    Product(String name, double price, String size){
        this.name = name;
        this.price = price;
        this.category = "General";
        this.stock = 0; 
        this.size = size;
        totalAmount++;
    }
    
    // This Behavior Without Parameters
    void displayFixedDetails(){
        System.out.println("Product Name: "+name);
        Sytem.out.println("Price: "+price);
        System.out.println("Coffee Size: "+size);
        System.out.println("Category: "+category);
        System.out.println("Available Stock: "+stock);

    }

    // This Behavior with Parameters
    void addStock(int newAmount) {
    this.stock = this.stock + newAmount;
    System.out.println("Successfully added " + newAmount + " units to " + name);
    System.out.println("New inventory total: " + this.stock);
    
    }

    // This Static Method
    static void displayTotalAmount(){
        System.out.println("The Total Amount Created: "+totalAmount);
    }
}