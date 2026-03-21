package subclass;

import parent_class.Appliances_Arban;

public class Refrigerator_Ovejera extends Appliances_Arban {

    // additional attributes
    private int capacity;
    private String coolingType;

    // default constructor
    public Refrigerator_Ovejera() {
        super();
        capacity = 200;
        coolingType = "Standard";
    }

    // parameterized constructor
    public Refrigerator_Ovejera(String type, String brand, int stock, boolean power,
                                int capacity, String coolingType) {

        this.type = type;
        this.brand = brand;
        this.stock = stock;
        this.power = power;
        this.capacity = capacity;
        this.coolingType = coolingType;
    }

    // getters
    public int getCapacity() {
        return capacity;
    }

    public String getCoolingType() {
        return coolingType;
    }

    // setters
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCoolingType(String coolingType) {
        this.coolingType = coolingType;
    }

    // overridden method
    @Override
    public void action() {
        System.out.println("Cooling food using " + brand + " refrigerator (" + coolingType + ").");
    }

    // additional behavior
    public void storeFood(String food) {
        if (power) {
            System.out.println(food + " stored inside the refrigerator.");
        } else {
            System.out.println("Turn ON the refrigerator first.");
        }
    }
}