package sub_class;

import component_class.Handkerchief_Gedoria;

// subclass of Handkerchief_Gedoria
public class AuraHandkerchief_Go extends Handkerchief_Gedoria {

    private String pattern;
    private String scent;

    // Constructor(Default)
    public AuraHandkerchief_Go() {
        super("Purple", "Small", false);  // default color, size, isUsed
        this.pattern = "starry embroidery";
        this.scent = "lavender scent";
    }

    // Parameterized constructor
    public AuraHandkerchief_Go(String color, String size, boolean isUsed, String pattern, String scent) {
        super(color, size, isUsed);
        this.pattern = pattern;
        this.scent = scent;
    }

    // Override describe for extra flair
    @Override
    public void description() {
        System.out.println("A " + getSize() + " " + getColor() +
            " handkerchief, patterned with " + pattern + ", " +
            (isUsed() ? "freshly folded like a lotus, exuding " + scent + "." 
                     : "slightly worn but stylish, carrying a faint " + scent + " aroma."));
    }

    // New method: dramatic action
    public void flutter() {
        System.out.println("The handkerchief flutters aurafully, revealing its " + pattern + " aura in motion!");
    }
}