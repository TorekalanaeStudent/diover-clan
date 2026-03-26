package component_class;

public class Leg_Canillo{

    private int toesCount;
    private double legSizeCm;
    private double runSpeedMPH;

    // Default constructor
    public Leg_Canillo(){
        toesCount = 5; // one leg
        legSizeCm = 82.8; // for a 5'5 feet guy
        runSpeedMPH = 15; // an average adult can run 15-20mph 
    }

    // Parameterized constructor
    public Leg_Canillo(int toesCount, double legSizeCm, double runSpeedMPH){
        this.toesCount = toesCount;
        this.legSizeCm = legSizeCm;
        this.runSpeedMPH = runSpeedMPH;
    }

    // Getters
    public int getToes(){
        // returns the amount of toes in one leg
        return toesCount;
    }

    public double getLegSize(){
        // returns the leg size
        return legSizeCm;
    }
    
    public double getRunSpeed(){
        // returns the speed of a leg
        return runSpeedMPH;
    }

    // Setters
    public void setToesCount(int numToes){
        if(numToes < 0)
            System.out.println("You cannot have negative toes.");
        else 
            this.toesCount = numToes;
    }

    public void setLegSize(double legSize){
        if(legSize <= 0)
            System.out.println("Your leg size cannot be 0 or below 0");
        else
            this.legSizeCm = legSize;
    }
    
    public void setRunSpeed(double runSpeed){
        if(runSpeed <= 0)
            System.out.println("Your run speed must be above 0");
        else
            this.runSpeedMPH = runSpeed;
    }

    // Methods
    public void run(){
        System.out.println("You're running with speeds reaching to " + runSpeedMPH);
    }

    public void walk(){
        System.out.println("You're walking nice");
    }

    public void cleanLegs(){
        System.out.println("You just cleaned your legs wow");
    }

    public void describe(){
        System.out.println("Toes: " + toesCount 
        + "\nLeg Size: " + legSizeCm 
        + "\nRun Speed: " + runSpeedMPH);
    }
}