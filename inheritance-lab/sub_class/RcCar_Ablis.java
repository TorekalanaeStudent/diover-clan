package sub_class;
import parent_class.Drone_Onte;

public class RcCar_Ablis extends Drone_Onte {
    private static int amountOfCars;
    private String wheelType;
    private int wheelCount;
    private double maxSpeed;

    // default constructor
    public RcCar_Ablis() {
        super();
        model = "Tamiya CC-01";
        wheelType = "off-road";
        wheelCount = 4;
        maxSpeed = 100.0;
        amountOfCars++;
    }

    // parameterized constructor 
    public RcCar_Ablis(String model, int batteryLevel, double speed, String wheelType, int wheelCount, double maxSpeed) {
        super(); // calls drone_onte
        this.model = model;
        this.batteryLevel = batteryLevel;
        this.speed = speed;
        this.wheelType = wheelType;
        this.wheelCount = wheelCount;
        this.maxSpeed = maxSpeed;
        amountOfCars++;
    }

    // getters 
    public String getWheelType() {        
        return this.wheelType;
    }
    public int getWheelCount() {          
        return this.wheelCount;
    }
    public double getMaxSpeed() {         
        return this.maxSpeed;
    }

    // setters 
    public void setWheelType(String newWheelType) { // else if and operators for shortcuts for 3 situations
        if (newWheelType.isBlank()) {
            System.out.println("Wheel type did not change.");
        } else if (!newWheelType.equals("street") && !newWheelType.equals("rally") && !newWheelType.equals("off-road")) {
            System.out.println("Invalid wheel type. Choose: street, rally, or off-road."); 
        } else {
            this.wheelType = newWheelType;
        }
    }
    public void setMaxSpeed(double newMaxSpeed) {
        if (newMaxSpeed < 0)
            System.out.println("Max speed can't be negative.");
        else
            this.maxSpeed = newMaxSpeed;
    }

    //behaviours
    public void drive() { 
        System.out.println(model + " is accelerating on the road at " + speed + " km/h using " + wheelType + " wheels.");
    }

    public void brake() { 
        System.out.println(model + " is parking safely after the drive.");
    }

    @Override
    public void performTask() {
        System.out.println("The RC car is driving around the track.");
    }

    public static void countCars() {
        System.out.println("The amount of RC cars is: " + amountOfCars);
    }
}