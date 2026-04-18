package implementation_class;

import abstract_classes.Device_Jagunap;
import interfaces.EnergyEfficient_Jagunap;

/**
 * @author Nono
 */

public class SmartFan_Nono extends Device_Jagunap implements EnergyEfficient_Jagunap {

    // =========================
    // Attributes
    // =========================
    private int speedLevel;     // range: 1–5
    private boolean rotating;

    // =========================
    // DEFAULT CONSTRUCTOR
    // =========================
    public SmartFan_Nono() {
        super("Generic Smart Fan", 70);
        this.speedLevel = 3;
        this.rotating = false;
    }

    // =========================
    // PARAMETERIZED CONSTRUCTOR
    // =========================
    public SmartFan_Nono(String deviceName, int batteryLevel, int speedLevel) {
        super(deviceName, batteryLevel);
        setSpeedLevel(speedLevel);
        this.rotating = false;
    }

    // =========================
    // OVERRIDES
    // --- ABSTRACT CLASS ---
    // =========================
    @Override
    public void performTask() {
        if (!isPoweredOn()) {
            System.out.println(getDeviceName() + " is OFF. Please power it on first.");
            return;
        }

        if (getBatteryLevel() <= 0) {
            System.out.println(getDeviceName() + " has no battery left to operate.");
            return;
        }

        rotating = true;
        System.out.println(getDeviceName()
                + " is running at speed level " + speedLevel + ".");
    }

    @Override
    public String getDeviceType() {
        if (speedLevel >= 5)
            return "High-Speed Smart Fan";
        else if (speedLevel >= 3)
            return "Standard Smart Fan";
        else
            return "Low-Speed Smart Fan";
    }

    // =========================
    // --- INTERFACE ---
    // =========================
    @Override
    public int energyUsagePerTask() {
        return speedLevel <= 2 ? 3 : (speedLevel <= 4 ? 6 : 10);
    }

    // =========================
    // GETTERS
    // =========================
    public int getSpeedLevel() {
        return speedLevel;
    }

    public boolean isRotating() {
        return rotating;
    }

    // =========================
    // SETTERS
    // =========================
    public void setSpeedLevel(int speedLevel) {
        if (speedLevel < 1 || speedLevel > 5) {
            System.out.println("Invalid speed level. Setting to default (3).");
            this.speedLevel = 3;
        } else {
            System.out.println("Speed level set to: " + speedLevel);
            this.speedLevel = speedLevel;
        }
    }
}