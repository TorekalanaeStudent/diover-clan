package sub_class;

import component_class.Ilong_Onte;

public class CrookedNose_Obedoza extends Ilong_Onte {

    private String injuryType;
    private boolean isInjured;

    // Default Constructor
     public CrookedNose_Obedoza() {
        super("Crooked", "Flat", true);
        this.injuryType = "Punched";
        this.isInjured = true;
    }

    // Parameterized Constructor
    public CrookedNose_Obedoza(String shape, String size, boolean isClean, String injuryType, boolean isInjured) {
        super(shape, size, isClean);
        this.injuryType = injuryType;
        this.isInjured = isInjured;
    }

    // Setters & Getters
    public String getInjuryType() {
        return injuryType;
    }

    public boolean isInjured() {
        return isInjured;
    }

    public void setInjuryType(String injuryType) {
        this.injuryType = injuryType;
    }

    public void setInjured(boolean isInjured){
        this.isInjured = isInjured;
    }

    // Overridden Behavior
    @Override
    public void displayInfo() {
        System.out.println("=== Nose Status ===");
        System.out.println("Shape: " + getShape());
        System.out.println("Size: " + getSize());
        System.out.println("Injury type: "+ injuryType);
        System.out.println("Injury status: " + (isInjured ? "Recovering" : "Unrecovered"));
    }
}
    