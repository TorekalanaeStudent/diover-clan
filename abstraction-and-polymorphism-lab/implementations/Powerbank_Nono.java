package implementations;

import abstract_classes.Device_Jagunap;
import interfaces.EnergyEfficient_Jagunap;

/**
 * @author Nono, Mary Angeline B.
 */

public class Powerbank_Nono extends Device_Jagunap implements EnergyEfficient_Jagunap {

    private int chargeOutput; // in watts

    // Default Constructor
    public Powerbank_Nono() {
        super("Generic Powerbank", 100);
        setChargeOutput(10);
    }

    // Parameterized Constructor
    public Powerbank_Nono(String deviceName, int batteryLevel, int chargeOutput) {
        super(deviceName, batteryLevel);
        setChargeOutput(chargeOutput);
    }

    // Setter
    public void setChargeOutput(int chargeOutput) {
        if (chargeOutput <= 0) {
            System.out.println("Invalid charge output. Defaulting to 10W.");
            this.chargeOutput = 10;
        } else {
            this.chargeOutput = chargeOutput;
        }
    }

    // Abstract Method
    @Override
    public void performTask() {
        if (!isPoweredOn()) {
            System.out.println(getDeviceName() + " is OFF. Turn it on before charging.");
            return;
        }

        if (getBatteryLevel() <= 0) {
            System.out.println(getDeviceName() + " has no battery left to charge devices.");
            return;
        }

        System.out.println(getDeviceName()
                + " is charging a device at " + chargeOutput + "W.");
    }

    
    // Interface Method
    @Override
    public int energyUsagePerTask() {
        return chargeOutput <= 10 ? 5 : 12;
    }

    @Override
    public String getDeviceType() {
        return "Powerbank";
    }

    public void describe() {
        System.out.println("Device Info");
        System.out.println("Name      : " + getDeviceName());
        System.out.println("Type      : " + getDeviceType());
        System.out.println("Battery   : " + getBatteryLevel());
        System.out.println("Output    : " + chargeOutput + "W");
        System.out.println("Powered   : " + isPoweredOn());
    }

    public void describe(String title) {
        System.out.println("=== " + title + " ===");
        describe();
    }

    public void describe(String title, String note) {
        describe(title);
        System.out.println("Note: \"" + note + "\"");
    }
}