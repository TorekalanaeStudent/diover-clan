package parent_class;

public class Vehicle_Nono {

    // Static Attributes
    protected static boolean hasEngine;

    // Normal Attributes
    protected String vehicleType;
    protected String vehicleColor;
    protected String vehicleName;

    // Default Constructor
    public Vehicle_Nono(){
        this.hasEngine = true;
        this.vehicleType = "Car";
        this.vehicleColor = "Black";
        this.vehicleName = "Nono's Vehicle";
    }

    // 2 Behaviors
    public void start(){
        System.out.println(hasEngine ? getVehicleName() + " has started." : getVehicleName() + " cannot start.");
    }

    // Overridable Behavior
    public void move(){
        System.out.println("The vehicle is moving forward.");
    }

    // Getters
    public String getVehicleName(){
        return this.vehicleName;
    }

}