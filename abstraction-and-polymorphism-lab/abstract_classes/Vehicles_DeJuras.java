package abstract_classes;

/**
 * @author De Juras, Clint Norbert P.
 * @cdejuras 
 */

public abstract class Vehicles_DeJuras {

    // Attributes
    protected String name;
    protected String brand;
    protected int speed;

    // Constructor
    public Vehicles_DeJuras(String name, String brand, int speed) {
        this.name = name;
        this.brand = brand;
        this.speed = speed;
    }

    // Abstract Methods
    public abstract void accelerate();
    public abstract void brake();

    // Concrete Method
    public void running(int speed) {
        if (speed > 0) {
            System.out.println("You are running at " + speed + " km/h");
        } else {
            System.out.println("You are not running.");
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getSpeed() {
        return speed;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}