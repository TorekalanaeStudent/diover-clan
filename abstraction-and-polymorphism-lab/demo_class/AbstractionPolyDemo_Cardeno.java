package demo_class;

import implementations.FireAvatarSoldier_Cardeno;
import implementations.FireAvatarWarrior_Cardeno;

import abstract_classes.AvatarCore_Nono;
import interfaces.FireAvatarSystem_Nono;

/**
 * @author @flcardeno (Cardeño, Faye L.)
 * 
 * - Code-Based Analysis  -
 * Q1: What abstract class did you create?
 * - The abstract class I created is the Delivery_Cardeno. 
 * - In this demo, I used AvatarCore_Nono, which was created by my teammate.
 * 
 * Q2: What interface did you create?
 * - The interface I created is the DeliverySystem_Cardeno.
 * - In this demo, I used FireAvatarSystem_Nono, which was also created by my teammate.
 * 
 * Q3: What methods did you override?
 * - In my own implementation, I overrode deliver() and calculateETA(), and implemented 
 * the methods from DeliverySystem_Cardeno such as confirmDelivery(), updateStatus(), 
 * cancelDelivery(), and trackLocation().
 * - In this demo, I overrode useSkill(int cost), getAvatarType(), performDefense(), 
 * and performSpecialAttack() in FireAvatarSoldier_Cardeno and FireAvatarWarrior_Cardeno.
 * 
 * Q4: What methods did you overload?
 * - In my own implementation, I overloaded deliver() with different parameters.
 * - In this demo, I overloaded useSkill(int cost), useSkill(int cost, String target), 
 * performAttack(), and performAttack(String target).
 * 
 * Q5: Where does dynamic binding occur in your code?
 * - Dynamic binding occurs when I use an AvatarCore_Nono and FireAvatarSystem_Nono reference 
 * that points to different concrete objects.
 * 
 * Q6: Which part shows polymorphism?
 * - It was shown when i used one parent type (AvatarCore_Nono) for different objects.
 * 
 * Q7: How does your design achieve low coupling?
 * - It achieves low coupling because I used an abstract class and an interface instead 
 * of direct classes.
 * 
 * Q8: How does your design achieve high cohesion? 
 * - Each class focuses only on its own avatar behavior and responsibilities.
 */

public class AbstractionPolyDemo_Cardeno {

    public static void main(String[] args) {

        // use of abstraction + dynamic binding (abstract class)
        AvatarCore_Nono avatar1 = new FireAvatarSoldier_Cardeno();
        AvatarCore_Nono avatar2 = new FireAvatarWarrior_Cardeno();

        // overriden methods
        avatar1.useSkill(10);   
        avatar2.useSkill(20);  

        System.out.println(avatar1.getAvatarType());
        System.out.println(avatar2.getAvatarType());

        // dynamic binding (interface)
        FireAvatarSystem_Nono system1 = new FireAvatarSoldier_Cardeno();
        FireAvatarSystem_Nono system2 = new FireAvatarWarrior_Cardeno();

        // overriden methods
        system1.performDefense();       
        system2.performDefense();       
        system1.performSpecialAttack(); 
        system2.performSpecialAttack();

        // polymorphism 
        AvatarCore_Nono a = new FireAvatarSoldier_Cardeno();
        AvatarCore_Nono b = new FireAvatarWarrior_Cardeno();

        a.useSkill(15);
        b.useSkill(15);

        // method overloading 
        FireAvatarSoldier_Cardeno soldier = new FireAvatarSoldier_Cardeno();
        soldier.useSkill(10);
        soldier.useSkill(10, "enemy base"); // overloaded method

        soldier.performAttack();
        soldier.performAttack("drone");     // overloaded method

        FireAvatarWarrior_Cardeno warrior = new FireAvatarWarrior_Cardeno();
        warrior.useSkill(20);
        warrior.useSkill(20, "rda base");   // overloaded method

        warrior.performAttack();
        warrior.performAttack("amp suit");  // overloaded method
    }
}