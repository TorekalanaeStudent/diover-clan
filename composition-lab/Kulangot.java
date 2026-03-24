public class Kulangot {

    private String color;
    private String size;
    private boolean isSticky;

    // Constructor
    public Kulangot(String color, String size, boolean isSticky) {
        this.color = color;
        this.size = size;
        this.isSticky = isSticky;
    }

    // Getters and Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isSticky() {
        return isSticky;
    }

    public void setSticky(boolean sticky) {
        isSticky = sticky;
    }

    // Behavior methods
    public void roll() {
        System.out.println("The kulangot is being rolled between fingers...");
    }

    public void flick() {
        System.out.println("Flick! The kulangot has been launched.");
    }

    public void describe() {
        System.out.println("Kulangot Details:");
        System.out.println("Color: " + color);
        System.out.println("Size: " + size);
        System.out.println("Sticky: " + isSticky);
    }

    // Override toString()
    @Override
    public String toString() {
        return "Kulangot{" +
                "color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", isSticky=" + isSticky +
                '}';
    }
}