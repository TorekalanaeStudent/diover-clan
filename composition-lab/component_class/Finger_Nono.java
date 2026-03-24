package component_class;
public class Finger_Nono{
    private String name;
    private int length; // in mm
    private boolean isBent;

    public Finger_Nono(String name, int length) {
        this.name = name;
        setLength(length);
        this.isBent = false;
    }

    // =========================
    // GETTERS
    // =========================
    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public boolean isBent() {
        return isBent;
    }

    // =========================
    // SETTERS
    // =========================
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setLength(int length) {
        if (length > 0 && length < 200) { // validation
            this.length = length;
        }
    }

    // =========================
    // BEHAVIORS
    // =========================
    public void bend() {
        this.isBent = true;
        System.out.println(name + " is now bent.");
    }

    public void straighten() {
        this.isBent = false;
        System.out.println(name + " is now straight.");
    }
}