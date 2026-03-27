package sub_class;

import component_class.Hands_Navarro;

public class TapeGrip_Ablis extends Hands_Navarro {
    // attributes
    private String tapeType; // type of tape used for grip; Loop, Wide, or Self-grip

    // default constructor
    public TapeGrip_Ablis() {
        super("Default", "Medium", true); // call parent constructor with default values
        setTapeType("Loop"); // default tape type
    }

    // parameterized constructor
    public TapeGrip_Ablis(String skinTone, String handSize, boolean haveHands, String tapeType) {
        super(skinTone, handSize, haveHands); // call parent constructor
        setTapeType(tapeType);
    }

    // getter
    public String getTapeType() {
        return tapeType;
    }

    // setter - operators || are used to validate tape type input
    public void setTapeType(String tapeType) {
        if (tapeType.equals("Loop") || tapeType.equals("Wide") || tapeType.equals("Self-grip")) {
            this.tapeType = tapeType;
        } else {
            this.tapeType = "This Tape Type is not advisable"; // invalid input
        }
    }
    
    // overloading
    public void setTapeType() {
        this.tapeType = "Loop"; // default tape type
    }

    public void useHand() {
        if (hasHands()) {
            System.out.println("Using " + tapeType + " tape grip with " + getHandSize() + " hands of skin tone " + getSkinTone() + ".");
        } else {
            System.out.println("Cannot use tape grip because there are no hands available.");
        }
    }
}
