package sub_class;

import parent_class.Vehicle_Surname;

public class Car_Surname extends Vehicle_Surname{
    private String model;
    private int year;
    private double liters;

    // default
    public Car_Surname(){
        super();
        // defualt:
        // color = gray
        // brand = honda
        // qtyVehicle++;
        model = "Civic";
        year = 1991;
        liters = 1.5;
    }

    // parameterized
    public Car_Surname(String color, String brand, String model, int year, double liters){
        super(color, brand); // color, brand
        this.model = model;
        this.year = year;
        this.liters = liters;
    }

    // Behavior (Method) - overridable
    @Override
    public void drive(){
        System.out.println(model + " " + year +" is driving.");
    }

    @Override
    public void start(){
        System.out.println("You turn the key on your " + brand + " " + model + " to start your car");
    }

    // new implemented method in subclass with rule validation
    public void turnWheel(String direction){
        if(direction.startsWith("r")){
            System.out.println("You turn the wheel right.");
        } else if(direction.startsWith("l")){
            System.out.println("You turn the wheel left.");
        } else
            System.out.println("That is not a direction.");
    }

}