package sub_class;

import component_class.Finger_Nono;

/** 
    @author @flcardeno (Cardeño, Faye L.)
    Thumb_Cardeno is a subclass of Finger_Nono
*/

public class Thumb_Cardeno extends Finger_Nono {

    private int strength; // thumb strength is from 1 to 100

    // default constructor
    public Thumb_Cardeno() {
        super("Faye's Thumb", 70);
        this.strength = 80; // default strong thumb
    }

    // parameterized constructor
    public Thumb_Cardeno(String name, int length, int strength) {
        super(name, length);
        setStrength(strength);
    }

    // getter
    public int getStrength() {
        return strength;
    }

    // setter
    public void setStrength(int strength) {
        if (strength >= 0 && strength <= 100) { // validation
            this.strength = strength;
        }
    }

    // overridden behaviors
    @Override
    public void bend() {
        System.out.println(getName() + " is bending carefully.");
        super.bend();
    }
    @Override
    public void straighten() {
        System.out.println(getName() + " is straightening smoothly.");
        super.straighten();
    }

    // extra behavior for thumbs
    public void grip() {
        System.out.println(getName() + " is gripping with strength " + strength + ".");
    }
}