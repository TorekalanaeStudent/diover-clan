package main_class;

import parent_class.Gun_Go;
import sub_class.M4_Navarro;
import sub_class.SVD_Navarro;


/**
 * Main_Navarro.java
 * Inheritance Demo Program
 * This was made by using the Parent class of Seth Go
 *
 * ============================================================
 *  INHERITANCE BEHAVIOR ANALYSIS
 * ============================================================
 *
 * 1. WHAT IS THE IS-A RELATIONSHIP IN YOUR PROGRAM?
 *    - "SVD IS-A Gun" because SVD extends Gun and is a type of Gun.
 *
 *    - "M4 IS-A Gun" because M4 extends Gun and is a type of Gun.
 *
 * 2. WHICH METHOD WAS OVERRIDDEN?
 *    - shoot() was overridden in BOTH SVD and M4.
 *      Parent (Gun)
 *      SVD           
 *      M4           
 *    - reload()
 *      Parent (Gun)  
 *      SVD          
 *      M4            
 *
 * 3. WHAT HAPPENS DURING DYNAMIC BINDING?
 *     Even though the variable is typed as Gun, The Java calls the actual
 *      subclass's overridden method when running the code. 
 *      For Example: Gun g = new SVD();
 *      g.shoot(); // calls SVD.shoot(), NOT Gun.shoot()
 *      Because it was overridden. 
 *
 * 4. WHAT METHODS WERE INHERITED FROM THE PARENT CLASS?
 *    - shoot() and reload() were inherited from Gun but then was OVERRIDDEN.
 *    - All attributes are inherited too.
 *
 * 5. WHAT NEW BEHAVIOR DID THE SUBCLASSES INTRODUCE?
 *    - SVD introduced:
 *        scope()            - You can zoom in for better aim.
 *        holdBreath()       - Make it so that you can steady your aim better.
 *        toggleSuppressor() - Basically toggles on or off on a suppressor to a gun
 *
 *    - M4 introduced:
 *        switchFireMode()   - Switches between Single, Burst, and Auto
 *        attachSuppressor() - attaches suppressor on or off like in the toggleSuppressor but with a different name.
 *
 * ============================================================
 */

public class Main_Navarro {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   GUN INHERITANCE DEMO");
        System.out.println("========================================\n");

        System.out.println("- Prints out the methods ");
        //Dynamic Binding
        SVD_Navarro svd = new SVD_Navarro();
        M4_Navarro  m4  = new M4_Navarro();
        svd.shoot();
        m4.shoot();    
        System.out.println();
        
        svd.reload();
        m4.reload();
        System.out.println();

        //Behaviors
        System.out.println("SVD Behaviors \n");
        svd.scope();
        svd.holdBreath();
        svd.shoot();
        svd.toggleSuppressor();   
        svd.shoot();             
        System.out.println();
        
        System.out.println("M4 Behaviors \n");
        m4.switchFireMode();         
        m4.shoot();
        m4.switchFireMode();       
        m4.shoot();
        m4.attachSuppressor();       
        m4.shoot();                 
        System.out.println();

   
        System.out.println("========================================");
        System.out.println("   DYNAMIC BINDING DEMONSTRATION");
        System.out.println("========================================\n");
 
        Gun_Go g1 = new SVD_Navarro();
        Gun_Go g2 = new M4_Navarro();
 
        Gun_Go[] arsenal = { g1, g2 };
 
        System.out.println("- Even though the array is typed as Gun, Java calls the correct overridden method at runtime ");

        for (Gun_Go g : arsenal) {
          
            g.shoot();  
            g.reload();   
            System.out.println();
        }
 
        System.out.println("- Checking each gun's actual type: \n");
 
        for (Gun_Go g : arsenal) {
            if (g instanceof SVD_Navarro s) {
                s.scope();
                s.holdBreath();
                s.shoot();
            } else if (g instanceof M4_Navarro m) {
                m.switchFireMode();
                m.shoot();
            }
            System.out.println();
        }
 
        System.out.println("========================================");
        System.out.println("   END OF DEMO");
        System.out.println("========================================");
    }
 
}