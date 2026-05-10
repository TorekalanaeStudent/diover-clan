package sub_class;

import component_class.Earwax_Cardeno;

/**
 * Clearwax Cleaner removes or reduces earwax buildup
 * 
 * @author Jagunap
 */
public class EarwaxCleaner_Jagunap extends Earwax_Cardeno {

    private String cleanerType;

    public EarwaxCleaner_Jagunap() {
        super(40, "Yellow", "Sticky", true);
        setCleanerType();
    }

    public EarwaxCleaner_Jagunap(int amount, String color, String texture,
                                    boolean sticky, String cleanerType) {
        super(amount, color, texture, sticky);
        setCleanerType(cleanerType);
    }

    public String getCleanerType() {
        return cleanerType;
    }

    public void setCleanerType(String cleanerType) {
        this.cleanerType = (cleanerType == null || cleanerType.isBlank())
                ? "Drops"
                : cleanerType;
    }

    // Overloading (default cleaner type)
    public void setCleanerType() {
        this.cleanerType = "Drops";
    }

    //@Override
    public void showInfo() {
        super.showInfo();

        if (cleanerType.equalsIgnoreCase("Vacuum")) {
            System.out.println("Cleaner Type: Vacuum → Removes earwax very effectively.");
        } else if (cleanerType.equalsIgnoreCase("Spray")) {
            System.out.println("Cleaner Type: Spray → Moderately cleans earwax.");
        } else {
            System.out.println("Cleaner Type: Drops → Slowly softens earwax.");
        }
    }
}