package sub_class;
import parent_class.Drone_Onte;

public class RcHelicopter_Ablis extends Drone_Onte {
    private static int amountOfHelicopters;
    private String rotorType;
    private int rotorCount;
    private double hoverAltitude;

    // default constructor
    public RcHelicopter_Ablis() {
        super(); // call parent class 
        model = "Blade 230 S";
        rotorType = "single"; // the blades of the heli
        rotorCount = 2;
        hoverAltitude = 10.0;
        amountOfHelicopters++;
    }

    // parameterized constructor
    public RcHelicopter_Ablis(String model, int batteryLevel, double speed, String rotorType, int rotorCount, double hoverAltitude) {
        this.model = model;
        this.batteryLevel = batteryLevel;
        this.speed = speed;
        this.rotorType = rotorType;
        this.rotorCount = rotorCount;
        this.hoverAltitude = hoverAltitude;
        amountOfHelicopters++;
    }

    // getters
    public String getHelicopterModel() {
        return this.model;
    }
    public String getHelicopterRotorType() {
        return this.rotorType;
    }
    public int getHelicopterRotorCount() {
        return this.rotorCount;
    }
    public double getHelicopterHoverAltitude() {
        return this.hoverAltitude;
    }

    // setters
    public void setRotorType(String newRotorType) {
        if (newRotorType.isBlank())
            System.out.println("Rotor type did not change.");
        else
            this.rotorType = newRotorType;
    }
    public void setHoverAltitude(double newAltitude) {
        if (newAltitude < 0)
            System.out.println("Altitude can't be negative.");
        else
            this.hoverAltitude = newAltitude;
    }

    // override
    @Override
    public void performTask() {
        System.out.println(model + " floats at " + hoverAltitude + " meters with " + rotorCount + " " + rotorType + " rotors.");
    }

    public static void countHelicopters() {
        System.out.println("The amount of RC helicopters is: " + amountOfHelicopters);
    }
}