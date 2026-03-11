public class ObjectDetailsPrinter {
    public static void main(String[] args) {
        // This is the object instance created from the Student class
        // Object using default constructor
        Student s1 = new Student();

        // Object using parameterized constructor
        Student s2 = new Student("Maria", 20, "BSCS");

        // Object using overloaded constructor
        Student s3 = new Student("Carlos", "BSIT");

        // Print attributes and trigger behaviors
        s1.introduce();
        s2.introduce();

        // Method with parameter
        s2.updateCourse("BS Data Science");

        // Static method
        Student.displayTotalStudents();

        // This is the object instance created from the Keyboard class
        // This instance object was created by <Canillo>. This Keyboard class was created by <Onte>
        System.out.println("\nThis instance object was created by <Canillo>. This Keyboard class was created by <Onte>"); // spacer
        Keyboard k1 = new Keyboard(); // Object created using default constructor
        Keyboard k2 = new Keyboard("Aula", 2499.00, "White", "Mechanical", 10); // Object created using parameterized constructor

        // Attributes of k1
        System.out.println("=== Attributes of k1 ===" 
                + "\nBrand: " + k1.brand 
                + "\nPrice: " + k1.price
                + "\nColor: " + k1.color
                + "\nType: " + k1.type
                + "\nStock: " + k1.stock);

        // usage for methods with parameter and without
        System.out.println("\n=== METHODS ===");
        k2.displayKeyboard(); // display of k2 (method without parameter)
        k2.applyDiscount(20.0); // discount for k2 (method with parameter)

        System.out.println("\n=== STATIC METHODS ===");
        // Display total keyboards using static attribute
        System.out.println("Keyboards Total: " + k1.totalKeyboard);
        // Display total keyboards using static method
        k2.displayTotalKeyboard();

        // This is the object instance created from the Gun class
        // This instance object was created by <Navarro>. This Gun class was created by <Go>
        System.out.println("\nThis instance object was created by <Navarro>. This Keyboard class was created by <Go>");
        // Object using default constructor
        Gun g1 = new Gun();
        // Object using parameterized constructor
        Gun g2 = new Gun("M4A1", 2001, 800, "5.56mm", "Colt");

        // Attributes of g1
        System.out.println("=== Attributes ==="
                + "\nModel: " + g1.model
                + "\nYear: " + g1.year
                + "\nRounds Per Minute: " + g1.roundsPerMinute
                + "\nCaliber: " + g1.caliber
                + "\nManufacturer: " + g1.manufacturer);

        // Methods
        System.out.println("\n=== METHODS ===");
        g2.displayInfo(); // method without parameter
        g1.setInfo("Glock 17", 1982, 400, "9mm", "Glock"); // method with parameter
        System.out.println("=== Updated Info ===");
        g1.displayInfo(); // display updated g1

        // Static
        System.out.println("=== STATIC METHOD ===");
        System.out.println("Total Guns:" + Gun.stock);
        Gun.displayTotalStock(); // static method
 
        // This is the object instance created from the Laptop class
        // This instance object was created by <Onte>. This Laptop class was created by <Margreleigne>
        System.out.println("\n This instance object was created by <Onte>. This Laptop class was created by <Margreleigne>"); 
        Laptop l1 = new Laptop ();
        Laptop l2 = new Laptop ("Macbook", 109990);

        // Attributes of l1
        System.out.println("=== Attributes of l1 ==="
            + "\nName: " + l1.name
            + "\nPrice: " + l1.price
            + "\nColor: " + l1.color
            + "\nStock: " + l1.stock);

        // usage for methods with parameter and without
        System.out.println("\n=== METHODS ===");
        l2.displayDetails(); //Display for l2 (method without parameter)
        l2.applyDiscount(67.0); //Discount for l2 (method with parameter)

        System.out.println("\n === STATIC METHOD ===");
        // Display total keyboards using static attribute
        System.out.println("Laptops total: " + l1.totalLaptop);
        //Display Total Laptop using static method
        l2.displayTotalLaptop();

       // This instance was made by <Clint>. This Book class was made by <Trespeces>
        // Create object using default constructor
        Book b1 = new Book();

        // Create object using overloaded constructor
        Book b2 = new Book("Maria");

        // Print attributes directly (instance variables)
        System.out.println("b1 Title: " + b1.title);
        System.out.println("b1 Author: " + b1.author);
        System.out.println("b1 Price: " + b1.price);

        // Method without parameter
        System.out.println("b1 Title (using getTitle): " + b1.getTitle());
        System.out.println("b2 Title (using getTitle): " + b2.getTitle());

        // Method with parameter to update title
        b2.setTitle("Bible");
        System.out.println("Updated b2 Title: " + b2.getTitle());
        
        // Static method and static variable
        System.out.println("Store Name (using getStore): " + Book.getStore());
        System.out.println("Store Name (direct access): " + Book.store);
         
        // =========================================
        // Object 1 → Default constructor
        // This object instance was created by <Nono>. Order class was created by <Jagunap>
        // =========================================
        Order o1 = new Order(); // default constructor
 
        // Access & Display Attributes
        System.out.println("=== Object 1 (Default) Attributes ===");
        System.out.println(o1.getOrderId());
        System.out.println(o1.getCustomerName());
        System.out.println(o1.getProductName());
        System.out.println(o1.getQuantity());
        System.out.println(o1.getPrice());
        System.out.println(o1.getOrderDate());
        System.out.println("toString(): " + o1); // uses overridden toString()
 
        // Trigger Behaviors
        System.out.println("\n=== Object 1 Behaviors ===");
        // Call method without parameters
        o1.printSummary();
        // Call method with parameters
        o1.applyDiscount(5); // 5% discount on price (though it's 0.0 initially)
 
        // =========================================
        // Object 2 → Parameterized constructor
        // =========================================
        Order o2 = new Order(
                "ORD-1001",
                "Janelle Jagunap",
                "Wireless Mouse",
                2,
                599.00,
                "2026-03-10"
        );
 
        // Access & Display Attributes
        System.out.println("\n=== Object 2 (Parameterized) Attributes ===");
        System.out.println(o2.getOrderId());
        System.out.println(o2.getCustomerName());
        System.out.println(o2.getProductName());
        System.out.println(o2.getQuantity());
        System.out.println(o2.getPrice());
        System.out.println(o2.getOrderDate());
        System.out.println("Total Amount: " + o2.getTotalAmount());
 
        // Trigger Behaviors
        System.out.println("\n=== Object 2 Behaviors ===");
        // Call method without parameters
        o2.printSummary();
        // Call method with parameters
        o2.applyDiscount(10); // Apply 10% discount
        o2.printSummary();    // Show summary again after discount
 
        // Demonstrate setters (method with parameter)
        o2.setProductName("Wireless Gaming Mouse");
        o2.setQuantity(3);
        System.out.println("\nAfter updates:");
        o2.printSummary();
 
        // =========================================
        // Demonstrate Static Usage
        // =========================================
        System.out.println("\n=== Static Usage ===");
        Order.printTotalOrders(); // static method to show count of created objects
        // (If you had a public static field, you'd access it like: ClassName.staticField)
 
        // Optional: Create another object to see the counter increment
        Order o3 = new Order("ORD-1002", "Alex Cruz", "Mechanical Keyboard", 1, 2899.00, "2026-03-11");
        Order.printTotalOrders();
        
        // This is the object instance created from the Keyboard class
        // This instance object was created by <Cardeño>. This Keyboard class was created by <Nono>
        System.out.println("\nThis instance object was created by <Cardeño>. This Keyboard class was created by <Nono>");
        // Object using default constructor
        Seller seller1 = new Seller();
        Seller seller2 = new Seller("Cardeño", "Faye's Boutique");
        Seller seller3 = new Seller("Nono", "Nono's Shop", 4.5);

        // Attributes of seller1
        System.out.println("=== Attributes of seller1 ==="
        + "\nName: " + seller1.name
        + "\nShop Name: " + seller1.shopName
        + "\nRating: " + seller1.rating);

        // usage for methods with parameter and without
        System.out.println("\n=== METHODS ===");
        seller2.displaySeller(); // method without parameter
        seller2.setRating(5.0);  // method with parameter
        System.out.println("=== Updated Info of seller2 ===");
        seller2.displaySeller();

        // Static usage
        System.out.println("\n=== STATIC METHOD ===");
        System.out.println("Total Sellers: " + Seller.totalSellers); // static attribute
        Seller.printTotalSellers(); // static method
        // This is the object instance created from the StudySession class
        // This instance object was created by <Jagunap>. This StudySession class was created by <Cardeño>
        // object using default constructor
        StudySession ss1 = new StudySession();

        // object using parameterized constructor
        StudySession ss2 = new StudySession("Science");

        // object using overloaded constructor
        StudySession ss3 = new StudySession("Mathematics", 3, "Faye");

        // call method without parameters
        ss1.displaySession();
        ss2.displaySession();
        ss3.displaySession();

        // call method with parameter
        ss2.setHours(4);

        // static method usage
        StudySession.getSchool();
        System.out.println(StudySession.getSchool());

        // This is the object instance created from the Product Class
        // This instance was created by <Obedoza>. This class was made by <Navarro> 
        // Object using default constructor
        Product p1 = new Product();

        // Object using parameterized constructor
        Product p2 = new Product("Bose", 10000, "Speaker", 5);

        // Object using overloaded constructor
        Product p3 = new Product("Gibson Guitar", 50000);

        // Print attributes and trigger behaviors
        p1.displayDetails();
        System.out.println();
        p2.displayDetails();
        System.out.println();
        p3.displayDetails();
        System.out.println();

        // Method with parameter
        p2.applyDiscount(10);

        // Static method
        Product.displayTotalProducts();
        System.out.println(p2.totalProducts);

        // This is the object instance created from the PC class
        // This instance object was created by <Caneda>. This PC class was created by <Canillo>
        System.out.println("\n This instance object was created by <Caneda>. This PC class was created by <Canillo>");
        PC PC1 = new PC();
        PC PC2 = new PC("Yellow");

        //Access and Display Attributes: 
        System.out.println("=== Attributes of P1 ===");
        System.out.println("The GPU Manufacturer For PC1 is: " + PC1.GPUManufacturer);
        System.out.println("The GPU Manufacturer For PC2 is: " + PC2.GPUManufacturer);

        System.out.println("\nPC1 STATS");
        //method without parameter
        PC1.introduceSpecs();
        // method with parameter
        PC2.setCaseColor("Black"); 
        //print of line 86
        System.out.println("The new color of pc1 is: " + PC1.caseColor );

        // static attribute 
        System.out.println("The static attribute \"Socket type\"for PC1: "+ PC1.socketType);
        // static method
        PC1.displayTotalPC();

        // This is the object instance created from the Coffee Class
        // This instance was created by <Go>. This class was made by <Realon> 
 
        // Object making use of the default constructor
        Coffee c1 = new Coffee();

        // Object making use of the parametized constructor
        Coffee c2 = new Coffee("Cappucino", 70.99, "Small", "Coffee", 17);

        // Object making use of the overloaded constructor
        Coffee c3 = new Coffee("Americano", 40.99, "Small");

        // Print default attributes and other objects
        c1.displayFixedDetails();
        System.out.println();
        c2.displayFixedDetails();
        System.out.println();
        c3.displayFixedDetails();
        System.out.println();

        // Method with parameter
        c3.addStock(30);

        // Static method
        Coffee.displayTotalAmount();
        System.out.println("Kinds of Coffee Available:" + Coffee.totalAmount);
        System.out.println();

        // This object instance was created by <Malig>. This Minerals class was created by <Caneda>

        // Object using default constructor
        Minerals m1 = new Minerals();

        // Object using parameterized constructor
        Minerals m2 = new Minerals("Diamond", "Red", "Plains biome", "500 -43 124", 56);

        // Print attributes
        System.out.println();
        System.out.println(m1.mineralsName);
        System.out.println(m1.Color);
        System.out.println(m1.mineLocation);
        System.out.println(m1.Cords);
        System.out.println(m1.mineralsInInventory);

        // Method without parameters
        m1.displayMinerals();
        m2.displayMinerals();

        // Method with parameter
        m2.updateMineral("Emerald");
        System.out.println();

        // Static method and Static variable
        Minerals.displayTotalMineralsInInventory();
        System.out.println(Minerals.mineralsMiner); 

        // This instance was made by <Trespeces>. This Mouse class was made by <Clint>

        // Create object using default constructor
        Mouse ms1 = new Mouse();

        // Create object using overloaded constructor
        Mouse ms2 = new Mouse("Red");

        // Print attributes directly (instance variables)
        System.out.println("ms1 Model: " + ms1.model);
        System.out.println("ms1 Color: " + ms1.color);

        // Method without parameter
        System.out.println("ms1 Color: " + ms1.getColor());
        System.out.println("ms2 Color: " + ms2.getColor());

        // Method with parameter to update color
        ms2.setColor("Blue");
        System.out.println("Updated ms2 Color: " + ms2.getColor());

        // Static method and static variable
        System.out.println("Manufacturer: " + Mouse.getManufacturer());
        System.out.println("Manufacturer: " + Mouse.manufacturer);

        // This is the object instance created from the Phone class.
        // This instance object was created by <Ablis>. This Phone class was created by <Gedoria>.
        Phone p1= new Phone();
        Phone p2= new Phone("S26 Series", "Black", 128);

        // Attributes of p1
        System.out.println("=== Attributes of p1==="
            + "\nModel: " + p1.model
            + "\nColor: " + p1.color
            + "\nStorage: " + p1.storage + "GB");

        // usage for methods with parameter and without
        System.out.println("\n=== METHODS ===");
        p2.displayPhoneInfo(); // Method without parameter
        p2.changeColor("Blue"); // Method with parameter

        System.out.println("\n=== STATIC METHOD ===");
        // Display total phones using static attribute
        System.out.println("Phone total: " + Phone.totalPhones);

        // Display total phones using static method
        Phone.displayTotalPhones();
    
    }
}

// javac classes-and-objects-lab/Student.java classes-and-objects-lab/ObjectDetailsPrinter.java
// java -cp classes-and-objects-lab ObjectDetailsPrinter
