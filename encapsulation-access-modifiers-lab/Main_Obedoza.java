public class Main_Obedoza {

    public static void main(String[] args) {

// Object created from the Product Class of Vince Navarro

        // Default constructor
        E_Product p1 = new E_Product();
        p1.displayDetails();
        System.out.println();

        // Constructor 1
        E_Product p2 = new E_Product("Xiaomi Redmi Note 4", 39999.0, "Phones", 10);
        p2.displayDetails();
        System.out.println();

        // Constructor 2
        E_Product p3 = new E_Product("USB Cable", 149.0);
        p3.displayDetails();
        System.out.println();

        System.out.println("===== Using Getters =====\n");
        System.out.println("Name : " + p2.getName());
        System.out.println("Price : P" + p2.getPrice());
        System.out.println("Category : " + p2.getCategory());
        System.out.println("Stock : " + p2.getStock());
        System.out.println();

        System.out.println("===== Using Setters =====\n");
        p3.setName("USB-C Cable");
        p3.setPrice(299.0);
        p3.setCategory("Accessories");
        p3.setStock(50);
        p3.displayDetails();
        System.out.println();

        System.out.println("===== Behaviors =====\n");
        p2.applyDiscount(10); // valid discount
        p1.restock(5); // valid restock
        System.out.println();

        System.out.println("===== Testing Invalid Inputs =====\n");
        p2.setPrice(-500); // negative price
        p3.setStock(-10); // negative stock
        p1.setName(""); // empty name
        p1.applyDiscount(110); // invalid discount
        System.out.println();

        System.out.println("===== Static Counter =====\n");
        E_Product.displayTotalProducts();

// Object created from the GunRack Class of Sean Ethan Go

        // Object using default constructor
        GunRack gunRack1 = new GunRack();

        // Object using parameterized constructor
        GunRack gunRack2 = new GunRack("AK-47", 1947, 600, "7.62mm", 50, "Kalashnikov Concern");

        // Usage of getters and setters
        System.out.println("Gun Rack 1 Model: " + gunRack1.getModel());
        System.out.println("Gun Rack 1 Year: " + gunRack1.getYear());
        System.out.println("Gun Rack 1 RoundsPerMinute: " + gunRack1.getRoundsPerMinute());
        System.out.println("Gun Rack 1 Caliber: " + gunRack1.getCaliber());
        System.out.println("Gun Rack 1 Penetration: " + gunRack1.getPenetration());
        System.out.println("Gun Rack 1 Manufacturer: " + gunRack1.getManufacturer());

        gunRack2.setModel("Beretta 92FS");
        gunRack2.setYear(2019);
        gunRack2.setRoundsPerMinute(40);
        gunRack2.setCaliber("9×19mm");
        gunRack2.setPenetration(80);
        gunRack2.setManufacturer("Fabbrica d'Armi Pietro Beretta");

        System.out.println("Gun Rack 2 Model: " + gunRack2.getModel());
        System.out.println("Gun Rack 2 Year: " + gunRack2.getYear());
        System.out.println("Gun Rack 2 Round per Minute: " + gunRack2.getRoundsPerMinute());
        System.out.println("Gun Rack 2 caliber: " + gunRack2.getCaliber());
        System.out.println("Gun Rack 2 Penetration: " + gunRack2.getPenetration());
        System.out.println("Gun Rack 2 Manufacturer: " + gunRack2.getManufacturer());

        // behaviors
        gunRack1.displayInfo();
        gunRack2.displayInfo();

        // Demonstration of validation rules
        gunRack2.setYear(-2025);
        gunRack2.setRoundsPerMinute(-10);
        gunRack2.setPenetration(-2);
        // invalid values, must be greater than 0

        System.out.println("Static Stock Counter: ");
        GunRack.displayTotalStock();
    }
}