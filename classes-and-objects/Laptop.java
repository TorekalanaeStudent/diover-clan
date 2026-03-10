public class Laptop {

    String model;
    String color;

    public static String manufacturer = "Ablis";

    public Laptop() {
        this.model = "Lenovo";
        this.color = "White";
    }

    public Laptop(String color) {
        this.color = color;
        this.model = "Lenovo";
    }

    public String getColor() {
        return this.color;
    }

    public static String getManufacturer() {
        return manufacturer;
    }

}