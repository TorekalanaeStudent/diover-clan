package implementations;

import abstract_classes.WashingMachine_Arban;
import interfaces.Laundry_Arban;

public class DrumWasher_DeJuras extends WashingMachine_Arban implements Laundry_Arban {

    private String washMode;
    private double loadCap;
    private boolean isRunning;

    // Default Constructor
    public DrumWasher_DeJuras(){
        super("Whirlpool");
        setWashMode("Heavy Duty");
        setLoadCap(7.0);
        setIsRunning(false);
    }

    // Parameterized Constructor
    public DrumWasher_DeJuras(String brand, String washMode, double loadCap, boolean isRunning){
        super(brand);
        setWashMode(washMode);
        setLoadCap(loadCap);
        setIsRunning(isRunning);
    }

    public void display(){
        System.out.println("------------------------");
        System.out.println("Brand: " + getBrand());
        System.out.println("Wash Mode: " + washMode);
        System.out.println("Capacity: " + loadCap + " kg");
        System.out.println("Running: " + isRunning);
        System.out.println("------------------------");
    }

    // Override
    @Override
    public void startWash(){
        if(!isRunning){
            System.out.println("Washer is OFF.");
        } else {
            System.out.println("Washing " + loadCap + "kg using " + washMode + " mode.");
        }
    }

    @Override
    public void stopWash(){
        if(!isRunning){
            System.out.println("Washer is already OFF.");
        } else {
            System.out.println("Wash complete: " + loadCap + "kg cleaned.");
            isRunning = false;
        }
    }

    // Overloading
    public void startWash(double time){
        System.out.println("Wash Time: " + time + " minutes");
    }

    public void stopWash(double time, boolean autoStop){
        System.out.println("Machine will stop in " + time + " minutes");
    }

    // Getters
    public String getWashMode(){
        return washMode;
    }

    public double getCapacity(){
        return loadCap;
    }

    public boolean getIsRunning(){
        return isRunning;
    }

    // Setters
    public void setWashMode(String washMode){
        if(washMode == null || washMode.isBlank()){
            this.washMode = "Normal";
        } else {
            this.washMode = washMode;
        }
    }

    public void setLoadCap(double loadCap){
        if(loadCap <= 0){
            this.loadCap = 7.0;
        } else {
            this.loadCap = loadCap;
        }
    }

    public void setIsRunning(boolean isRunning){
        this.isRunning = isRunning;
    }
}
