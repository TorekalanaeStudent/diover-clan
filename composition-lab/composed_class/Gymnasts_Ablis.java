package composed_class;

import component_class.Clothes_Obedoza;
import component_class.Leg_Canillo;
import component_class.Hands_Navarro;

/**
 * Composed Class
 * Gymnasts_Ablis HAS-A Clothes_Obedoza
 * Gymnasts_Ablis HAS-A Leg_Canillo
 * Gymnasts_Ablis HAS-A Hands_Navarro
 * @author Ablis
 */
public class Gymnasts_Ablis {
    // Attributes
    private String gymnastName;
    private boolean isPerforming; // true = performance successful, false = performance failed
    private boolean strongGrip; // true = strong, false = weak
    private Clothes_Obedoza clothes;
    private Leg_Canillo leg;
    private Hands_Navarro hands;

    // default constructor
    public Gymnasts_Ablis() {
        gymnastName = "Ablis"; // Me
        isPerforming = false; // not performing by default
        strongGrip = true; // I have a strong grip
        clothes = new Clothes_Obedoza("Leotards", "Blue", "Medium"); // clothe type, color, size
        leg = new Leg_Canillo(5, 30.0, 18.0); // toes count, leg size (cm), speed (mph)
        hands = new Hands_Navarro("Dark Brown", "Medium", true); // skin color, hand size, has hands
    }   

    // parameterized constructor
    public Gymnasts_Ablis(String gymnastName, boolean isPerforming, boolean strongGrip, Clothes_Obedoza clothes, Leg_Canillo leg, Hands_Navarro hands) {
        this.gymnastName = gymnastName;
        this.isPerforming = isPerforming;
        this.strongGrip = strongGrip;
        this.clothes = clothes;
        this.leg = leg;
        this.hands = hands;
    }

    // Getters
    public String getGymnastName() {
        return gymnastName;
    }

    public boolean isPerforming() {
        return isPerforming;
    }

    public boolean isStrongGrip() {
        return strongGrip;
    }

    public Clothes_Obedoza getClothes() {
        return clothes;
    }

    public Hands_Navarro getHands() {
        return hands;
    }

    public Leg_Canillo getLeg() {
        return leg;
    }

    // Setters
    public void setGymnastName(String gymnastName) {
        this.gymnastName = gymnastName;
    }

    public void setPerforming(boolean isPerforming) {
        this.isPerforming = isPerforming;
    }

    public void setStrongGrip(boolean strongGrip) {
        this.strongGrip = strongGrip;
    }

    public void setClothes(Clothes_Obedoza clothes) {
        this.clothes = clothes;
    }

    public void setLeg(Leg_Canillo leg) {
        this.leg = leg;
    }

    public void setHands(Hands_Navarro hands) {
        this.hands = hands;
    }

    // Behaviors
    public void performSuccess() {
        this.isPerforming = true;
        System.out.println(gymnastName +" performs successfully in " + clothes.getClotheType() + " " + clothes.getClotheColor() + " " + clothes.getSize() + " clothes! Its grip strength is " + (strongGrip ? "strong" : "weak") + " and leg speed is " + leg.getRunSpeed() + " mph.");
    }

    public void performFailure() {
        this.isPerforming = false;
        System.out.println(gymnastName + " fails the performance in " + clothes.getClotheType() + " " + clothes.getClotheColor() + " " + clothes.getSize() + " clothes. Its grip strength is " + (strongGrip ? "strong" : "weak") + " and leg speed is " + leg.getRunSpeed() + " mph.");
    }

    public void performanceReport() {
        System.out.println("=== Performance Report for " + gymnastName + " ===");
        System.out.println("Clothe Type: " + clothes.getClotheType() + ", Color: " + clothes.getClotheColor() + ", Size: " + clothes.getSize());
        System.out.println("Leg: Toes Count: " + leg.getToes() + ", Leg Size: " + leg.getLegSize() + " cm, Speed: " + leg.getRunSpeed() + " mph");
        System.out.println("Hands: Color: " + hands.getSkinTone() + ", Size: " + hands.getHandSize() + ", Grip Strength: " + (strongGrip ? "Strong" : "Weak"));
    }
}   

