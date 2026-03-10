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
        
        // Created instance of Products <Navarro>. This class was made by <Realon> "CoffeeOrder.Java"
        // This is the object instance created from the Coffee class
        // Object using parameterized constructor
        CoffeeOrder c1 = new CoffeeOrder("Latte", "Small");

        // Object using parameterized constructor
        CoffeeOrder c2 = new CoffeeOrder("Espresso", "Medium");

        // Object using parameterized constructor
        CoffeeOrder c3 = new CoffeeOrder("Cappuccino", "Large");

        // Print order and price
        System.out.println(c1.getOrder() + " - " + c1.getPrice());
        System.out.println(c2.getOrder() + " - " + c2.getPrice());
        System.out.println(c3.getOrder() + " - " + c3.getPrice());
        // Created instance of Products <Navarro>. This class was made by <Realon> "CoffeeOrder.Java"   

    }
}

// javac classes-and-objects-lab/Student.java classes-and-objects-lab/ObjectDetailsPrinter.java
// java -cp classes-and-objects-lab ObjectDetailsPrinterbjects-lab ObjectDetailsPrinter
