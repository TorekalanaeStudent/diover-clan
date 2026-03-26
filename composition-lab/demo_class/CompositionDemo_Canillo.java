package composed_class;

import component_class.Earwax_Cardeno;
import component_class.Kulangot;
import component_class.Tissue_Ovejera;
import sub_class.PaperTowel_Canillo;

/**
 * Wizard Composition Demo
 * @author: @TorekalanaeStudent (Canillo, Diover Vincent L.)
 */
public class CompositionDemo_Canillo {

    public static void main(String[] args) {

        String barrier = "================================================";

        System.out.println(barrier + "\nWIZARD COMPOSITION DEMO\n" + barrier + "\n");

        // Component classes
        System.out.println("Component Classes Used:");
        System.out.println("Earwax_Cardeno, Kulangot, Tissue_Ovejera / PaperTowel_Canillo\n");

        // Create components
        Earwax_Cardeno earwax = new Earwax_Cardeno(100, "yellow-green", "flaky", true);
        Kulangot kulangot = new Kulangot("dark-green", "huge", true);
        PaperTowel_Canillo paperTowel = new PaperTowel_Canillo(); // child of Tissue_Ovejera

        // Wizard composition
        Wizard_Canillo wizard1 = new Wizard_Canillo("Canillo", false, earwax, kulangot, paperTowel);

        // Variable: name
        String wizardName = wizard1.getWizardName();

        System.out.println("=== Multiple enemies are attacking the wizard ===");
        System.out.println("Enemies are charging from all directions!\n");

        // Wizard defend spell
        System.out.println("=== " + wizardName + " casts DEFEND SPELL! ===");
        wizard1.castDefendSpell();
        System.out.println(" ");

        System.out.println(barrier);
        System.out.println("NONE FLOATING WIZARD");
        System.out.println(barrier);
        System.out.println(" ");

        // Attacking with earwax spell
        System.out.println("=== " + wizardName + " unleashes Earwax type attack ===");
        wizard1.castEarwaxTypeSpell("Sticky Slime Barrage");
        System.out.println(" ");

        // Attacking with kulangot stuff type spell
        System.out.println("=== " + wizardName + " uses Kulangot type attack ===");
        wizard1.castKulangotTypeSpell("Flying Green Spear");
        System.out.println(" ");

        // Hollow purple bootleg charge
        System.out.println("=== " + wizardName + " charges COMBINED SPELL ===");
        wizard1.chargeCombinedSpell();
        System.out.println(" ");

        // Casting hollow purple bootleg
        System.out.println("=== " + wizardName + " unleashes COMBINED ULTIMATE SPELL ===");
        wizard1.castCombinedSpell();
        System.out.println(" ");

        System.out.println(barrier);
        System.out.println("FLOATING WIZARD");
        System.out.println(barrier);
        System.out.println(" ");

        wizard1.setFloating(true);

        // Attacking with earwax spell - AIR VARIANT
        System.out.println("=== " + wizardName + " unleashes Earwax type attack ===");
        wizard1.castEarwaxTypeSpell("Sticky Slime Barrage");
        System.out.println(" ");

        // Attacking with kulangot stuff type spell - AIR VARIANT
        System.out.println("=== " + wizardName + " uses Kulangot type attack ===");
        wizard1.castKulangotTypeSpell("Flying Green Spear");
        System.out.println(" ");

        // Hollow purple bootleg charge - AIR VARIANT
        System.out.println("=== " + wizardName + " charges COMBINED SPELL ===");
        wizard1.chargeCombinedSpell();
        System.out.println(" ");

        // Casting hollow purple bootleg - AIR VARIANT
        System.out.println("=== " + wizardName + " unleashes COMBINED ULTIMATE SPELL ===");
        wizard1.castCombinedSpell();

        // LOW COUPLING demo
        System.out.println(barrier);
        System.out.println("LOW COUPLING DEMO: SWAPPING THE TISSUE COMPONENT");
        System.out.println(barrier + "\n");

        // swapping the tissue with the parent class of papertowel_canillo which shows no error at all
        // which means low coupling is undeniably present! (wow big word for me)
        Tissue_Ovejera basicTissue = new Tissue_Ovejera("Puffs", 50, false);
        wizard1.setTissue(basicTissue);

        System.out.println(wizardName + " now uses basic tissue shield instead of paper towel:");
        wizard1.castDefendSpell();
        System.out.println(" ");

        System.out.println("=== Wizard demo complete! ===");
        System.out.println(barrier);
    }
}