public class Laptop {
// Attributes
String name;
double price;
String color;
int stock;
// Static Attribute
 static int totalLaptop = 0;
//Default constructor
Laptop(){
    name = "Lenovo";
    price = 1000.00;
    color = "Black";
    stock = 20;
    totalLaptop++;
 }
// parameterized constructor
Laptop(String name, double price, String color, int stock){
    this.name = name;
    this.price = price;
    this.color = color;
    this.stock = stock;
    totalLaptop++;
}
// Overloaded constructor
Laptop(String name, double price){
    this.name = name;
    this.price = price;
    this.color = "NONE";
    this.stock = 0;
    totalLaptop++;
}
// Behavior without parameters
    void displayDetails() {
        System.out.println("Product: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Color" + color );
        System.out.println("Stock: " + stock);
}
 // Behavior with parameters
 void applyDiscount(double percent) {
        double discounted = price - (price * percent / 20);
        price = discounted;
        System.out.println(name + " is now on sale at $" + price + " after " + percent + "% discount.");

    }
 // Static method
    static void displayTotalLaptop() {
        System.out.println("Total Laptop Created: " + totalLaptop);
    }
}
