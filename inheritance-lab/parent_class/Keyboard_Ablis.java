package parent_class;

public class Keyboard_Ablis {

    // keyboardd attributes
    private String keyboardBrand; // I used logitech, razor, and corsair
    private String keyboardType; // mechanical, gaming, and membrane
    private String connectionType; // bluetooth/wireless and wired/
    private boolean plugStatus; // plug in and out

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

    // getters
    public String getKeyboardBrand() {
        return keyboardBrand;
    }
    public String getKeyboardType() {
        return keyboardType;
    }
    public String getConnectionType() {
        return connectionType;
    }
    public boolean isPlugStatus() {
        return plugStatus;
    }

    // SETTERS
    public void setKeyboardBrand(String keyboardBrand) {
        this.keyboardBrand = keyboardBrand;
    }
    public void setKeyboardType(String keyboardType) {
        this.keyboardType = keyboardType;
    }
    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }
    public void setPlugStatus(boolean plugStatus) {
        this.plugStatus = plugStatus;
    }
    
    // BEHAVIOURS
    // behaviour #1: validate input
    public void checkKeyboardInput() {
        // check keyboard brand
        if (keyboardBrand.equals("Logitech") || keyboardBrand.equals("Razer") || keyboardBrand.equals("Corsair")) {
            System.out.println("Keyboard brand found.");
        } else {
            System.out.println("Keyboard brand cannot be found.");
        }
        // check connection type
        if (connectionType.equals("wired") || connectionType.equals("bluetooth") || connectionType.equals("wireless")) {
            System.out.println("Connection type is valid.");
        } else {
            System.out.println("Connection type is not valid.");
        }
    }

    // behaviour #2;
    public void checkKeyboardType() {
        if (keyboardType.equals("membrane") || keyboardType.equals("gaming") || keyboardType.equals("mechanical")) {
            System.out.println("Keyboard Type is valid");
        } else {
            System.out.println("Keyboard Type is invalid");
        }
    }
    
    // behaviour #3: check plug status
    public void checkPlugStatus() {
        if (plugStatus) {
            System.out.println("Keyboard is PLUGGED IN.");
        } else {
            System.out.println("Keyboard is PLUGGED OUT.");
        }
    }
}
