public class Car {

    String model;
    String color;

    public static manufacturer = "Ramon";

    public Car() {
        this.model = "Toyota";
        this.color = "White";
    }

    public Car(String color) {
        this.color = color;
        this.model = "Toyota";
    }

    public String getColor() {
        return this.color;
    }

    public static String getManufacturer() {
        return this.manufacturer;
    }

}