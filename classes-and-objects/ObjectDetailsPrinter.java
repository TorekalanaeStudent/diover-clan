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
        
    }
}

// javac classes-and-objects-lab/Student.java classes-and-objects-lab/ObjectDetailsPrinter.java
// java -cp classes-and-objects-lab ObjectDetailsPrinter
