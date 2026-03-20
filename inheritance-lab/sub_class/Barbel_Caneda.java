package sub_class;

import parent_class.GymEquipment_Obedoza;

public class Barbel_Caneda extends GymEquipment_Obedoza{

//New Attribute
    String barbelType;
    String barbelMaterial;
    String barbelLenght;
    
//Costructor
    //default
    public Barbel_Caneda() {    
        super("Barbel Rod", "Eleiko", 22);
        this.barbelLenght = "86.6 inches";
        this.barbelType = "Technique";
        this.barbelMaterial = "Stainless Steel";
        this.setInUse(false);
    }
    //Paremeterized 
    public Barbel_Caneda(String equipmentName, String equipmentBrand, int equipmentWeight, String barbelType, String barbelMaterial, String barbelLenght, boolean inUse){
        super(equipmentName, equipmentBrand, equipmentWeight);
        this.barbelLenght = barbelLenght;
        this.barbelType = barbelType;
        this.barbelMaterial = barbelMaterial;
        this.setInUse(inUse);
    }
//Overrided methods
    @Override 
        public void startUse() {
        setInUse(true); 
         System.out.println(getEquipmentName()+ " is now being used.");
         System.out.println("Other barbels maybe available");
    }
    @Override 
        public void stopUse() {
        setInUse(false);
         System.out.println(getEquipmentName() + " is now available.");
         System.out.println("Please place back the "+getEquipmentName()+" to the "+barbelLenght+" section for others to use");

    }
    @Override 
        public void displayInfo(){
        super.displayInfo();
         System.out.println("Small Description Of" +getEquipmentName());
         System.out.println("The "+getEquipmentName()+" is a "+barbelType+ "made out of durable "+barbelMaterial+" for better performances ");
    }

//Unique Method
    public void placeBarbelBack() {
    if(!isInUse()){
      System.out.println("Please place back the "+getEquipmentName()+" to the "+barbelType+" section along side with the other "+barbelLenght+" Barbels");
    }
    else{
      System.out.println("Place it back after you are done");
    }
    }
}