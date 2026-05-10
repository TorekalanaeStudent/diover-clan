public class Ball {
// Attributes
String name;
double price;
String color;
int stock;


// Static Attribute
 static int totalBall = 0;

 // This is the Default constructor
Ball(){
    name = "Spalding";
    price = 295.00;
    color = "brown";
    stock = 11;
    totalBall++;
 }
     // Parameterized constructor
Ball(String name, double price, String color, int stock){
    this.name = name;
    this.price = price;
    this.color = color;
    this.stock = stock;
    totalBall++;
}
// Overloaded constructor
Ball(String name, double price){
    this.name = name;
    this.price = price;
    this.color = "NONE";
    this.stock = 0;
    totalBall++;
}
// The Behavior without parameters
    void displayDetails() {
        System.out.println("Product: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Color" + color );
        System.out.println("Stock: " + stock);
}
 //The Behavior with parameters
 void applyDiscount(double percent) {
        double discounted = price - (price * percent / 20);
        price = discounted;
        System.out.println(name + " is now on sale at $" + price + " after " + percent + "% discount.");

    }
 // Static method
    static void displayTotalBall() {
        System.out.println("Total Ball Created: " + totalBall);
    }
}