public class Chair {

    String model;
    String color;

    public static String manufacturer = "Ziggy";

    public Chair() {
        this.model = "IKEA";
        this.color = "Red";
    }

    public Chair(String color) {
        this.color = color;
        this.model = "IKEA";
    }

    public String getColor() {
        return this.color;
    }

    public static String getManufacturer() {
        return manufacturer;

}

 public void setColor(String color){
     this.color = color;
    }

}