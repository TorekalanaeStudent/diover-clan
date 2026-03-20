package subclass;

import parent_class.Appliances_Arban;

public class WashingMachine_Ovejera extends Appliances_Arban {

    // additional attributes
    private int loadCapacity;
    private String mode;

    // default constructor
    public WashingMachine_Ovejera() {
        super();
        loadCapacity = 7;
        mode = "Normal";
    }

    // parameterized constructor
    public WashingMachine_Ovejera(String type, String brand, int stock, boolean power,
                                  int loadCapacity, String mode) {

        this.type = type;
        this.brand = brand;
        this.stock = stock;
        this.power = power;
        this.loadCapacity = loadCapacity;
        this.mode = mode;
    }

    // getters
    public int getLoadCapacity() {
        return loadCapacity;
    }

    public String getMode() {
        return mode;
    }

    // setters
    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    // overridden method
    @Override
    public void action() {
        System.out.println("Washing clothes using " + brand + " " + type +
                " in " + mode + " mode.");
    }

    // additional behavior
    public void startWash() {
        if (power) {
            System.out.println("Washing started with " + loadCapacity + "kg load.");
        } else {
            System.out.println("Please turn ON the washing machine first.");
        }
    }
}