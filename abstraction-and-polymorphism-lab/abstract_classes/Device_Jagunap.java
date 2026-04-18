package abstract_classes;

/**
 * @author Jagunap, Janelle
 */
public abstract class Device_Jagunap {

    protected String deviceName;
    protected int batteryLevel;
    protected boolean poweredOn;

    // =========================
    // Constructor
    // =========================
    public Device_Jagunap(String deviceName, int batteryLevel) {
        setDeviceName(deviceName);
        setBatteryLevel(batteryLevel);
        this.poweredOn = false;
    }

    // =========================
    // Setters
    // =========================
    public void setDeviceName(String deviceName) {
        if (deviceName == null || deviceName.isBlank()) {
            System.out.println("Invalid device name. Defaulting to 'Generic Device'.");
            this.deviceName = "Generic Device";
        } else {
            this.deviceName = deviceName;
        }
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel < 0 || batteryLevel > 100) {
            System.out.println("Battery level must be between 0–100. Default is 50.");
            this.batteryLevel = 50;
        } else {
            this.batteryLevel = batteryLevel;
        }
    }

    // =========================
    // Concrete Method
    // =========================
    public void powerOn() {
        if (batteryLevel <= 0) {
            System.out.println(deviceName + " cannot power on. Battery empty.");
            return;
        }
        poweredOn = true;
        System.out.println(deviceName + " is now powered ON.");
    }

    // =========================
    // Abstract Methods
    // =========================
    public abstract void performTask();
    public abstract String getDeviceType();

    // =========================
    // Getters
    // =========================
    public String getDeviceName() {
        return deviceName;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public boolean isPoweredOn() {
        return poweredOn;
    }
}
