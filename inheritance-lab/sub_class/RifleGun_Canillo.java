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
        caliber = "5.56x45mm";
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

    // GETTERS:
    public String getRifleName(){
        return this.name;
    }

    public String getRifleCaliber(){
        return this.caliber;
    }

    public int getRifleCapacity(){
        return this.capacity;
    }

    public int getRifleRange(){
        return this.range;
    }

    // SETTERS:
    public void setRifleName(String newName){
        if(newName.isBlank())
            System.out.println("Rifle name can't be blank, name did not change.");
        else
            this.name = newName;
    }

    public void setRifleCaliber(String newCalib){
        if(newCalib.isBlank())
            System.out.println("Rifle caliber can't be blank, caliber did not change.");
        else
            this.caliber = newCalib;
    }

    // behaviors with override
    @Override
    public void shoot(){
        System.out.println(name + " shoots a precise shot of " + caliber + " at a distant target.");
    }

    public static void countRifle(){
        System.out.println("The amount of rifles is: " + amountOfRifles);
    }

}