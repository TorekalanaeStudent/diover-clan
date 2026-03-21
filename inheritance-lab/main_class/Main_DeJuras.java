package main_class;

import sub_class.Math_DeJuras;
import sub_class.Science_DeJuras;
import parent_class.SubjectsTrespeces;

public class Main_Class {

    public static void main(String [] args){
    
    System.out.println("=== Math Subject ===");

     // first object
        Math_DeJuras math = new Math_DeJuras();
        math.classMessage();        // overridden
        math.enrollSub();           // inherited
        math.scheduleViewer();      // inherited
        math.status();              // subclass method

        System.out.println();

    // parameterized constructor
        Math_DeJuras math2 = new Math_DeJuras("Math", "Wednesday", "Romnick Realon", "10:00 A.M", 301, true);
        math2.setGrade(67.00);
        math2.classMessage(); 
        math2.dropOutSub();         // inherited
        math2.scheduleViewer();     
        math2.status();



    System.out.println("=== Science Subject ===");

    // second object
        Science_DeJuras sci = new Science_DeJuras();
        
        sci.classMessage();
        sci.getTotalAverage();      // subclass method
        sci.scheduleViewer();       // inherited

        System.out.println();

    // parameterized constructor
        Science_DeJuras sci2 = new Science_DeJuras("General Chemistry", "Friday", "Mr. Walter White", "2:00 P.M", 306, true);
        sci2.setMid(67.00);
        sci2.setFin(80.00);
        sci2.classMessage(); 
        sci2.dropOutSub();          // inherited
        sci2.scheduleViewer();      
        sci2.getTotalAverage();


        SubjectsTrespeces subj1 = new Math_DeJuras();
        SubjectsTrespeces subj2 = new Science_DeJuras();

        subj1.classMessage();   // calls Math version
        subj2.classMessage();   // calls Science version

        subj1.scheduleViewer(); // inherited
        subj2.scheduleViewer(); // inherited

    }
}

/*
- What is the IS-A relationship in your program?
  Math_DeJuras IS-A SubjectsTrespeces
  Science_DeJuras IS-A SubjectsTrespeces

- Which method was overridden?
  classMessage()

- What happens during dynamic binding?
  Java chooses which method to run at runtime based on the object.

- What methods were inherited from the parent class?
  enrollSub(), dropOutSub(), scheduleViewer()

- What new behavior did the subclass introduce?
  Math_DeJuras: status()
  Science_DeJuras: getTotalAverage()
*/