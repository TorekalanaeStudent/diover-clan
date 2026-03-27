package demo_class;

import component_class.Clothes_Obedoza;
import component_class.Leg_Canillo;
import component_class.Hands_Navarro;
import sub_class.TapeGrip_Ablis;

/** 
 * gymnasts demo
 * @author: @matidagreat (Ablis, Margreleigne M.)
* === DESIGN ANALYSIS ===
 *
 * 1. HAS-A Relationships (Composition):
 *    - Gymnasts_Ablis HAS-A Clothes_Obedoza
 *    - Gymnasts_Ablis HAS-A Leg_Canillo
 *    - Gymnasts_Ablis HAS-A Hands_Navarro
 *
 * 2. Classes Reused:
 *    - Clothes_Obedoza
 *    - Hands_Navarro
 *    - Legs_Canillo
 *    - TapeGrip_Ablis
 *
 * 3. How Composition Reduces Coupling:
 *    - Basically, Any component can be swapped like for example, TapeGrip_Ablis in place of Finger_Nono
 *      without changing Gymnasts_Ablis's code. so it becomes Low Coupling.
 *
 * 4. How High Cohesion is Implemented:
 *    - By having Each class has one clear responsibility and all the class work together.
 *
 * 5. How Cohesion is Maintained:
 *    - Gun_Magazine_Go handles the magazine logic.
 *    - AppraisalSystem_Caneda handles item valuation logic.
 *    - Kulangot handles its own properties and actions.
 *
 * 6. Why Inheritance is NOT Appropriate Here:
 *    - A Dragoon is not a type of Magazine, Appraisal System, or Kulangot.
 *    - Inheritance (IS-A Relationship) only
 *    - Using extends here would create tight coupling: changing Gun_Magazine_Go
 *      would directly break Dragoon_Navarro, even for unrelated changes.
 *
 * ============================================================
 /** */

public class compositionDemo_Ablis() {

    public static void main(String[]) args) {

    }
}