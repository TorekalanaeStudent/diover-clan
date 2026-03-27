package sub_class;

import component_class.Finger_Nono;

public class CrookedFinger_Obedoza extends Finger_Nono {

    private String injuryType;
    private boolean isInjured;

    // Default Constructor
    public CrookedFinger_Obedoza() {
        super("Index Finger", 70);
        this.injuryType = "Sprained";
        this.isInjured = true;
    }

    // Parameterized Constructor
    public CrookedFinger_Obedoza(String name, int length, String injuryType, boolean isInjured) {
        super(name, length);
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
    public void bend() {
        super.bend();
        System.out.println("=== Finger Status ===");
        System.out.println("Name: " + getName());
        System.out.println("Length: " + getLength() + " mm");
        System.out.println("Injury type: " + injuryType);
        System.out.println("Injury status: " + (isInjured ? "Recovering" : "Unrecovered"));
    }
}