package abstract_classes;

public abstract class Device_Jagunap {
    private String deviceName;
    private int batteryLevel;
    private boolean poweredOn;

    // Constructor
    public Device_Jagunap(String deviceName, int batteryLevel) {
        this.deviceName = deviceName;
        this.batteryLevel = batteryLevel;
        this.poweredOn = false; // default off
    }

    // Getters
    public String getDeviceName() {
        return deviceName;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public boolean isPoweredOn() {
        return poweredOn;
    }

    // Methods to control power
    public void turnOn() {
        poweredOn = true;
        System.out.println(deviceName + " is now ON.");
    }

    public void turnOff() {
        poweredOn = false;
        System.out.println(deviceName + " is now OFF.");
    }

    // Abstract methods
    public abstract void performTask();
    public abstract String getDeviceType();
}