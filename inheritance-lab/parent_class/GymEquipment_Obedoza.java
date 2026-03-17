package parent_class;

public class GymEquipment_Obedoza{
    
    // Attributes
    private String equipmentName;
    private String equipmentBrand;
    private int equipmentWeight;
    private boolean inUse;

    // Constructor
    public GymEquipment_Obedoza(String equipmentName, String equipmentBrand, int equipmentWeight) {
        this.equipmentName = equipmentName;
        this.equipmentBrand = equipmentBrand;
        this.equipmentWeight = equipmentWeight;
        this.inUse = false;
    }

    // Getters
    public String getEquipmentName() {
        return equipmentName;
    }

    public String getEquipmentBrand() {
        return equipmentBrand;
    }

    public int getEquipmentWeight () {
        return equipmentWeight;
    }

    public boolean isInUse() {
        return inUse;
    }

    // Setters 
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public void setEquipmentBrand(String equipmentBrand) {
        this.equipmentBrand = equipmentBrand;
    }

    public void setEquipmentWeight(int equipmentWeight) {
        this.equipmentWeight = equipmentWeight;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    // Methods
    public void startUse() {
        inUse = true;
        System.out.println(equipmentName + " is now being used.");
    }

    public void stopUse() {
        inUse = false;
        System.out.println(equipmentName + " is now available.");
    }

    public void displayInfo(){
        System.out.println("===Equipment Status===");
        System.out.println("Name: " + equipmentName);
        System.out.println("Brand: " + equipmentBrand);
        System.out.println("Weight: " + equipmentWeight);
        System.out.println("Status: " + (inUse ? "In use." : "Available"));
    }
}