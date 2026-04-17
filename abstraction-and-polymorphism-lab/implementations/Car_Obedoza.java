package implementations;

import abstract_classes.Vehicles_DeJuras;
import interfaces.VehicleSystem_DeJuras;

public class Car_Obedoza extends Vehicles_DeJuras implements VehicleSystem_DeJuras{
    
    // Attributes
    private String modelName;
    private String carType;
    private int topSpeed;
    private boolean isRunning = true;

    // Parameterized Contructor
    public Car_Obedoza(String modelName, String carType, int topSpeed, boolean isRunning) {
        super(modelName, carType, topSpeed);
        this.isRunning = isRunning;
    }

    // Setters
    public void setModelName(String modelName) {
        if (modelName == null || modelName.isEmpty()) {
            System.out.println("Please Enter a Car Model.");
        } else {
            this.modelName = modelName;
        System.out.println("Car Model: " + modelName);
        }
    }

    public void setCarType(String carType) {
        if(carType == null || carType.isEmpty()) {
            System.out.println("Invalid Input! Please Enter a Car Type");
        } else {
            this.carType = carType;
            System.out.println("Car Type: "+ carType);
        }
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    // Getters 
    public String getModelName() {
        return modelName;
    }

    public String getCarType() {
        return carType;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public boolean getIsRunning() {
        return isRunning;
    }
    

    @Override
    public void accelerate() {
        int topSpeed = 100;
        int acceleration = 10;

        while (speed < topSpeed) {
            speed += acceleration;

            if (speed < 40) {
                System.out.println("🐢 Slow speed: " + speed + "km/h");
            } else if (speed < 70) {
                System.out.println("🚶 Medium speed: " + speed + "km/h");
            } else if (speed < 100) {
                System.out.println("💨 Fast speed: " + speed + "km/h");
            } else {
                speed = topSpeed; // cap it exactly at 100
                System.out.println("🏎️  TOP SPEED REACHED: " + speed + "km/h!");
            }
        }
    }

    @Override
    public void accelerate(int speed) {
        int topSpeed = 100;
        int acceleration = 10;

        while (speed < topSpeed) {
            speed += acceleration;

            if (speed < 40) {
                System.out.println("🐢 Slow speed: " + speed + "km/h");
            } else if (speed < 70) {
                System.out.println("🚶 Medium speed: " + speed + "km/h");
            } else if (speed < 100) {
                System.out.println("💨 Fast speed: " + speed + "km/h");
            } else {
                speed = topSpeed;
                System.out.println("🏎️  TOP SPEED REACHED: " + speed + "km/h!");
            }
        }
    }

    // Overloaded method
    public void brake() {
    System.out.println("Emergency brake! Car stopped immediately. ");
    }

    public void brake(int pressureAmount) {
        if (pressureAmount >= 100) {
           System.out.println("Full brake applied! Car is stopping. ");
        } else if (pressureAmount >= 50) {
            System.out.println("Moderate brake applied.");
        } else {
            System.out.println("Slowly applying brakes now.");
        }
    }

    @Override
    public void performSpecialFeature() {
        System.out.println("Activating Nitro!");
    }
}