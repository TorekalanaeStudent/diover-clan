package main_class;

import parent_class.UserTypes_Caneda;
import sub_class.Student_Obedoza;
import sub_class.Employee_Obedoza;

        /** Q&A
          1. What is the IS-A relationship in your program?
          Answer: Employee and Student is a User Type, this show the IS-A relationship because both is only a 
          child class of UserType
          
          2. Which method was overridden? 
          Answer: checkUserActivity () was overridden in the case of Child Class 1, and userCorrectionInputs()
          was overridden in the case of Child Class 2
          
          3. What happens during dynamic binding?
          Answer: When an object is created (Ex. UserTypes_Caneda = new Employee_Obedoza()), Parent class is a reference type,
          while the childclass is the Actually Object created. Java asks "what OBJECT am I really pointing to", not "varianble",
          hence why the Child class runs in the program. 
          
          4. What methods were inherited from the parent class?
          Answer: The child class only inherits public and protected methods, as well as other shared methods,
          but not constructors and private methods.
          
          5. What new behavior did the subclass introduce?
          Answer: The subclasses Introduce The addition of distinct actions alongside the addition of the parent features. 
          Also it showed the ability to redefine a parent class's own behavior. 
         */

public class Main_Obedoza {
    public static void main(String[] args) {
    // CHILD CLASSES DEMONSTRATION

        // Object Creation 
        Student_Obedoza studObe = new Student_Obedoza();
        Employee_Obedoza empObe = new Employee_Obedoza();

        System.out.println("=== Child Specific Behavior and Overridden ===");
        studObe.displayNickName(); // Child Specific Behavior
        studObe.checkUserActivity(); // Overidden 

        empObe.displayEmployeeInfo(); // Child Specific Behavior 
        empObe.userCorrectionInputs(); // Overridden 

        System.out.println("=== Dynamic Binding Demo ===");

        // Demonstration of Dynamic Binding (Child Class 1)
        UserTypes_Caneda user; // Creation of reference variable 

        user = new Student_Obedoza();
        user.checkUserActivity();

        // Demonstration of Dynamic Binding (Child Class 2)
        user = new Employee_Obedoza();
        user.userCorrectionInputs();

        /** Explanation: 
         * - ParentClass (UserTypes_Caneda user;) is a reference variable
         * - While new Employee_Obedoza is considered as the actual object 
         * - user.displayEmployeeInfo(), asks "What Object am I executing" not "Variable"
         * - Therefore it executes the Child Class (Employee_Obedoza)
         */ 
    }
}