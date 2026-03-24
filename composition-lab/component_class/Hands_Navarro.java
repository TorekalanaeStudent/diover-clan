package component_class;

/**
 *
 * @author NavarroVinceJustine
 */
public class Hands_Navarro {

    private String color;
    private String size;
    private boolean haveHands;

    // Constructor
    public Hands_Navarro(String color, String size, boolean haveHands) {
        this.color = color;
        this.size = size;
        this.haveHands = haveHands;
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

    public boolean HaveHands() {
        return haveHands;
    }

    public void setHaveHands(boolean yes) {
        haveHands = yes;    
    }

    // Behavior methods
    public void usingHands() {
        if (haveHands = true) {
        System.out.println("You try to move your one of your hands....");
        } else {
                System.out.println("You can't use your hands....");
                
        }
    }
    public void pickingyourNose() {
        System.out.println("You use your one of your hands to pick up your nose!");
    }

    public void describe() {
        System.out.println("Hand Details:");
        System.out.println("Color: " + color);
        System.out.println("Size: " + size);
        System.out.println("Do he/she have hands?: " + haveHands);
    }

    // Override toString()
    @Override
    public String toString() {
        return "Hands_Navarro{" +
                "color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", haveHands=" + haveHands +
                '}';
    }
}