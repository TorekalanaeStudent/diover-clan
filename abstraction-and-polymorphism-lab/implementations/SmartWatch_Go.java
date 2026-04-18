package implementations;

import abstract_classes.WearableDevice_Onte;
import interfaces.DeviceSystem_Onte;

/*
* @author Go Sean Ethan G.
* @SethPlaysBadly
*/

public class SmartWatch_Go extends WearableDevice_Onte implements DeviceSystem_Onte {
	 
    private int heartRate;

    // Default Constructor
    public SmartWatch_Go() {
        super("Smart Watch", 100);
        this.heartRate = 72;
    }

    // Parameterized Constructor
    public SmartWatch_Go(String deviceName, double batteryLife, int heartRate) {
        super(deviceName, batteryLife);
        this.heartRate = heartRate;
    }
  
    // Overloaded Method
    public void charge() {
    setBatteryLife(100);
    }

    public void charge(double amount) {
    setBatteryLife(getBatteryLife() + amount);
    }

    // Getter
    public int getHeartRate() {
        return heartRate;
    }

    // Setter
    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    // Implement abstract method from WearableDevice_Onte
    @Override
    public void monitorHealth() {
        System.out.println(getDeviceName() + " Heart Rate: " + heartRate + " BPM");
    }

    // Implement abstract method from DeviceSystem_Onte
    @Override
    public void syncData(String device) {
        System.out.println(getDeviceName() + " synced with " + device);
    }
}