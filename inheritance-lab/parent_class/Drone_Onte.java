package parent_class; 

public class Drone_Onte {

    // Static Attribute
    protected static int totalDrones;

    // Normal Attributes
    protected String model;
    protected int batteryLevel;
    protected double speed;

    //Default Constructor 
    public Drone_Onte() {
        totalDrones++;
        model = "MQ-9 Reaper";
        batteryLevel = 100;
        speed = 60.0;
    }
    
    // Behavior 1
    public void Fly() {
        System.out.println(model + " is flying at " + speed + " km/h.");
    }
    // Behavior 2
    public void Land() {
        System.out.println(model + " is landing.");
    }
    // Overridable Behavior
    public void performTask() {
        System.out.println(model + " is doing the task.");
    }

    //Getters
    public String getModel() {
        return model;
    }
}