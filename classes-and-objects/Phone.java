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


        // Create objects using different constructors
        Phone p1 = new Phone(); // default constructor
        Phone p2 = new Phone("Galaxy S26", "White"); // parameterized
        Phone p3 = new Phone("Galaxy A55", "Blue"); // overloaded

       //Access and display attributes
        System.out.println("Phone 1: " + p1.model + ", " + p1.color + ", " + p1.storage);
        System.out.println("Phone 2: " + p2.model + ", " + p2.color + ", " + p2.storage);
        System.out.println("Phone 2: " + p3.model + ", " + p3.color + ", " + p3.storage);
        
        System.out.println(" ");


        // behavior without parameter
        p1.displayPhoneInfo();

        System.out.println();

        // behavior with parameter
        p3.changeColor("Red");

        System.out.println();

        // Static usage
        Phone.displayTotalPhones();
    }
