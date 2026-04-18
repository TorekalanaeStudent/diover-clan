package interfaces;

/** @author @flcardeno (Cardeno. Faye L.)
 */

public interface DeliverySystem_Cardeno {

    // abstract methods
    void confirmDelivery();
    void updateStatus();
    void cancelDelivery();
    void trackLocation();

    // default methods
    default void contactSupport() {
        System.out.println("Contacting delivery system support...");
        System.out.println("A representative will assist you shortly.");
    }
    default void openHelpCenter() {
        System.out.println("Opening help center for delivery issues...");
    }
    default void showTerms() {
        System.out.println("Displaying delivery system terms and conditions...");
    }
}