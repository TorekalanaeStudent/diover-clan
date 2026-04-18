package implementation_class;
 
import abstract_classes.Device_Jagunap;
import interfaces.EnergyEfficient_Jagunap;
 
/**
* @author Nono, Mary Angeline B.

*/
 
public class Powerbank_Nono extends Device_Jagunap implements EnergyEfficient_Jagunap {
 
    // =========================
    // Attributes
    // =========================
    private int chargeOutput;   // in watts
    private boolean charging;
 
    // =========================
    // DEFAULT CONSTRUCTOR
    // =========================
    public Powerbank_Nono() {
        super("Generic Powerbank", 50);
        setChargeOutput(10);
        this.charging = false;
    }
 
    // =========================
    // PARAMETERIZED CONSTRUCTOR
    // =========================
    public Powerbank_Nono(String deviceName, int batteryLevel, int chargeOutput) {
        super(deviceName, batteryLevel);
        setChargeOutput(chargeOutput);
        this.charging = false;
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
            System.out.println(getDeviceName() + " has no remaining battery.");
            return;
        }
 
        charging = true;
        System.out.println(getDeviceName()
                + " is charging a device at " + chargeOutput + "W.");
    }
 
    @Override
    public String getDeviceType() {
        if (chargeOutput >= 20)
            return "Fast-Charging Powerbank";
        else if (chargeOutput >= 10)
            return "Standard Powerbank";
        else
            return "Low-Power Powerbank";
    }
 
    // =========================
    // --- INTERFACE ---
    // =========================
    @Override
    public int energyUsagePerTask() {
        return chargeOutput <= 10 ? 5 : 12;
    }
 
    // =========================
    // GETTERS
    // =========================
    public int getChargeOutput() {
        return chargeOutput;
    }
 
    public boolean isCharging() {
        return charging;
    }
 
    // =========================
    // SETTERS
    // =========================
    public void setChargeOutput(int chargeOutput) {
        if (chargeOutput <= 0 || chargeOutput > 30) {
            System.out.println("Invalid charge output. Setting to default 10W.");
            this.chargeOutput = 10;
        } else {
            System.out.println("Charge output set to: " + chargeOutput + "W");
            this.chargeOutput = chargeOutput;
        }
    }
}
 
 
