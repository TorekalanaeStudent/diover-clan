package abstract_classes;

/**
 * @author @flcardeno (Cardeno, Faye L.)
 */

public abstract class Delivery_Cardeno {

    // attributes
    private String packageName;
    private String destination;
    private String senderName;
    private String receiverName;

    // default Constructor
    public Delivery_Cardeno() {
        packageName = "Basic Package";
        destination = "Manila";
        senderName = "Unknown Sender";
        receiverName = "Unknown Receiver";
    }

    // parameterized Constructor
    public Delivery_Cardeno(String packageName, String destination, String senderName, String receiverName) {
        this.packageName = packageName;
        this.destination = destination;
        this.senderName = senderName;
        this.receiverName = receiverName;
    }

    // getters
    public String getPackageName() {
        return packageName;
    }
    public String getDestination() {
        return destination;
    }
    public String getSenderName() {
        return senderName;
    }
    public String getReceiverName() {
        return receiverName;
    }

    // setters
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    // abstract methods
    public abstract void deliver();
    public abstract void calculateETA();

    // concrete method
    public void track() {
        System.out.println(packageName + " from " + senderName + " is being delivered to " + receiverName + " at " + destination);
    }
}