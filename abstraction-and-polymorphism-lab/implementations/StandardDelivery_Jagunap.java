package implementations;

import abstract_classes.Delivery_Cardeno;
import interfaces.DeliverySystem_Cardeno;
import components.DeliveryService_Jagunap;

/**
 * @author Jagunap, Janelle
 */
public class StandardDelivery_Jagunap extends Delivery_Cardeno
        implements DeliverySystem_Cardeno {

    // =========================
    // Attributes
    // =========================
    private boolean delivered;
    private boolean delayed;
    private int deliveryDays;

    // COMPONENT (composition)
    private DeliveryService_Jagunap service;

    // =========================
    // Constructors
    // =========================
    public StandardDelivery_Jagunap() {
        super("Standard Package", "Laguna", "Local Store", "Customer");
        this.deliveryDays = 5;
        this.delayed = false;
        this.delivered = false;
        this.service = new DeliveryService_Jagunap("Basic Handling", 50);
    }

    public StandardDelivery_Jagunap(String packageName, String destination,
                                    String senderName, String receiverName,
                                    int deliveryDays,
                                    DeliveryService_Jagunap service) {
        super(packageName, destination, senderName, receiverName);
        setDeliveryDays(deliveryDays);
        this.delayed = false;
        this.delivered = false;
        this.service = service;
    }

    // =========================
    // ABSTRACT CLASS OVERRIDES
    // =========================
    @Override
    public void deliver() {
        if (delivered) {
            System.out.println(getPackageName() + " was already delivered.");
            return;
        }

        service.applyService(this); // COMPONENT USE
        delivered = true;

        System.out.println(getPackageName()
                + " was delivered via standard shipping.");
    }

    @Override
    public void calculateETA() {
        if (delayed) {
            System.out.println("Delivery delayed. ETA extended to "
                    + (deliveryDays + 2) + " days.");
        } else {
            System.out.println("Estimated delivery time: "
                    + deliveryDays + " days.");
        }
    }

    // =========================
    // INTERFACE IMPLEMENTATION
    // =========================
    @Override
    public void confirmDelivery() {
        System.out.println(delivered
                ? "Standard delivery confirmed."
                : "Package still in transit.");
    }

    @Override
    public void updateStatus() {
        if (delivered) {
            System.out.println("Status: Delivered");
        } else if (delayed) {
            System.out.println("Status: Delayed");
        } else {
            System.out.println("Status: On the way");
        }
    }

    @Override
    public void cancelDelivery() {
        if (delivered) {
            System.out.println("Cannot cancel. Package already delivered.");
            return;
        }
        System.out.println("Standard delivery has been cancelled.");
    }

    @Override
    public void trackLocation() {
        System.out.println(getPackageName()
                + " is moving through standard routes to "
                + getDestination());
    }

    // =========================
    // Helper Method
    // =========================
    public void markDelayed() {
        delayed = true;
        System.out.println("Standard delivery marked as delayed.");
    }

    // =========================
    // Getters & Setters
    // =========================
    public void setDeliveryDays(int deliveryDays) {
        this.deliveryDays = deliveryDays > 0 ? deliveryDays : 5;
    }
}