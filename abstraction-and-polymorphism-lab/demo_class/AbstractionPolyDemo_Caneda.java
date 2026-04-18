package demo_class;

import implementations.BlackMesaScientist_Caneda;
import implementations.CourierSix_Caneda;
import abstract_classes.GameCharacter_Navarro;
import interfaces.CombatSystem_Navarro;

/**
 * @author Canillo, Diover Vincent L.
 * @TorekalanaeStudent
 * 
 *  Q1: What abstract class did you create?
 *  CharacterSpeed_Caneda.java
 *  
 *  Q2: What interface did you create?
 *  MovementSystem_Caneda.java
 * 
 *  Q3: What methods did you override?
 *  attack(), defend(), getStatus(), getRole()
 * 
 *  Q4: What methods did you overload?
 *  attack() that has two varation of with different parameters
 * 
 *  Q5: Where does dynamic binding occur in your code?
 *  -when attack() and defend() is being used on protagonist implementations
 * 
 *  Q6: Which shows polymorphism?
 *  -.attack() and .defend(), is the same but different depending on who uses it.
 *    courier can attack, but scientist will absorb damage depending on shield
 *    scientist can attack, but courier will have a damage reduction
 * 
 *  Q7: How does your design achieve low coupling
 *  -it goes trough interface instead of knowing other implementations details
 * 
 *  Q8: How does your design achieve high cohesion?
 *  -each class only does one job per each, allowing for high cohesion 
 */

public class AbstractionPolyDemo_Caneda {
    public static void main(String[] args) {
    
    //Default constructors
    BlackMesaScientist_Caneda scientist = new BlackMesaScientist_Caneda();

    CourierSix_Caneda courier = new CourierSix_Caneda();
    

    //Printing Protagonists Information
    System.out.println("==== "+scientist.getName().toUpperCase()+" ====");
    System.out.println("Name: "+scientist.getName());
    System.out.println("Role: "+scientist.getRole());
    System.out.println("Status: "+scientist.getStatus());

    System.out.println(); 

    System.out.println("==== "+courier.getName().toUpperCase()+" ====");
    System.out.println("Name: "+courier.getName());
    System.out.println("Karma: "+courier.getRole());
    System.out.println("Status: "+courier.getStatus());


    // Showcase of runtime polymorphism
    GameCharacter_Navarro protagOne = courier;
    GameCharacter_Navarro protagTwo = scientist;

    //Courier prepares to strike
    courier.attack(scientist);

    //Scientist prepares to strike
    scientist.attack(courier);

    //use of overloaded variant of attack

    //Courier Attacks Scientist that uses shield absorbption damage;
    courier.attack(scientist, 120);

    //Scientist Attacks courier that uses damage reduction 
    scientist.attack(courier, 70);

    //Shows new statuses of both protagonist
    System.out.println("=========== NEW STATUS =========== "); 
    System.out.println("==== "+courier.getName().toUpperCase()+" ====");
    System.out.println("Name: "+courier.getName());
    System.out.println("Karma: "+courier.getRole());
    System.out.println("Status: "+courier.getStatus());

    System.out.println();  

    System.out.println("=========== NEW STATUS =========== "); 
    System.out.println("==== "+scientist.getName().toUpperCase()+" ====");
    System.out.println("Name: "+scientist.getName());
    System.out.println("Role: "+scientist.getRole());
    System.out.println("Status: "+scientist.getStatus());

    //end of demo
    System.out.println("=========== FIN =========== "); 
    }
}

