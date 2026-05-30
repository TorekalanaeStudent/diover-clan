public class Phone {

    // Attributes
    String model;
    String color;
    int storage;

    // Static attribute
    static int totalPhones = 0;

    // Default constructor
    Phone() {
        model = "S26 Series";
        color = "Black";
        storage = 128;
        totalPhones++;
    }

    // Parameterized constructor
    Phone(String model, String color, int storage) {
        this.model = model;
        this.color = color;
        this.storage = storage;
        totalPhones++;
    }

    // Overloaded constructor
    Phone(String model, String color) {
        this.model = model;
        this.color = color;
        this.storage = 128;
        totalPhones++;
    }

    // Behavior without parameter
    void displayPhoneInfo() {
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Storage: " + storage + "GB");
    }

    // Behavior with parameter
    void changeColor(String newColor) {
        color = newColor;
        System.out.println(model + " color changed to " + color);
    }

    // Static method
    static void displayTotalPhones() {
        System.out.println("Total Phones Created: " + totalPhones);
    }
}