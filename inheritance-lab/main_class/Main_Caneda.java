package main_class;

import sub_class.Barbel_Caneda;
import sub_class.EllipticalBike_Caneda;
import parent_class.GymEquipment_Obedoza;

public class Main_Caneda {

    public static void main(String[] args){
        System.out.println("First Subclass: ");

    //this is the is-a object because Barbel_Caneda is a child class or type of GymEquipment_Obedoza
    Barbel_Caneda Barbel = new Barbel_Caneda();
    
    //methods that came from GymEquipment_Obedoza are:
    // startUse(), stopUse(), displayInfo()

    //startUse was overidden
    Barbel.startUse(); 
    
    //calls the method in subclass Barbel_Caneda and not the one from the parent class GymEquipment_Obedoza
    Barbel.stopUse();

    //showing all info
    Barbel.displayInfo();

    //spacing
    System.out.println();
    
    //Using Paremeterized Method
    Barbel_Caneda Barbel2 = new Barbel_Caneda("Barbel Rod", "Eleiko", 11, "Ez curl bar", "Stainless Steel", "48 inches", true );

    //for validation logic in next line
    Barbel2.stopUse();

    //new behaviors from subclass is placeBarbelBack()
    Barbel2.placeBarbelBack();

    //showing all info
    Barbel2.displayInfo();

    //spacing
    System.out.println();

         System.out.println("Second Subclass: ");

    //this is the is-a object because EllipticalBike_Caneda is a child class or type of GymEquipment_Obedoza
    EllipticalBike_Caneda elipticalBike = new EllipticalBike_Caneda();

    //methods that came from GymEquipment_Obedoza are:
    // startUse(), stopUse(), displayInfo()

    //startUse was overidden
    elipticalBike.startUse(); 

    //calls the method in subclass EllipticalBike_Caneda and not the one from the parent class GymEquipment_Obedoza
    elipticalBike.stopUse(); 

    //showing all info
    elipticalBike.displayInfo();

    //spacing
    System.out.println();

    //Using Paremeterized Method
    EllipticalBike_Caneda elipticalBike1 = new EllipticalBike_Caneda("Sole E20", "Sole", 150, "Stainless Steel", "Heavy Resistance", true, true );
    
    //new behaviors from subclass is checkIfBikeIsOiledUp()
    elipticalBike1.checkIfBikeIsOiledUp();

    //showing all info
    elipticalBike1.displayInfo();

    //questions and answers
    // - What is the **IS-A relationship** in your program? 
    //  the follow IS-A relationship are:
    //      *Barbel_Caneda
    //      *ellipticalBike_Caneda                        
    //  Because both are subclasses of GymEquipment_Obedoza
    //
    // - Which method was **overridden**? 
    //  the following methods that were overridden are: 
    //      *startUse()
    //      *stopUse()
    //      *displayInfo()
    // 
    // - What happens during **dynamic binding**?                         
    //  *dynamic binding essentially tells when the main class picks and selects which method to run and which sequence it runs
    // 
    // - What methods were **inherited from the parent class**?
    //  the following method that were inherited:
    //      *getEquipmentName()
    //      *getEquipmentBrand()
    //      *getEquipmentWeight()
    //      *isInUse()
    //      *setEquipmentName()
    //      *setEquipmentBrand()
    //      *setEquipmentWeight()
    //      *setInUse()
    // - What new behavior did the subclass introduce? 
    //  the following new behaviors that were inherited:
    //      *placeBarbelBack();
    //      *isMachineOiledUP();



    }

}