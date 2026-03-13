/*
		* This class represents a product with a model, color, price, and stock.
		* Created by Ziggy Ovejera
		*/
        
public class Chairs {

    // Attributes
    private String model;
    private String color;
    private double price;
    private int stock;

    // Static Attribute
    static int totalChairs = 0;

    // Default Constructor
    Chairs() {
        model = "IKEA";
        color = "Red";
        price = 1800.00;
        stock = 900;
        totalChairs++;
    }

    // Parameterized Constructor
    Chairs(String model, String color, double price, int stock) {
        this.model = model;
        this.color = color;
        this.price = price;
        this.stock = stock;
        totalChairs++;
    }

    // Overloaded Constructor
    Chairs(String model, double price) {
        this.model = model;
        this.price = price;
        this.stock = 900;
        totalChairs++;
    }

    // GETTERS
    public String getModel() {
        return model;
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

    // SETTERS
    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Behavior without parameters
    void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Price: P" + price);
        System.out.println("Stock: " + stock);
    }

    // Behavior with parameter
    void changeColor(String newColor) {
        color = newColor;
        System.out.println(model + " Color changed to " + color);
    }

    // Static Method
    static void displayTotalChairs() {
        System.out.println("Total Chairs Created: " + totalChairs);
    }
}
