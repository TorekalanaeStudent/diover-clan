package abstract_classes;
/**
 * @author Onte, Vince Gian D.
 * @vinceonte
 */

public abstract class WearableDevice_Onte {

    private String deviceName;
    private double batteryLife;
    private boolean isOn = true;

    // Default Constructor
    public WearableDevice_Onte() {
        this.deviceName = "Unknown";
        this.batteryLife = 100;
    }

    // Parameterized Constructor
    public WearableDevice_Onte(String deviceName, double batteryLife) {
        this.deviceName = deviceName;
        setBatteryLife(batteryLife);
    }

    // Getters
    public String getDeviceName() {
        return deviceName;
    }

    public double getBatteryLife() {
        return batteryLife;
    }

    // Setters
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setBatteryLife(double batteryLife) {

        // Cap at 100%
        if (batteryLife > 100) {
            this.batteryLife = 100;
            System.out.println("Fully charged. Battery: 100%");
        } 
        else {

            if (batteryLife <= 0) {
                this.batteryLife = 0;
                isOn = false;
                System.out.println("Battery is 0%. Device is now OFF.");
            } 
            else {
                this.batteryLife = batteryLife;

                if (batteryLife <= 20) {
                    System.out.println("Warning: Low Battery (" + batteryLife + "%) Please Charge.");
                }
            }
        }
    }

    // Abstract method
    public abstract void monitorHealth();

    // Concrete method
    public void displayStatus() {
        System.out.println("Device: " + deviceName);
        System.out.println("Battery: " + batteryLife + "%");

        if (isOn) {
            System.out.println("Status: ON");
        } else {
            System.out.println("Status: OFF");
        }
    }

    // Safety method
    public void checkPower() {
        if (!isOn) {
            System.out.println(deviceName + " is OFF. Please recharge.");
        }
    }
}