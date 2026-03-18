package parent_class;

public class Keyboard_Ablis {
    public static void main(String[] args) {

        //keyboard attribute
        protected String keyboardBrand;
        protected String keyboardType; // mechanical, membrane, scissor switch
        protected String connectionType; // wired, wireless
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
        // behaviour method
        // behaviour #1: validate input
        public void checkKeyboardInput() {
            // check keyboard brand
            if (keyboardBrand.equals("Logitech") || keyboardBrand.equals("Razer") || keyboardBrand.equals("Corsair")) {
                system.out.println("Keyboard brand cannot be found.");
            } else {
                system.out.println("Keyboard brand found.");
            }
        }
        // check connection type
        if connectionType.equals("wired") || connectionType.equals("wireless")) {
            system.out.println("Connection type is valid.");
        } else {
            system.out.println("Connection type is not valid.");
        }

        // behaviour #2: check plug status
        public void checkPlugStatus() {
            if (plugStatus == true) {
                system.out.println("Keyboard is PLUGGED IN.");
            } else {
                system.out.println("Keyboard is PLUGGED OUT.");
            }
        }
    }
}