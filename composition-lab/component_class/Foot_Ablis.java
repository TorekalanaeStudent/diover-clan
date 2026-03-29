package component_class;

public class Foot_Ablis {
    
    // attributes
    private String name; // name of foot owner
    private boolean isRun; // behaviour attribute for running state
    private double shoeSize; // US/Euro shoe size range

    public Foot_Ablis(String name, double shoeSize, boolean isRun) {
        this.name = name;
        setShoeSize(shoeSize);
        this.isRun = isRun;
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public double getShoeSize() {
        return shoeSize;
    }

    public boolean isRun() {
        return isRun;
    }

    // SETTERS
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setShoeSize(double shoeSize) {
        // valid shoe size range
        if (shoeSize >= 3.0 && shoeSize <= 18.0) {
            this.shoeSize = shoeSize;
        }
    }

    // BEHAVIOURS
    public void run() {
        this.isRun = true;
            System.out.println(name + " is running with shoe size " + shoeSize);
    }

    public void walk() {
        this.isRun = false; 
            System.out.println(name + " is walking with shoe size " + shoeSize);
    }
}