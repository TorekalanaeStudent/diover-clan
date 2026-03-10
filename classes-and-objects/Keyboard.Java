/*
* This class represents a product with a name, price, color, type, and stock.
* Created by Vince Gian Onte
*/
public class Keyboard {
    // Attributes
    String brand;
    double price;
    String color;
    String type;
    int stock;
    // Static Attribute
    static int totalKeyboard = 0;
    // Default constructor
    Keyboard() {
        brand = "Wooting";
        price = 12500;
        color = "black";
        type = "Mechanical";
        stock = 15;
        totalKeyboard++;
    }
    // Parameterized Constructor
    Keyboard(String brand, double price, String color, String type, int stock) {
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.type = type;
        this.stock = stock;
        totalKeyboard++;
    }
    // Overloaded Constructor
    Keyboard(String brand, double price) {
        this.brand = brand;
        this.price = price;
        this.color = "NONE";
        this.type = "NONE";
        this.stock = 0;
        totalKeyboard++;
    }
    // Behavior without parameters
    void displayKeyboard() {
        System.out.println("Keyboard Brand: " + brand);
        System.out.println("Price: ₱" + price);
        System.out.println("Color: " + color);
        System.out.println("Type: " + type);
        System.out.println("Stock: " + stock);
    }
    // Behavior with parameters
    void applyDiscount(double percent) {
        double discountedPrice = price - (price * percent / 100);
        price = discountedPrice;
        System.out.println(brand + " Keyboard now costs: ₱" + price + " after a " + percent + "% discount.");
    }
    // Static Method
    static void displayTotalKeyboard() {
        System.out.println("Total Keyboards Created: " + totalKeyboard);
    }
}
