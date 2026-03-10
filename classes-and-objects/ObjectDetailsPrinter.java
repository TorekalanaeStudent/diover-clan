public class ObjectDetailsPrinter {
    public static void main(String[] args) {
        // This is the object instance created from the Product Class
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

        

    }
}