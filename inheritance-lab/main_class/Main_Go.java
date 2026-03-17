/**
 * Main_Go.java
 * Inheritance Program
 * This was made by using the Parent class of Diover Canillo [Wood_Canillo.java]
 *
 * ============================================================
 *  INHERITANCE BEHAVIOR ANALYSIS
 * ============================================================
 *
 * [1] WHAT IS THE IS-A RELATIONSHIP IN YOUR PROGRAM?
 *    - "CrimsonWood IS-A Wood" because it extends Wood and is a type of wood.
 *      
 *    - "WarpedWood IS-A Wood" because it extends Wood and is a type of wood.
 *
 * [2] WHICH METHOD WAS OVERRIDDEN?
 *    - Parent [Wood_Canillo] knock() method was overridden in BOTH subclasses:
 *      CrimsonWood_Go
 *      WarpedWood_Go
 *
 * [3] WHAT HAPPENS DURING DYNAMIC BINDING?
 *    - Even if the variable is typed as Wood_Canillo,
 *      Java will call the method based on the actual object.
 *
 *      Example:
 *      w = new WarpedWood_Go();
 *      w.knock(); // Calls WarpedWood_Go's knock(), NOT Wood_Canillo's, and thus, the wood breaks.
 *
 * [4] WHAT METHODS WERE INHERITED FROM THE PARENT CLASS?
 *    - knock() were inherited from Wood_Canillo
 *      (but knock() was overridden in both subclasses).
 *
 *    - getWoodName() was inherited and used by subclasses.
 *
 *    - All attributes are also inherited.
 *
 * [5] WHAT NEW BEHAVIOR DID THE SUBCLASSES INTRODUCE?
 *
 *    - CrimsonWood_Go introduced:
 *        knock() (overridden) - Knocks differently for strength testing
 *
 *    - WarpedWood_Go introduced:
 *        knock() (overridden) - Knocking once causes it to break
 *
 * ============================================================
 */

package main_class;

import sub_class.CrimsonWood_Go;
import sub_class.WarpedWood_Go;

public class Main_Go {
    public static void main(String[] args) {

        CrimsonWood_Go c = new CrimsonWood_Go();
        WarpedWood_Go w = new WarpedWood_Go();

        c.burn();
        c.knock();

        w.burn();
        w.knock();
    }
}
