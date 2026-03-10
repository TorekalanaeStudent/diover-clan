public class Mouse {

    // Attributes
    String model;
    double price;
    String color;
    String type;

    // Static Attribute
    static int mouseTotal = 0;

    // Default constructor
    Mouse() {
        model = "Logitech G403 HERO";
        price = 15.99;
        color = "Black";
        type = "Wired";
        mouseTotal++;
    }

    // Parameterized constructor
    Mouse(String model, double price, String color, String type) {
        this.model = model;
        this.price = price;
        this.color = color;
        this.type = type;
        mouseTotal++;
    }

    // Overloaded constructor
    Mouse(String model, double price) {
        this.model = model;
        this.price = price;
        this.color = "0";
        this.type = "0";
        mouseTotal++;
    }

    // Behavior without parameters
    void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
        System.out.println("Color: " + color);
        System.out.println("Type: " + type);
    }

        // Behavior with parameters
    void changeType(String newType){
        type = newType;
        System.out.println(model + " type has been updated to " + type);
    }

    // Static method
    static void displayTotalMouse() {
        System.out.println("Total Mouse Created: " + mouseTotal);
    }
}