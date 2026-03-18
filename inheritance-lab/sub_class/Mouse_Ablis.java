package sub_class;

import parent_class.Keyboard_Ablis;

public class Mouse_Ablis extends Keyboard_Ablis {
// mouse attributes
    private String mouseBrand;
    private String mouseType;
    private int mouseDPI;
    private boolean clickStatus;

    // default constructor
    public Mouse_Ablis() {
        super();
        this.mouseBrand = "N/A";
        this.mouseType = "N/A";
        this.mouseDPI = 0;
        this.clickStatus = false;
    }

    // parameterized constructor
    public Mouse_Ablis(String keyboardBrand, String keyboardType, String connectionType, boolean plugStatus,
                       String mouseBrand, String mouseType, int mouseDPI, boolean clickStatus) {
        super(keyboardBrand, keyboardType, connectionType, plugStatus);
        this.mouseBrand = mouseBrand; // i used known brands
        this.mouseType = mouseType; // bluetooth/wireless or wired
        this.mouseDPI = mouseDPI; // cursor speed and mouse sensitivity
        this.clickStatus = clickStatus; // if mouse buttons are working
    }

    // behaviour #1: validating mouse input
    public void checkMouseInput() {
        // check mouse brand
        if (mouseBrand.equals("Logitech") || mouseBrand.equals("Razer") || mouseBrand.equals("Corsair")) {
            System.out.println("Mouse brand found.");
        } else {
            System.out.println("Mouse brand cannot be found.");
        }

        // check mouse type
        if (mouseType.equals("gaming") || mouseType.equals("office") || mouseType.equals("trackball")) {
            System.out.println("Mouse type is valid.");
        } else {
            System.out.println("Mouse type is not valid.");
        }
    }

    // behaviour #2: check click status
    public void checkClickStatus() {
        if (clickStatus == true) {
            System.out.println("Mouse CAN CLICK.");
        } else {
            System.out.println("Mouse CANNOT CLICK.");
        }
    }

    // behaviour #3: check DPI level
    public void checkDPILevel() {
        if (mouseDPI >= 1600) {
            System.out.println("DPI Level: HIGH (" + mouseDPI + ")");
        } else if (mouseDPI >= 800) {
            System.out.println("DPI Level: MEDIUM (" + mouseDPI + ")");
        } else {
            System.out.println("DPI Level: LOW (" + mouseDPI + ")");
        }
    }

    public static void main(String[] args) {
        Mouse_Ablis mouse = new Mouse_Ablis(
            "Logitech", "mechanical", "wired", true,
            "Razer", "gaming", 3200, true);

        //  behaviours from Keyboard_Ablis
        mouse.checkKeyboardInput();
        mouse.checkPlugStatus();

        // mouse behaviours
        mouse.checkMouseInput();
        mouse.checkClickStatus();
        mouse.checkDPILevel();


    }
}