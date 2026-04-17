package abstract_classes;

/**
 * @author Ovejera, Ziggy
 */

public abstract class Gadget_Ovejera {

    private String name;
    private String brand;
    private int batteryLevel;
    private int price;
    private boolean batterySet;
    private boolean priceSet;

    // DEFAULT CONSTRUCTOR
    public Gadget_Ovejera() {
        setName("Unknown Gadget");
        setBrand("Generic");
        setBatteryLevel(100);
        setPrice(5000);
    }

    // PARAMETERIZED CONSTRUCTOR
    public Gadget_Ovejera(String name, String brand, int batteryLevel, int price) {
        setName(name);
        setBrand(brand);
        setBatteryLevel(batteryLevel);
        setPrice(price);
    }

    // ABSTRACT METHODS
    public abstract void powerOn();
    public abstract void useGadget();

    // CONCRETE METHOD
    public void charge(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid charge amount.");
            return;
        }

        System.out.println(name + " is charging +" + amount + "% battery.");
        this.batteryLevel += amount;

        if (this.batteryLevel > 100) {
            this.batteryLevel = 100;
        }
    }

    public void displayInfo() {
        System.out.println("Gadget: " + name);
        System.out.println("Brand: " + brand);
        System.out.println("Battery: " + batteryLevel + "%");
        System.out.println("Price: ₱" + price);
    }

    // GETTERS
    public String getName() { return name; }

    public String getBrand() { return brand; }

    public int getBatteryLevel() { return batteryLevel; }

    public int getPrice() { return price; }

    // SETTERS
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("Invalid name! Default used.");
            this.name = "Unknown Gadget";
            return;
        }
        this.name = name;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isBlank()) {
            System.out.println("Invalid brand! Default used.");
            this.brand = "Generic";
            return;
        }
        this.brand = brand;
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel < 0 || batteryLevel > 100) {
            System.out.println("Battery must be 0–100.");
            this.batteryLevel = (batterySet) ? this.batteryLevel : 100;
            return;
        }
        this.batteryLevel = batteryLevel;
        batterySet = true;
    }

    public void setPrice(int price) {
        if (price < 0) {
            System.out.println("Invalid price!");
            this.price = (priceSet) ? this.price : 5000;
            return;
        }
        this.price = price;
        priceSet = true;
    }
}