package implementations;

import abstract_classes.WashingMachine_Arban;
import interfaces.Laundry_Arban;

public class AutomaticWasher_DeJuras extends WashingMachine_Arban implements Laundry_Arban {

    // Attribute(s)
    private String washProgram;
    private double capacity;
    private boolean status;

    // Default Constructor
    public AutomaticWasher_DeJuras() {
        super("Smasnug");
        setProgram("Eco");
        setCapacity(5.0);
        setStatus(true);
    }

    // Parametrized Constructor
    public AutomaticWasher_DeJuras(String brand, String washProgram, double capacity, boolean status) {
        super(brand);
        setProgram(washProgram);
        setCapacity(capacity);
        setStatus(status);
    }

    // Overridden Methods
    @Override
    public void startWash() {
        if (!status) {
            System.out.println("Please Start The Washing Machine.");
        } else {
            System.out.println("The Washing Machine is Cleaning " + capacity + " Kg of Dirty Clothes");
        }
    }

    @Override
    public void stopWash() {
        if (!status) {
            System.out.println("The Machine is Already OFF");
        } else {
            System.out.println(brand + " has Stopped Cleaning");
        }
    }

    // Overloaded Methods
    public void startWash(int time) {
        if (!status) {
            System.out.println("Please Start The Washing Machine.");
        } else {
            System.out.println("The Washing Machine will stop washing at " + time + " minutes.");
        }
    }

    public void stopWash(int program, int time) {
        if (!status) {
            System.out.println("Please Start The Washing Machine.");
        } else {
            System.out.println("Successfully cleaned clothes at "+ program + " and will stop at " + time + " seconds");
        }
    }

    // Setters
    public void setProgram(String washProgram) {
        if (washProgram == null || washProgram.isBlank()) { 
            this.washProgram = "Normal";
        } else {
            this.washProgram = washProgram; 
        }
    }

    public void setCapacity(double capacity) {
        if (capacity <= 0) {
            this.capacity = 7.00;
        } else {                       
            this.capacity = capacity;
        }
    }

    public void setStatus(boolean status) {
        this.status = status;
        if (status) {
            System.out.println("Washing Machine is ON");
        } else {
            System.out.println("Washing Machine is OFF");
        }
    }

    // Getters
    public String getWashProgram() {
        return washProgram;
    }

    public double getCapacity() {
        return capacity;
    }

    public boolean getStatus() {
        return status;
    }

}
