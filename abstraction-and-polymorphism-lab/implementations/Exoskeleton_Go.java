package implementations;

import abstract_classes.WearableDevice_Onte;
import interfaces.DeviceSystem_Onte;

/*
* @author Go Sean Ethan G.
* @SethPlaysBadly
*/

public class Exoskeleton_Go extends WearableDevice_Onte implements DeviceSystem_Onte {
    
    private int strengthLevel;

    // Default Constructor
    public Exoskeleton_Go() {
        super("Exoskeleton Suit", 100);
        this.strengthLevel = 5;
    }

    // Parameterized Constructor
    public Exoskeleton_Go(String deviceName, double batteryLife, int strengthLevel) {
        super(deviceName, batteryLife);
        this.strengthLevel = strengthLevel;
    }

    // Overloaded Method
    public void boostPower() {
        setStrengthLevel(10);
    }

    public void boostPower(int level) {
        setStrengthLevel(level);
    }

    // Getter
    public int getStrengthLevel() {
        return strengthLevel;
    }

    // Setter
    public void setStrengthLevel(int strengthLevel) {
        if (strengthLevel < 1) {
            this.strengthLevel = 1;
        } 
        else if (strengthLevel > 10) {
            this.strengthLevel = 10;
        } 
        else {
            this.strengthLevel = strengthLevel;
        }
    }

    // Implement abstract method from WearableDevice_Onte
    @Override
    public void monitorHealth() {
        System.out.println(getDeviceName() + " User neural link is stable.");
    }

    // Implement abstract method from DeviceSystem_Onte
    @Override
    public void syncData(String device) {
        System.out.println(getDeviceName() + " synced neuron data with " + device);
    }
}