package parent_class;

public class Tank_Malig {

    // attributes
    protected String model;
    protected int armor;
    protected int ammo;
    protected boolean isActive;

    // default constructor
    public Tank_Malig() {
        model = "null";
        armor = 0;
        ammo = 0;
        isActive = false;
    }

    // parameterized constructor
    public Tank_Malig(String model, int armor, int ammo, boolean isActive) {
        this.model = model;
        this.armor = armor;
        this.ammo = ammo;
        this.isActive = isActive;
    }

    // methods
    public void move() {
        System.out.println("Tank is moving forward");
    }

    public void attack() {
        System.out.println("Tank fires its cannon");
    }

    // method to override
    public void defend() {
        System.out.println("Tank activates basic armor defense");
    }
}