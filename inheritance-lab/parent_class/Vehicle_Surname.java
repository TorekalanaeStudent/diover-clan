package parent_class;

public class Vehicle_Surname{
    // Static attribute
    protected static int vehicleQty;

    // Attributes
    protected String color;
    protected String brand;

    // Constructor - default
    public Vehicle_Surname(){
        color = "Gray";
        brand = "Honda";
        vehicleQty++;
    }

    // Constructor - parameterized
    public Vehicle_Surname(String color, String brand){
        this(); // only gets the "vehicleQty++"
        this.color = color;
        this.brand = brand;
    }

    // Behavior (Method) - overridable
    public void drive(){
        System.out.println("The vehicle drives.");
    }

    // Behavior (Method) - overridable
    public void start(){
        System.out.println("The vehicle starts.");
    }
}