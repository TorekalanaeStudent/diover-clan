public class ObjectDetailsPrinter {
        public static void main(String[] args) {
                // This is the object instance created from the Student class
                        // Object using default constructor
                                Book s1 = new Book();

                                        // Object using parameterized constructor
                                                Book s2 = new Book("Maria", 20, "BSCS");

                                                        // Object using overloaded constructor
                                                                Student s3 = new Student("Carlos", "BSIT");

                                                                        // Print attributes and trigger behaviors
                                                                                s1.introduce();
                                                                                        s2.introduce();

                                                                                                // Method with parameter
                                                                                                        s2.updateCourse("BS Data Science");

                                                                                                                // Static method
                                                                                                                        Student.displayTotalStudents();

                                                                                                                                // This instance was made by <Clint>. 
                                                                                                                                   }
                                                                                                                                   }

                                                                                                                                   // javac classes-and-objects-lab/Student.java classes-and-objects-lab/ObjectDetailsPrinter.java
                                                                                                                                   // java -cp classes-and-objects-lab ObjectDetailsPrinter
}