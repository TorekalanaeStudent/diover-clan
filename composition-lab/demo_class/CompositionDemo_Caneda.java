package composed_class;

import component_class.Hands_Navarro;
import component_class.Kulangot;
import component_class.Clothes_Obedoza;
import composed_class.Hiking_Caneda;
import sub_class.CargoPants_Caneda;

/**
 * Hiking Composition Demo
 * @author: @Rcaneda (Cañeda Ramil Jr M.)
 *
 * 1. HAS-A Relationships (Composition):
 *  * Hiking_Caneda HAS-A Hands_Navarro
 *  * Hiking_Caneda HAS-A Kulangot
 *  * Hiking_Caneda HAS-A Clothes_obedoza
 *
 * 2. Classes Reused:
 *  * Hands_Navarro
 *  * Kulangot
 *  * Clothes_Obedoza
 *  * Hiking_Caneda
 *  * CargoPants_Caneda
 *
 * 3. How Composition Reduces Coupling:
 *  - Essentially it allows the idea of dynamic changes without any changes to the composed class
 *   thus becoming low coupling
 *
 * 4. How High Cohesion is Implemented:
 *  - As one of the core concept of OOP "KISS" or keep it simple, it is implemented when each and every class has one or few function
 *    making it much more conducive for all class to work together
 *
 * 5. How Cohesion is Maintained:
 *  - CargoPants_Caneda acts as the actual object for the pants the hiker is using
 *  - Hiking_Caneda acts as the decisions for the hiker
 *  - kulangot does and handles it's, own actions and logic
 *
 * 6. Why Inheritance is NOT Appropriate Here:
 *  - Hiking is not a type of hands, cargo pants or kulangot
 *  - Hiking simply doesn't need it because each class serves as a specific function that builds upon the hike itself
 *  - Inheritance itself is meant only for those who are of the same type
 */

public class CompositionDemo_Caneda {

    public static void main(String[] args) {

        String barrier = "]===================================================[";

        System.out.println(barrier + "\nHiking Composition Demo\n " + barrier + "\n");

        //Component Classes
        System.out.println("Component Classes Used");
        System.out.println("Hands_Navarro, Kulangot, Clothes_Obedoza, CargoPants_Caneda, Hiking_Caneda");

        //Create components
        Kulangot kulangot = new Kulangot("dark-green", "huge", false);
        Hands_Navarro hands = new Hands_Navarro("Moreno", "Medium", true);
        CargoPants_Caneda cargoPants = new CargoPants_Caneda();

        //Hiking composition
        Hiking_Caneda hike1 = new Hiking_Caneda("1k Meters",hands, cargoPants, kulangot);

        //Using behaviors

        //Walking in the trails
        System.out.println(barrier);
        System.out.println("you are currently on the foot of the mountain there lies the start of the trail its very long. what do you do?");
        hike1.walkInTheTrail(1);

        //Running in the trails
        System.out.println(barrier);
        System.out.println("you encounter a really venomous snake at the trail. what do you do?");
        hike1.walkInTheTrail(3);

        //Slowing down to rest in the trails
        System.out.println(barrier);
        System.out.println("You escaped the snake now. what do you do?");
        hike1.walkInTheTrail(2);

        //Climbing a rope
        System.out.println(barrier);
        System.out.println("You found yourself halted no trails in sight, only a rope that leads to a really steep hill. what do you do?");
        hike1.climbingRopes();

        //continue walking;
        System.out.println(barrier);
        System.out.println("You made it up to the top safely, trails are now in sight for you to go to. what do you do?");
        hike1.walkInTheTrail(2);

        //resting and checking my hands
        System.out.println(barrier);
        System.out.println("You found yourself in a very plain part of the mountain, there is a lot of grass in its field. what do you do?");
        hike1.restForNow(2);
        System.out.println("I look at my hands and notice that my "+hands.getHandSize()+" is a bit bruised from rope earlier");

        //Checking the current elevation
        System.out.println(barrier);
        System.out.println("you are still in the plain part what do you do?");
        hike1.checkCurrentElevation("currently 700 Meters above sea level");

        //Continuing to Walk
        System.out.println(barrier);
        System.out.println("You found that it's high noon. what do you do?");
        hike1.walkInTheTrail(1);

        //Grabbing the ledge
        System.out.println(barrier);
        System.out.println("The trail is cutoff due to a big boulder on the path, luckily there seems to be a ledge to climb it. what do you do?");
        hike1.climbingLedges(1);

        //Checking on hiker condition
        System.out.println(barrier);
        System.out.println("You passed by the boulder but you suddenly felt like you lost somehting. what do you do?");
        hike1.checkingCurrentGear();

        //Continuing to Walk
        System.out.println(barrier);
        System.out.println("You found that everything seems fine. what do you do now?");
        hike1.walkInTheTrail(1);

        //Checking the new elevation
        System.out.println(barrier);
        System.out.println("The Air Seems to be becoming much more thinner, winds become more powerful, what do you do?");
        hike1.checkCurrentElevation("currently 900 meters above sea level");

        //Continuing to walk
        System.out.println(barrier);
        System.out.println("You checked the current elevation which is being "+hike1.getCurrentElevation()+". What do you do now?");
        hike1.walkInTheTrail(1);

        //Final obstacle before the peak
        System.out.println(barrier);
        System.out.println("Here you are just a few more meters before the absolute peak of this mountain, but before you can reach" +
                           "\nthe absolute peak you found that there are is one big rope climb, that leads to a deadly ledge where one wrong step" +
                           "\ncan send you plumetting to your death, what do you do?");
        hike1.climbingRopes();
        System.out.println("I catch my breath and carefuly prepare to catch the ledge");
        hike1.climbingLedges(2);

        //Reached the peak
        System.out.println(barrier);
        System.out.println("You found yourself at the absolute peak. what do you do now>");
        hike1.checkCurrentElevation("Currently at the absolute Peak");

        //Noticed the kulangot in their pants
        System.out.println(barrier);
        System.out.println("You found a kulangot stuck in your pants what do you do?");
        hike1.flickHiddenKulangot();

        //Low coupling demo
        System.out.println("I grabbed new pair of pants and tshirt for a photo at top");
        Clothes_Obedoza newTshirt = new Clothes_Obedoza("Tshirt", "Medium", "White", 100);
        CargoPants_Caneda cargoPants2 = new CargoPants_Caneda("Cargo Pants", "Medium size", "Green", 1500.00, "Cotton Twill");

        System.out.println("I switched with my"+ cargoPants2.getClotheMaterial()+" and my new"+newTshirt.getClotheType()+" for the photo");


    }





}

