package main_class;

import parent_class.Book_Jagunap;
import sub_class.EBook_Nono;
import sub_class.PrintedBook_Nono;

/** Q&A
  1. What is the IS-A relationship in your program?
  Answer: EBook_Nono and PrintedBook_Nono are both types of Book_Jagunap. 
  This shows the IS-A relationship because both are child classes of Book_Jagunap.

  2. Which method was overridden? 
  Answer: printInfo() was overridden in both EBook_Nono and PrintedBook_Nono.

  3. What happens during dynamic binding?
  Answer: When an object is created (Ex. Book_Jagunap b = new EBook_Nono()), 
  the parent class is the reference type while the child class is the actual object. 
  Java checks the actual object type at runtime, so the overridden method in the child class executes.

  4. What methods were inherited from the parent class?
  Answer: The subclasses inherited read(), printInfo(), and openBook() methods from Book_Jagunap.

  5. What new behavior did the subclass introduce?
  Answer: EBook_Nono introduced download() and PrintedBook_Nono introduced flipPages().
*/

public class Main_Nono {
    public static void main(String[] args) {

        // CHILD CLASSES DEMONSTRATION

        // Object Creation
        EBook_Nono ebook = new EBook_Nono("Java Programming", "Nono", 200, 5.5);
        PrintedBook_Nono printed = new PrintedBook_Nono("OOP Concepts", "Nono", 300, "Paperback");

        System.out.println("=== Child Specific Behavior and Overridden ===");

        ebook.download(); // Child specific behavior
        ebook.printInfo(); // Overridden

        printed.flipPages(); // Child specific behavior
        printed.printInfo(); // Overridden

        System.out.println("=== Dynamic Binding Demo ===");

        // Demonstration of Dynamic Binding (Child Class 1)
        Book_Jagunap book; // reference variable

        book = new EBook_Nono("Data Structures", "Author A", 150, 3.2);
        book.printInfo(); // calls EBook version

        // Demonstration of Dynamic Binding (Child Class 2)
        book = new PrintedBook_Nono("Algorithms", "Author B", 400, "Hardcover");
        book.printInfo(); // calls PrintedBook version

        /** Explanation:
         * - Parent class (Book_Jagunap book) is the reference variable
         * - The actual object is either EBook_Nono or PrintedBook_Nono
         * - Java determines which method to execute at runtime
         * - Therefore, the overridden method in the subclass is executed
         */
    }
}