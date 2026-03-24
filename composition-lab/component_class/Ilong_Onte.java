package component_class;

public class Ilong_Onte {

    // Attributes 
    private String shape;
    private String size;
    private boolean isClean;

    // Constructor
    public Ilong_Onte(String shape, String size, boolean isClean) {
        this.shape = shape;
        this.size = size;
        this.isClean = isClean;
    }

    // Getters
    public String getShape() {
        return shape;
    }
    public String getSize() {
        return size;
    }
    public boolean isClean() {
        return isClean;
    }

    // Setters with validation
    public void setShape(String shape) {
        if (shape != null) {
            if (!shape.isEmpty()) {
                this.shape = shape;
            } else {
                System.out.println("Shape cannot be empty.");
            }
        } else {
            System.out.println("Shape cannot be null.");
        }
    }

    public void setSize(String size) {
        if (size != null) {
            if (!size.isEmpty()) {
                this.size = size;
            } else {
                System.out.println("Size cannot be empty.");
            }
        } else {
            System.out.println("Size cannot be null.");
        }
    }

    public void setClean(boolean clean) {
        isClean = clean; // fixed assignment
    }

    // Behavior methods
    public void sniff() {
        System.out.println("*Sniffing the air*");
    }

    public void cleanNose() {
        if (isClean) {
            System.out.println("Nose is already clean.");
        } else {
            System.out.println("Nose is dirty. Cleaning the nose.");
            isClean = true;
        }
    }
    // Display Nose Info
    public void displayInfo() {
        System.out.println("\nNose Details:");
        System.out.println("Shape: " + shape);
        System.out.println("Size: " + size);
        System.out.println("Clean: " + isClean);
    }

    // Override toString
    @Override
    public String toString() {
        return "Nose{" +
                "shape='" + shape + '\'' +
                ", size='" + size + '\'' +
                ", isClean=" + isClean +
                '}';
    }
}