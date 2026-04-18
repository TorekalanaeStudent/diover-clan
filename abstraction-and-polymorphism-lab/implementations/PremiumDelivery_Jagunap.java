package implementations;

import abstract_classes.Delivery_Cardeno;
import interfaces.DeliverySystem_Cardeno;
import components.DeliveryService_Jagunap;

/**
 * @author Jagunap, Janelle
 */
public class PremiumDelivery_Jagunap extends Delivery_Cardeno
        implements DeliverySystem_Cardeno {

    // =========================
    // Attributes
    // =========================
    private String courierName;
    private boolean insured;
    private boolean delivered;
    private boolean priority;

    // COMPONENT (composition)
    private DeliveryService_Jagunap service;

    // =========================
    // Constructors
    // =========================
    public PremiumDelivery_Jagunap() {
        super("Premium Parcel", "Cebu", "Company HQ", "VIP Client");
        this.courierName = "Elite Courier";
        this.insured = true;
        this.priority = true;
        this.delivered = false;
        this.service = new DeliveryService_Jagunap("Priority Insurance", 300);
    }

    public PremiumDelivery_Jagunap(String packageName, String destination,
                                   String senderName, String receiverName,
                                   String courierName, boolean insured,
                                   boolean priority,
                                   DeliveryService_Jagunap service) {
        super(packageName, destination, senderName, receiverName);
        this.courierName = courierName;
        this.insured = insured;
        this.priority = priority;
        this.delivered = false;
        this.service = service;
    }

    // =========================
    // ABSTRACT CLASS OVERRIDES
    // =========================
    @Override
    public void deliver() {
        if (delivered) {
            System.out.println(getPackageName() + " has already been delivered.");
            return;
        }

        service.applyService(this); // COMPONENT USE
        delivered = true;

        System.out.println("Premium delivery completed by "
                + courierName + " for " + getReceiverName());
    }

    @Override
    public void calculateETA() {
        System.out.println(priority
                ? "Estimated delivery time: 6 hours (PRIORITY)"
                : "Estimated delivery time: 24 hours");
    }

    // =========================
    // INTERFACE IMPLEMENTATION
    // =========================
    @Override
    public void confirmDelivery() {
        System.out.println(delivered
                ? "Premium delivery confirmed."
                : "Premium delivery in progress.");
    }

    @Override
    public void updateStatus() {
        System.out.println(delivered
                ? "Status: Delivered"
                : "Status: In Transit (Premium)");
    }

    @Override
    public void cancelDelivery() {
        if (delivered) {
            System.out.println("Cancellation failed. Package already delivered.");
            return;
        }
        System.out.println("Premium delivery cancelled.");
    }

    @Override
    public void trackLocation() {
        System.out.println(getPackageName()
                + " is being handled by " + courierName
                + " en route to " + getDestination());
    }
}