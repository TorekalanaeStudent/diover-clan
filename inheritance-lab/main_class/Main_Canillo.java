package main_class;

import sub_class.RifleGun_Canillo;
import parent_class.Gun_Go;

public class Main_Canillo {

    public static void main(String[] args) {

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

    }
}