public class Coffee {

    // Attributes
    String name;
    double price;
    String category;
    String size;
    int stock;

    // Static attribute
    static int totalAmount = 0;

    // Fixed/Default Constructor 
    Coffee() {
    name = "Latte";
    price = 60.99;
    size = "Medium";
    category = "Coffee";
    stock = 25;
    totalAmount++;
     }

     // Parameterized constructor
     Coffee(String name, double price, String size, String category, int stock) {
     this.name = name;
     this.price = price;
     this.size = size;
     this.category = category;
     this.stock = stock;
      totalAmount++;

      }

      // Overloaded Constructor
      Coffee(String name, double price, String size) {
      this.name = name;
      this.price = price;
      this.category = "General";
      this.stock = 0;
      this.size = size;
      totalAmount++;

      }

      // Behavior Without Parameters
      void displayFixedDetails() {
      System.out.println("Product Name: " + name);
      System.out.println("Price: " + price);
      System.out.println("Coffee Size: " + size);
      System.out.println("Category: " + category);
      System.out.println("Available Stock: " + stock);

      }

      // Behavior with Parameters
      void addStock(int newAmount) {
      this.stock = this.stock + newAmount;
      System.out.println("Successfully added " + newAmount + " units to " + name);
      System.out.println("New inventory total: " + this.stock);

       }
       // Static Method
       static void displayTotalAmount() {
       System.out.println("The Total Amount Created: " + totalAmount);
    }
        
}
