package sub_class;

import parent_class.Gun_Go;

public class RifleGun_Canillo extends Gun_Go{
    
    private static int amountOfRifles;
    
    private int range;

    // Default constructor
    public RifleGun_Canillo(){
        super();

        // super attribute
        name = "M16";
        caliber = "5.56×45mm";
        capacity = 30;

        // riflegun_canillo attributes
        range = 500;
        amountOfRifles++;
    }

    // Parameterized constructor
    public RifleGun_Canillo(String name, String caliber, int capacity, int range){
        this.name = name;
        this.caliber = caliber;
        this.capacity = capacity;
        this.range = range;
        amountOfRifles++;
    }

    @Override
    public void shoot(){
        System.out.println(name + " shoots a precise shot of " + caliber + " at a distant target.");
    }

    public static void countRifle(){
        System.out.println("The amount of rifles is: " + amountOfRifles);
    }

}