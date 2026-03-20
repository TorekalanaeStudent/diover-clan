package parent_class;

public class Gadget_Ovejera {

    // attributes
    protected String gadgetName;
    protected String brand;
    protected String type;
    protected double price;
    protected int batteryLevel;
    protected boolean isPoweredOn;

    // default constructor
    public GadgetOvejera() {
        gadgetName = "null";
        brand = "null";
        type = "null";
        price = 0.0;
        batteryLevel = 0;
        isPoweredOn = false;
    }

    // parameterized constructor
    public GadgetOvejera(String gadgetName, String brand, String type,
                         double price, int batteryLevel, boolean isPoweredOn) {
        this.gadgetName = gadgetName;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.batteryLevel = batteryLevel;
        this.isPoweredOn = isPoweredOn;
    }

    // getters
    public String getGadgetName() {
        return gadgetName;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public boolean getIsPoweredOn() {
        return isPoweredOn;
    }

    // setters
    public void setGadgetName(String gadgetName) {
        this.gadgetName = gadgetName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public void setIsPoweredOn(boolean isPoweredOn) {
        this.isPoweredOn = isPoweredOn;
    }

    // behaviors
    public void powerOn() {
        if (!isPoweredOn) {
            isPoweredOn = true;
            System.out.println(gadgetName + " is now ON.");
        } else {
            System.out.println(gadgetName + " is already ON.");
        }
    }

    public void powerOff() {
        if (isPoweredOn) {
            isPoweredOn = false;
            System.out.println(gadgetName + " is now OFF.");
        } else {
            System.out.println(gadgetName + " is already OFF.");
        }
    }

    public void chargeBattery(int amount) {
        batteryLevel += amount;
        if (batteryLevel > 100) {
            batteryLevel = 100;
        }
        System.out.println(gadgetName + " battery is now at " + batteryLevel + "%");
    }

    public void gadgetInfo() { // can be overridden
        System.out.println("Gadget: " + gadgetName + " (" + type + ")");
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
        System.out.println("Battery: " + batteryLevel + "%");
        System.out.println("Powered On: " + isPoweredOn);
    }
}