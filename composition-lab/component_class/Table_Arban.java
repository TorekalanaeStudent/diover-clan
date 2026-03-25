public class Table_Arban {

    private String shape;
    private String material;
    private int numberOfLegs;

    // Constructor
    public Table_Arban(String shape, String material, int numberOfLegs) {
        this.shape = shape;
        this.material = material;
        this.numberOfLegs = numberOfLegs;
    }

    // Getters and Setters
    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    // Behavior methods
    public void supportItems() {
        System.out.println("The table is supporting items placed on it.");
    }

    public void move() {
        System.out.println("The table is being moved to another location.");
    }

    public void describe() {
        System.out.println("Table Details:");
        System.out.println("Shape: " + shape);
        System.out.println("Material: " + material);
        System.out.println("Number of Legs: " + numberOfLegs);
    }

    // Override toString()
    @Override
    public String toString() {
        return "Table{" +
                "shape='" + shape + '\'' +
                ", material='" + material + '\'' +
                ", numberOfLegs=" + numberOfLegs +
                '}';
    }
}
