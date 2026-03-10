public class Phone {

    // Attributes
    String model;
    String color;

    // Static attribute
    static int amount = 0;

    // Default Constructor
    public Phone() {
        model = "Galaxy S26";
        color = "White";
        amount++;
    }

    // Parameterized Constructor
    public Phone(String model, String color) {
        this.model = model;
        this.color = color;
        amount++
    }

    // Overloaded Constructor
    public Phone(String model) {
        this.model = model;
        this.color = color;
        amount++
    }

    // Behavior without parameter
    public void displayPhone() {
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
    }

    // Behavior with parameter
    public void changeColor(String newColor) {
        color = newColor;
        System.out.println("New color is: " + color);
    }

    // Static Method
    static void showBrand() {
        System.out.println("Amount of phones available: " + amount);
    }
}