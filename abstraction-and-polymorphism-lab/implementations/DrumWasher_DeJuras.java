package implementations;

import abstract_classes.WashingMachine_Arban;
import interfaces.Laundry_Arban;

public class DrumWasher_DeJuras extends WashingMachine_Arban implements Laundry_Arban {

    private String washMode;
    private double loadCap;
    private boolean isRunning;

    // Default Constructor
    public DrumWasher_DeJuras(){
        super("WhirlPool");
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
        System.out.println(brand);
        System.out.println("Wash Mode : " + washMode);
        System.out.println("Capacity : " + loadCap);
        System.out.println("Active : " + isRunning);
        System.out.println("------------------------");
    }

    // Override
    @Override
    public void startWash(){
        if(!isRunning){
            System.out.println("Your Drum Washer is inactive.");
        } else {
            System.out.println("Drum Washer is washing " + loadCap + "kg at mode: " + washMode);
        }
    }

    @Override
    public void stopWash(){
        if(!isRunning){
            System.out.println("Your Drum Washer is inactive.");
        } else {
            System.out.println("Successfully cleaned " + loadCap + "kg of clothes.");
        }
    }

    // Overloading
    public void startWash(double time){
        System.out.println("Wash Time: " + time + " minutes");
    }

    public void stopWash(double time, boolean stopTime){
        System.out.println("The washing machine will stop in " + time + " minutes");
    }

    // Getters
    public String getWashMode(){
        return this.washMode;
    }

    public double getCapacity(){
        return this.loadCap;
    }

    public boolean getIsRunning(){
        return this.isRunning;
    }

    // Setters
    public void setWashMode(String washMode){
        if(washMode == null || washMode.isBlank()){
            System.out.println("Wash Mode set to: Normal");
            this.washMode = "Normal";
        } else {
            this.washMode = washMode;
            System.out.println("Wash Mode set to: " + washMode);
        }
    }

    public void setLoadCap(double loadCap){
        if(loadCap <= 0){
            System.out.println("Invalid capacity, defaulting to 7.0kg");
            this.loadCap = 7.0;
        } else {
            this.loadCap = loadCap;
            System.out.println("Load capacity set to: " + loadCap + "kg");
        }
    }

    public void setIsRunning(boolean isRunning){
        this.isRunning = isRunning; 
        if(isRunning){
            System.out.println("Drum Washer is On");
        } else {
            System.out.println("Drum Washer is Off");
        }
    }
}