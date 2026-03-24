package component_class;

public class Handkerchief_Gedoria {
    private String color;
    private String size;
    private boolean isUsed;

// Constructor
    public Handkerchief(String color, String size, boolean isUsed) {
        this.color = color;
        this.size = size;
        this.isUsed = isUsed;
    }

     // Getters and Setters
    public String getColor() {
        return color;
    }

    //Validation for at least one
    public void setColor(String color) {
    if (color == null || color.trim().isEmpty()) {
        System.out.println("Color cannot be empty.");
    } else {
        this.color = color;
    }
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void isUsed(boolean used) {
        isUsed = used;
    }

     // Behavior methods
    public void fold() {
        System.out.println("Folding the handkerchief!");
    }

    public void use() {
System.out.println("Handkerchief is being used!");
    }

    public void description() {
        System.out.println("Handkerchief Details: ");
        System.out.println("Color: " + color);
        System.out.println("Size: " +  size);
        System.out.println("Used: " + isUsed);

    }

   

        // Override toString()
    @Override
    public String toString() {
        return "Handkerchief{" +
                "color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", isUsed=" + isUsed +
                '}';
    }
}