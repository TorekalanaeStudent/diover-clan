public class Mouse {

    String model;
    String color;

    public static String manufacturer = "Clint";

    public Mouse() {
        this.model = "Logitech";
        this.color = "Black";
    }

    public Mouse(String color) {
        this.color = color;
        this.model = "Logitech";
    }
    public void setColor(String color){
         this.color = color;
    }
    public String getColor() {
        return this.color;
    }

    public static String getManufacturer() {
        return manufacturer;
    }

}
