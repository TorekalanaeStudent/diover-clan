package component_class;

// Subclass of Hands_Navarro
public class MagicHands_Malig extends Hands_Navarro {

    private boolean canCastSpells;

    public MagicHands_Malig(String skinTone, String handSize, boolean haveHands, boolean canCastSpells) {
        super(skinTone, handSize, haveHands);
        this.canCastSpells = canCastSpells;
    }

    public boolean canCastSpells() {
        return canCastSpells;
    }

    public void castSpell(String spellName) {
        if (hasHands() && canCastSpells) {
            System.out.println("Casting " + spellName + " with magical hands! ");
        } else {
            System.out.println("Cannot cast spell ");
        }
    }

    @Override
    public void pickingYourNose() {
        if (hasHands()) {
            System.out.println("Magical hands are delicately picking your nose with style! ");
        } else {
            System.out.println("No hands to perform magical nose picking.");
        }
    }
}