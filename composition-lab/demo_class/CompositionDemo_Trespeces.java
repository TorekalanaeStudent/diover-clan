package demo_class;

import component_class.Clothes_Obedoza;
import component_class.Gun_Magazine_Go;
import component_class.Kulangot;
import composed_class.Soldier_Trespeces;

public class CompositionDemo_Trespeces {
 
    public static void main(String[] args) {    

        System.out.println("================================================");
        System.out.println("\nSoldier Composition DEMO\n");
 
        // component classes 
        System.out.println("Component Classes Used:");
        System.out.println("Clothes_Obedoza, Gun_Magazine_Go by Seth Go, Kulangot\n");
 
        // create components
        Clothes_Obedoza uniform = new Clothes_Obedoza("black suit", "large", "black", 490.00);
        Gun_Magazine_Go magazine = new Gun_Magazine_Go("9mm rounds", 10);
        Kulangot kulangot = new Kulangot("green", "medium", true);
 
        // soldier composition
        Soldier_Trespeces soldier = new Soldier_Trespeces(
                "John Wick", true, true, uniform, magazine, kulangot);
 
        String name = soldier.getSoldierName();
 
        System.out.println("=== " + name + " is deployed to the battlefield ===");
        soldier.checkClothes();
        System.out.println(" ");
 
        System.out.println("=== Enemies spotted! " + name + " opens fire! ===");
        soldier.shoot();
        soldier.shoot();
        soldier.shoot();
        System.out.println(" ");
 
        System.out.println("=== After the carnage, " + name + " needs the protein ===");
        soldier.eat();
        System.out.println(" ");
 
        System.out.println("=================");
        System.out.println("  SOLDIER DOWN   ");
        System.out.println("=================\n");
 
        System.out.println("=== " + name + " takes a fatal hit! Noooooo! ===");
        soldier.die();
        System.out.println(" ");

        System.out.println("=== " + name+ " tried to 50v1 the enemy ===");
        System.out.println(" ");
 
        System.out.println("====================");
        System.out.println("  SOLDIER RESPAWNED ");
        System.out.println("====================\n");
        
        System.out.println("=== " + name + " respawns with full boolets! ===");
        soldier.respawn();
        System.out.println(" ");
 
        System.out.println("=== Back in action! " + name + " strikes again! ===");
        soldier.shoot();
        soldier.shoot();
        System.out.println(" ");
 
        System.out.println("=== Low Coupling DEMO ===\n");

 
        // swapping uniform
        Clothes_Obedoza newUniform = new Clothes_Obedoza("plain white shirt", "medium", "white", 299.00);
        soldier.setClothes(newUniform);
        System.out.println(name + " now wears a different uniform:");
        soldier.checkClothes();
        System.out.println(" ");
 
        // swapping magazine
        Gun_Magazine_Go heavyMag = new Gun_Magazine_Go("big boolets", 25);
        soldier.setGunMagazine(heavyMag);
        System.out.println(name + " now uses a different type of magazine.");
        soldier.shoot();
        System.out.println(" ");
 
        // swapping kulangot
        Kulangot newKulangot = new Kulangot("dark green", "extra large", false);
        soldier.setKulangot(newKulangot);
        System.out.println(name + " now has a different kulangot supply:");
        soldier.eat();
        System.out.println(" ");
 
        System.out.println("- Soldier still works after all swaps, LOW COUPLING confirmed!\n");
 
        System.out.println("=== Soldier DEMO Complete! ===");
        System.out.println("================================================");
    }
}

/**
 ------------------
 Composition Demo
 @author: Trespeces
 ------------------
 Design Analysis

1. What are the HAS-A relationships?
 - Soldier_Trespeces HAS-A Clothes_Obedoza - the soldier needs a uniform to wear in battle.
 - Soldier_Trespeces HAS-A Gun_Magazine_Go - the soldier needs a magazine to fire his weapon.
 - Soldier_Trespeces HAS-A Kulangot - the soldier needs kulangot for protein in the field.

2. Which classes were reused?
 - 'Clothes_Obedoza' made by Obedoza, 'Gun_Magazine_Go' made by Go, and Kulangot.
 - None of these classes were modified internally to make the soldier work.

3. How does composition reduce coupling?
 - In the demo, the soldier's uniform, magazine, and kulangot were all swapped out individually.
 - The Soldier_Trespeces class did not need to be changed at all despite the component changes.

4. How did you implement high cohesion?
 - Clothes_Obedoza only handles clothing-related behavior like describing the outfit.
 - Gun_Magazine_Go only handles ammo and firing of the weapon.
 - Kulangot only handles kulangot-related behavior like color, size, and stickiness.

5. How is cohesion maintained?
 - Soldier_Trespeces only handles soldier behavior — shooting, eating, dying, and respawning.
 - It delegates everything else to its components instead of doing it all itself.

6. Why is inheritance NOT appropriate here?
 - A soldier is not a type of clothes, magazine, or kulangot — so IS-A does not apply.
 - Using inheritance would mean the soldier would be stuck with one fixed set of behaviors.
 - Composition allows the soldier's parts to be swapped freely, which inheritance cannot do.
 */