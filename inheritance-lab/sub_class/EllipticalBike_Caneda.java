package sub_class;

import parent_class.GymEquipment_Obedoza;

public class EllipticalBike_Caneda extends GymEquipment_Obedoza{

//new attributes
    String ellipticalBikeMaterial;
    String resistanceLevel;
    boolean isMachineOiledUp;

//Constructors
    //default
    public EllipticalBike_Caneda() {
        super("NordicTrack FS14", "NordicTrack", 130);
        this.ellipticalBikeMaterial = "Stainless Steel";
        this.resistanceLevel = "Medium Resistance";
        this.isMachineOiledUp = false;
        this.setInUse(false);
    }
    //paremeteried
     public EllipticalBike_Caneda(String equipmentName, String equipmentBrand, int equipmentWeight, String ellipticalBikeMaterial, String resistanceLevel, boolean isMachineOiledUp, boolean isInUse) {
        super(equipmentName, equipmentBrand, equipmentWeight);
        this.ellipticalBikeMaterial = ellipticalBikeMaterial;
        this.resistanceLevel = resistanceLevel;
        this.isMachineOiledUp = isMachineOiledUp;
        this.setInUse(false);
    }
//Overrided methods
    @Override 
        public void startUse() {
        setInUse(true); 
         System.out.println(getEquipmentName()+ " is now being used.");
         System.out.println("Other Elliptical Bikes maybe available");
    }
    @Override 
        public void stopUse() {
        setInUse(false);
         System.out.println(getEquipmentName() + " is now available.");
         System.out.println("Please wipe the seat first before using "+getEquipmentName());
    }
    @Override 
        public void displayInfo(){
        super.displayInfo();
         System.out.println("Small Description Of" +getEquipmentName());
         System.out.println("The "+getEquipmentName()+" is a made out of durable "+ellipticalBikeMaterial+" for better performances to withstand long sessions");
    }
//Unique Method
    public void checkIfBikeIsOiledUp() {
        if(isMachineOiledUp) {
            System.out.println("Elliptical Bike Is ready To go!");
        }
        else {
            System.out.println("Consult Gym Maintenace Worker To oil the bike");
        }
    }
}
