package main_class;

import parent_class.Appliances_Arban;
import subclass.WashingMachine_Ovejera;
import subclass.Refrigerator_Ovejera;

public class Main_Ovejera {
    public static void main(String[] args) {

        // Object Creation
        WashingMachine_Ovejera wm = new WashingMachine_Ovejera(
                "Washing Machine", "LG", 5, true, 10, "Quick Wash");

        Refrigerator_Ovejera ref = new Refrigerator_Ovejera(
                "Refrigerator", "Samsung", 3, true, 300, "No Frost");

        // Child-specific + Overridden Methods
        System.out.println("=== Subclass Behaviors ===");

        System.out.println("\nWashing Machine:");
        wm.startWash();   // child-specific
        wm.action();      // overridden

        System.out.println("\nRefrigerator:");
        ref.storeFood("Milk"); // child-specific
        ref.action();          // overridden


        // Dynamic Binding 
        System.out.println("\n=== Dynamic Binding Demo ===");

        Appliances_Arban appliance;

        // Using Washing Machine object
        appliance = new WashingMachine_Ovejera(
                "Washing Machine", "Panasonic", 2, true, 8, "Heavy Duty");
        appliance.action(); // calls overridden method

        // Using Refrigerator object
        appliance = new Refrigerator_Ovejera(
                "Refrigerator", "Whirlpool", 4, false, 250, "Inverter");
        appliance.action(); // calls overridden method

    }
}


/** Q&A

1. What is the IS-A relationship in your program?
   WashingMachine_Ovejera and Refrigerator_Ovejera both IS-A Appliances_Arban. 
   This means both subclasses are types of appliances and inherit the attributes 
   and behaviors of the parent class.

2. Which method was overridden?
   The action() method was overridden in both subclasses.
   - WashingMachine_Ovejera overrides it to describe washing clothes.
   - Refrigerator_Ovejera overrides it to describe cooling food.

3. What happens during dynamic binding?
   When Appliances_Arban appliance = new WashingMachine_Ovejera() is used, 
   the reference type is the parent class while the actual object is the subclass. 
   Java determines which action() method to execute at runtime, so the subclass 
   version of the method is called.

4. What methods were inherited from the parent class?
   Both subclasses inherited:
   - on()
   - off()
   - action() (before being overridden)
   
   They also inherited the protected attributes:
   - type
   - brand
   - stock
   - power

5. What new behavior did the subclass introduce?
   - WashingMachine_Ovejera introduced startWash(), which starts the washing 
     process based on power status.
   - Refrigerator_Ovejera introduced storeFood(), which allows storing food 
     inside the refrigerator if it is powered on.

*/