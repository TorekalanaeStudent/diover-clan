public class Main_Obedoza {
    public static void main(String[] args) {

        /**
         * 
         */

        // Object Creation 
        Student_Obedoza studObe1 = new studObe1();
        Student_Obedoza studObe2 = new studObe1();

        studObe1.displayNickName(); // Child Specific Behavior
        StudObe1.checkUserActivity(); // Overidden 

        studObe2.displayEmployeeInfo(); // Child Specific Behavior 
        studObe2.userCorrectionInputs(); // Overridden 

        /*
           ParentClass ref;

        ref = new ChildClassOne();
        ref.commonBehavior(); // ChildClassOne version runs

        ref = new ChildClassTwo();
        ref.commonBehavior(); // ChildClassTwo version runs
        */

        // Demonstration of Dynamic Binding (Child Class 1)
        UserTypes_Caneda = new Student_Obedoza();
        UserTypes_Caneda.displayNickName();

        // // Demonstration of Dynamic Binding (Child Class 2)
        UserTypes_Caneda = new Employee_Obedoza();
        UserTypes_Caneda.displayEmployeeInfo();

        /** Explanation: 
         * - ParentClass (UserTypes_Caneda) is a reference class 
         * - While new Employee_Obedoza is considered as the actual object 
         * - UserTypes_Caneda.displayEmployeeInfo(), asks "What Object am I executing" not "Variable"
         * - Therefore it executes the Child Class (Employee_Obedoza)
         */ 

        



    }
}