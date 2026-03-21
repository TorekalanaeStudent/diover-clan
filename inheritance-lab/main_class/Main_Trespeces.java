package main_class;

import parent_class.Person_DeJuras;
import sub_class.Teacher_Trespeces;
import sub_class.SewageWorker_Trespeces;

public class Main_Trespeces {
    public static void main(String[] args) {
        // object creation
        Teacher_Trespeces teacher = new Teacher_Trespeces ("Jennie", "Teacher", 30, "National University Laguna", "Art Appreciation", "2019-1019670", 7);
        SewageWorker_Trespeces sewage = new SewageWorker_Trespeces ("John Kyle Obedoza", "Sewage Worker", 67, "Buscalan, Tinglayan, Kalinga", "2001-10001067", 25);

        // child specific and overrides
        System.out.println("Child Specific Behavior and Overridden");
        System.out.println("Teacher Sub-class");
        teacher.gradeStudents(); // child specific
        teacher.task();          // overridden

        System.out.println("\nSewageWorker Sub-Class"); 
        sewage.checkExperience(); // child specific
        sewage.task();            // overriden

        // dynamic binding (Teacher_Trespeces)

        Person_DeJuras person; // reference variable
        System.out.println("\n\nDynamic Binding Demonstration");
        person = new Teacher_Trespeces ("Ada Wong", "Teacher", 30, "National University Laguna", "Espionage Appreciation", "1998-1098420", 28);
        person.task();

        // dynamic binding (SewageWorker_Trespeces)
        person = new SewageWorker_Trespeces ("John Kyle Obedoza", "Sewage Worker", 67, "Buscalan, Tinglayan, Kalinga", "2001-10001067", 25);
        person.task();
        
        
        /** Q&A
          1. What is the IS-A relationship in your program?
          Teacher_Trespeces and SewageWorker_Trespeces both 'IS-A' Person_DeJuras, meaning both 
          child classes are a type of "person". This means that both child classes inherit the 
          attributes and behaviors of the parent class Person_DeJuras.
          
          2. Which method was overridden? 
          The task() method was overridden in both child classes. Teacher_Trespeces overrides it 
          to prepare a lesson plan, while SewageWorker_Trespeces overrides it to clean the septic 
          tank.
          
          3. What happens during dynamic binding?
          When Person_DeJuras "person = new Teacher_Trespeces()" is created, the parent class acts 
          as the reference type while the child class is the actual object. Java determines which 
          task() to run based on the actual object, not the reference type, hence the child class 
          method executes.
          
          4. What methods were inherited from the parent class?
          Both child classes inherited role(), task(), and validID() from Person_DeJuras, along 
          with the protected attributes name, occupation, and age.
          
          5. What new behavior did the subclass introduce?
          Teacher_Trespeces introduced gradeStudents(), which checks if the teacher is a veteran 
          or a newbie based on years of experience. SewageWorker_Trespeces introduced 
          checkExperience(), same as gradeStudents() but based on years of service.
         */
    }
}
    
   

    



