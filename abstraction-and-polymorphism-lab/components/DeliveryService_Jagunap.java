package components;

import abstract_classes.Delivery_Cardeno;

/**
 * Component class for delivery-related services.
 * Demonstrates composition.
 * @author Jagunap, Janelle
 */
public class DeliveryService_Jagunap {

    // =========================
    // Attributes
    // =========================
    private String serviceName;
    private int serviceFee;

    // =========================
    // Constructor
    // =========================
    public DeliveryService_Jagunap(String serviceName, int serviceFee) {
        this.serviceName = serviceName;
        this.serviceFee = serviceFee;
    }

    // =========================
    // Behavior
    // =========================
    public void applyService(Delivery_Cardeno delivery) {
        System.out.println(
            "Applying service '" + serviceName +
            "' (Fee: ₱" + serviceFee + ") to package: " +
            delivery.getPackageName()
        );
    }

    // =========================
    // Getters
    // =========================
    public String getServiceName() {
        return serviceName;
    }

    public int getServiceFee() {
        return serviceFee;
    }
}