package sub_class;

import component_class.Finger_Nono;

public class TapeGrip_Ablis extends Finger_Nono {
    // attributes
    private String tapeType; // type of tape used for grip; Loop, Wide, or Self-grip

    // default constructor
    public TapeGrip_Ablis() {
        super("Default Finger", 75); // call parent constructor with default values
        setTapeType("Loop"); // default tape type
    }

    // parameterized constructor
    public TapeGrip_Ablis(String name, int length, String tapeType) {
        super(name, length); // call parent constructor
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

    public void useFinger() {
       if (getLength() > 0 && getLength() < 200) { // validate finger length  
            System.out.println(getName() + " is using their " + tapeType + " tape grip on their finger of length " + getLength() + "mm.");
        } else {
            System.out.println(getName() + " cannot use their tape grip because the finger length is invalid.");
        }
    }
}
