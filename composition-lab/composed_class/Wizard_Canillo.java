package composed_class;

import component_class.Earwax_Cardeno;
import component_class.Kulangot;
import component_class.Tissue_Ovejera;

/** 
    @author @TorekalanaeStudent (Canillo, Diover Vincent L.)
*/

public class Wizard_Canillo{

    // Attributes
    private String wizardName;
    private boolean isFloating;
    private boolean ultCharged;

    private Earwax_Cardeno earwax;
    private Kulangot kulangot;
    private Tissue_Ovejera tissue;

    // DEFAULT CONSTRUCTOR
    public Wizard_Canillo(){
        wizardName = "Canillo"; // Obviously
        isFloating = false;
        earwax = new Earwax_Cardeno(100, "yellow-green", "flaky", true);
        kulangot = new Kulangot("dark-green", "huge", true);
        tissue = new Tissue_Ovejera("Puffs", 100, false);
    }

    // PARAMETERIZED CONSTRUCTOR
    public Wizard_Canillo(String name, boolean floating, Earwax_Cardeno earwax, Kulangot kulangot, Tissue_Ovejera tissue){
        this.wizardName = name;
        this.isFloating = floating;
        this.earwax = earwax;
        this.kulangot = kulangot;
        this.tissue = tissue;
    }

    // Getters & Setters
    public String getWizardName(){
        return this.wizardName;
    }

    public boolean isFloating(){
        return isFloating;
    }

    public boolean getUltCharge(){
        return ultCharged;
    }
    
    public Earwax_Cardeno getEarwax(){
        return this.earwax;
    }
    
    public Kulangot getKulangot(){
        return this.kulangot;
    }
    
    public Tissue_Ovejera getTissue(){
        return this.tissue;
    }

    public void setWizardName(String name){
        if(name.isBlank() || name == null){
            System.out.println("The wizard's name must have an input! Wizard name did not change!");
        } else{
            this.wizardName = name;
            System.out.println("Wizard's name was changed to: " + name + '!');
        }
    }

    public void setFloating(boolean floating){
        this.isFloating = floating;
    }

    public void setUltCharge(boolean charged){
        this.ultCharged = charged;
    }

    public void setEarwax(Earwax_Cardeno earwax){
        this.earwax = earwax;
    }
    
    public void setKulangot(Kulangot kulangot){
        this.kulangot = kulangot;
    }
    
    public void setTissue(Tissue_Ovejera tissue){
        this.tissue = tissue;
    }

    public void castKulangotTypeSpell(String spellName){
        if(isFloating){
            System.out.println(wizardName + " casts " + spellName + " while flying!"
            + "\nFlying causes the kulangot type spell to gain an additional speed of 25% making it a fire ball of " + spellName + '!');
        } else{
            System.out.println(wizardName + " casts " + spellName + " on the ground!");
        }
    }

    public void castEarwaxTypeSpell(String spellName){
        if(isFloating){
            System.out.println(wizardName + " casts earwax type " + spellName + " while flying!"
            + "\nFlying causes the earwax type spell to absorb attacks and spreads evenly acting as an AOE attack!"
            + "\nMultiple enemies hit! They've been slowed down by 25%!");
        } else{
            System.out.println(wizardName + " casts earwax type" + spellName + " on the ground!"
            + "\nEnemy Hit! The enemy has been slowed by 25%!");
        }
    }

    public void castDefendSpell(){
        System.out.println(wizardName + " uses their defend spell: Tissues!");

        int absorbedDmg = tissue.getSheetCount() / 2;
        System.out.println("The shield absorbs " + absorbedDmg + "points of Damage!");

        tissue.useTissue(1);
    }

    public void chargeCombinedSpell(){
        if(!isFloating){
            System.out.println("Combining Earwax and Kulangot..!" +
            "\nAs the earwax and kulangot merge, they form the imaginary technique " +
            "\"Sticky Toxic Vertex\"!" +
            "\nA swirling, " + kulangot.getColor() + "-and-" + earwax.getColor() + " of sticky, toxic and infinitely densed energy forms " +
            "behind the wizard pulsating with deadly vortex force.");
        } else{
            System.out.println("Combining Air Variant of Earwax and Kulangot..!" +
            "\nHigh above the earwax and kulangot merge, they form the ultimate imaginary technique " +
            "\"Sticky Toxic Nuke\"!" +
            "\nA spell so powerful that even rivals with Satoru Gojo! A still, immersing " + kulangot.getColor() + "-and-" + earwax.getColor() +
            " of pure toxic, stickyness and infinitely densed\nenergy forms above the sky pulsating with every second..");
        }
        ultCharged = true;
    }

    public void castCombinedSpell(){
        if(!ultCharged){
            System.out.println("Ultimate attack has not been charged yet.. Charging now!");
            chargeCombinedSpell();
            return; // stops here 
        }

        if(!isFloating){
            System.out.println("The wizard " + wizardName + " aims the spell into multiple enemies.. and unleashes the spell..!!" +
            "\nMULTIPLE ENEMIES OBLITERATED!!!" +
            "\nThe Sticky Toxic Vortex rushes with such speed and unimaginable force," +
            "\nleaving not a single atom of the enemies behind!");
        } else{
            System.out.println("The wizard " + wizardName + " recited an incantation that boosts the \n" +
            "omnidirectional \"Sticky Toxic Nuke\" by 200%!!.. and released it.!!\n" +
            "A LARGE AOE ATTACK THAT OBLITERATES EVERY LIVING ORGANISM WITHIN A RANGE OF 4 KILOMETERS!!\n" +
            "");
        }
    }
}