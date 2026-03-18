package parent_class;

public class Keyboard_Ablis {

    // kb attrqibutes
    protected String keyboardBrand;
    protected String keyboardType;
    protected String connectionType;
    protected boolean plugStatus;

    // default constructor
    public Keyboard_Ablis() {
        this.keyboardBrand = "N/A";
        this.keyboardType = "N/A";
        this.connectionType = "N/A";
        this.plugStatus = false;
    }

    // parameterized constructor
    public Keyboard_Ablis(String keyboardBrand, String keyboardType, String connectionType, boolean plugStatus) {
        this.keyboardBrand = keyboardBrand;
        this.keyboardType = keyboardType;
        this.connectionType = connectionType;
        this.plugStatus = plugStatus;
    }

    // behaviour #1: validate input
    public void checkKeyboardInput() {
        // check keyboard brand (fixed swapped messages)
        if (keyboardBrand.equals("Logitech") || keyboardBrand.equals("Razer") || keyboardBrand.equals("Corsair")) {
            System.out.println("Keyboard brand found.");
        } else {
            System.out.println("Keyboard brand cannot be found.");
        }

        // check connection type (moved inside the method)
        if (connectionType.equals("wired") || connectionType.equals("wireless")) {
            System.out.println("Connection type is valid.");
        } else {
            System.out.println("Connection type is not valid.");
        }
    }

    // behaviour #2: check plug status
    public void checkPlugStatus() {
        if (plugStatus == true) {
            System.out.println("Keyboard is PLUGGED IN.");
        } else {
            System.out.println("Keyboard is PLUGGED OUT.");
        }
    }

    public static void main(String[] args) {
        Keyboard_Ablis kb = new Keyboard_Ablis("Logitech", "mechanical", "wired", true);
        kb.checkKeyboardInput();
        kb.checkPlugStatus();
    }
}