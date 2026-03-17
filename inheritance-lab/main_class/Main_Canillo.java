package main_class;

import sub_class.RifleGun_Canillo;
import sub_class.HandGun_Canillo;
import parent_class.Gun_Go;

public class Main_Canillo {

    public static void main(String[] args) {

        System.out.println("First Subclass");

        Gun_Go rifle1 = new RifleGun_Canillo(); // this line of code is the is-a because riflegun_canillo is a type of gun_go class
        rifle1.shoot(); // shoot was overriden
        rifle1.reload(); // calls riflegun_canillo's method of shoto and not gun_go's shoot

        // methods that were inherited from the parent class were
        // shoot and reload

        System.out.println();

        Gun_Go rifle2 = new RifleGun_Canillo("Dragunov", "7.62×54mmR", 10, 800);
        rifle2.shoot();
        rifle2.reload();

        // new behavior from subclass is countRifle() 
        RifleGun_Canillo.countRifle();

        System.out.println(); // spacer
        // SECOND SUBCLASS
        System.out.println("Second Subclass");

        HandGun_Canillo hg1 = new HandGun_Canillo(); // this line of code is-a because handgun_canillo is a type of gun_go class too
        hg1.shoot(); // overriden again
        hg1.reload();

        hg1.setHandgunName(""); // rule validation example

        System.out.println("Name: " + hg1.getHandgunName()); // calls riflegun_canillo's method of getHandgunName + these are new methods
        System.out.println("Caliber: " + hg1.getHandgunCaliber());
        System.out.println("Capacity: " + hg1.getHandgunCapacity());
        System.out.println("Range: " + hg1.getHandgunRange());

        System.out.println(); // spacer

        HandGun_Canillo hg2 = new HandGun_Canillo("Glock 19", "9x19mm", 15, 50);

        hg2.setHandgunName("Canillo's Glock 19");

        System.out.println("Name: " + hg2.getHandgunName());
        System.out.println("Caliber: " + hg2.getHandgunCaliber());
        System.out.println("Capacity: " + hg2.getHandgunCapacity());
        System.out.println("Range: " + hg2.getHandgunRange());

    }
}