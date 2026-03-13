 //Clint Class
 
 public class Car{
     // Private attributes
    private String brand;
    private String model;
    private String color;
    private int speed;

    // Default constructor
    public Car (){
        brand = "Toyota";
        model = "AE86 Trueno" ;
        color = "Black and White";
        speed = 0;

    }
    // Parameterized constructor
    public Car(String brand, String model, String color, int speed){
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.speed = speed;
    }
    // Getter methods
    public String getCar(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public String getColor(){
        return color;
    }
    public int getSpeed(){
        return speed;
    }
    //SETTERS
    public void setSpeed(int speed){   // this is A.I assisted
        if (speed >= 0){                     
            this.speed = speed;         
        }
    }
    // Behavior
    public void accelerate(){
        speed += 10;
        System.out.println("Speed: " + speed);
        System.out.println("GAS GAS GAS");
    }
    //display gaming
    public void displayCarInfo(){
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Color:" + color);
        System.out.println("Speed:" + speed);
    }
 }
 
