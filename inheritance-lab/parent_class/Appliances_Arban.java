package parent_class;

public class Appliances_Arban {

    // Variables 
    protected String type;
    protected String brand;
    protected int stock;
    protected boolean power;

    public Appliances_Arban() {
    // Attribute 
    type = "TV";
    brand = "Samsung";
    stock = 11;
    power = false;
    }
    // Behavior 
    public void on(){
       if (power == true){
        System.out.println("your " + brand + " " + type + "Already turn on");
       }
    }
    public void off(){
        if (power == false){
        System.out.println("your " + brand + " " + type + " Already turn off");
        }
    }
    public void action(){
        System.out.println("your watching on " + brand + " " + type );
    }
}
