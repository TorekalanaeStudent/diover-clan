package implementation_class;

import abstract_classes.Device_Jagunap;
import interfaces.EnergyEfficient_Jagunap;

/**
* @author Nono
*/

public class SmartLight_Nono extends Device_Jagunap implements EnergyEfficient_Jagunap {

    // Attributes

    private int brightnessLevel;   // range: 0–100
    private boolean lightOn;

    // DEFAULT CONSTRUCTOR

    public SmartLight_Nono() {
        super("Generic Smart Light", 80);
        this.brightnessLevel = 50;
        this.lightOn = false;
    }

    // PARAMETERIZED CONSTRUCTOR

    public SmartLight_Nono(String deviceName, int batteryLevel, int brightnessLevel) {
        super(deviceName, batteryLevel);
        setBrightnessLevel(brightnessLevel);
        this.lightOn = false;
    }

    // --- ABSTRACT CLASS ---

    @Override
    public void performTask() {
        if (!isPoweredOn()) {
            System.out.println(getDeviceName() + " is OFF. Please power it on first.");
            return;
        }

        if (getBatteryLevel() <= 0) {
            System.out.println(getDeviceName() + " has no battery left to emit light.");
            return;
        }

        lightOn = true;
        System.out.println(getDeviceName() + " is emitting light at brightness level " + brightnessLevel + ".");
    }

    @Override
    public String getDeviceType() {
        if (brightnessLevel >= 80)
            return "High-Brightness Smart Light";
        else if (brightnessLevel >= 40)
            return "Standard Smart Light";
        else
            return "Low-Brightness Smart Light";
    }

    // --- INTERFACE ---
    @Override
    public int energyUsagePerTask() {
        return brightnessLevel <= 40 ? 3 : 8;
    }

    // GETTERS
    public int getBrightnessLevel() {
        return brightnessLevel;
    }

    public boolean isLightOn() {
        return lightOn;
    }

    // SETTERS
    public void setBrightnessLevel(int brightnessLevel) {
        if (brightnessLevel < 0 || brightnessLevel > 100) {
            System.out.println("Invalid brightness level. Setting to default (50).");
            this.brightnessLevel = 50;
        } else {
            System.out.println("Brightness level set to: " + brightnessLevel);
            this.brightnessLevel = brightnessLevel;
        }
    }

}
