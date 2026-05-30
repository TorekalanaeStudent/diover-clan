package sub_class;

import parent_class.Gun_Go;

public class HandGun_Canillo extends Gun_Go{

    private static int amountOfHandgun;

    private int range;

    // Default constructor
    public HandGun_Canillo(){
        super();

        name = "Glock 17";
        caliber = "9x19mm";
        capacity = 17;

        range = 50;
        amountOfHandgun++;
    }

    // Parameterized constructor
    public HandGun_Canillo(String name, String caliber, int capacity, int range){
        this.name = name;
        this.caliber = caliber;
        this.capacity = capacity;
        this.range = range;
        amountOfHandgun++;
    }

    // GETTERS:
    public String getHandgunName(){
        return this.name;
    }

    public String getHandgunCaliber(){
        return this.caliber;
    }

    public int getHandgunCapacity(){
        return this.capacity;
    }

    public int getHandgunRange(){
        return this.range;
    }

    // SETTERS:
    public void setHandgunName(String newName){
        if(newName.isBlank())
            System.out.println("Handgun name can't be blank, name did not change.");
        else
            this.name = newName;
    }

    public void setHandgunCaliber(String newCalib){
        if(newCalib.isBlank())
            System.out.println("Handgun caliber can't be blank, caliber did not change.");
        else
            this.caliber = newCalib;
    }

    @Override
    public void shoot(){
        System.out.println(name + " shoots a precise shot of " + caliber + " at a decently close target.");
    }

    public static void countHandGun(){
        System.out.println("The amount of hand gun is: " + amountOfHandgun);
    }
}