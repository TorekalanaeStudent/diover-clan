package demo_class;

import abstract_classes.Superhero_Ablis;
import interfaces.SuperheroSystem_Ablis;
import implementations.FlyingHero_Gedoria;

public class AbstractionPolyDemo_Gedoria {

    public static void main(String[] args) {
        /*
        * What abstract class did you create?
        * Flashlight_Gedoria.java
        *  
        * What interface did you create?
        * LightSystem_Gedoria.java
        * 
        * What methods did you override?
        * The methods that were overridden are:
        * usePower() from the abstract class Superhero_Ablis
        * performAttack() from the interface SuperheroSystem_Ablis
        * performAttack(String target) from the interface SuperheroSystem_Ablis
        * performAbility() from the interface SuperheroSystem_Ablis
        * 
        * 
        * Q4: What methods did you overload?
        * The method that was overloaded is performAttack().
        * */ 


        // Where does dynamic binding occur in your code?
        // Here, abstract reference pointing to concrete object
        Superhero_Ablis hero1 = new FlyingHero_Gedoria("SkyFlash", 21, 900, "light-speed flight");

        hero1.introduce();
        hero1.usePower();   // dynamic binding
        hero1.saveTheDay(); // dynamic binding

        System.out.println();

        // Interface reference 
        SuperheroSystem_Ablis hero2 = new FlyingHero_Gedoria("StormWing", 25, 850, "storm control");

        // Which part shows polymorphism?
        // Same methods, different behavior depending on object
        hero2.performAttack();
        hero2.performAttack("Villain X"); // overloaded method
        hero2.performAbility();

        System.out.println();

        // Overloading
        FlyingHero_Gedoria hero3 = new FlyingHero_Gedoria();
        hero3.performAttack();            // method 1
        hero3.performAttack("Enemy");     // overloaded version

        // How does your design achieve low coupling?
        // Code depends on Superhero_Ablis and SuperheroSystem_Ablis, not concrete class

        // How does your design achieve high cohesion?
        // Each class has a single responsibility
    }
}
