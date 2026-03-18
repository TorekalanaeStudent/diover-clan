package parent_class;
/*
 > Keyboard Parent Class
 > this class was made by Ablis, Margreleigne 
 */

public class Keyboard_Ablis {

    // keyboard attributes
    protected String keyboardBrand;
    protected String keyboardType; // Mechanical, Membrane, etc.
    protected String connectionType; // Wired or Wireless
    protected boolean plugStatus;

    // default Constructor
    public Keyboard_Ablis() {
        keyboardBrand = "NA";
        keyboardType= "NA";
        connectionType = "NA";
        plugStatus= false;
    }

    // parameterized constructor
    public Keyboard_Ablis(String keyboardBrand, String keyboardType, String connectionType, boolean plugStatus) {
        this.keyboardBrand = keyboardBrand;
        this.keyboardType = keyboardType;
        this.connectionType = connectionType;
        this.plugStatus = plugStatus;
    }

    //   ehaviors
    // behavior #1: Validate Inputs
    public void checkKeyboardInputs() {

        // Check keyboardBrand
        if (keyboardBrand == null) {
            System.out.println("Keyboard has no brand");
        } else {
            System.out.println("Keyboard brand done");
        }

        // Check keyboardType
        if (keyboardType == null) {
            System.out.println("Keyboard type is not specified");
        } else {
            System.out.println("Keyboard type done");
          }
        }

        // Check connection type
        if (connectionType == null) {
            System.out.println("No connection type specified");
        } else {
            System.out.println("Connection type done");
        }
    }

    // Behavior 2: Check Plug Status
    public void checkPlugStatus() {
        if (plugStatus == false) {
            System.out.println("Keyboard is PLUGGED OFF");
        } else {
            System.out.println("Keyboard is PLUGGED IN");
        }
    }
}