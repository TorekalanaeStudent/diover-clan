package implementations;

import abstract_classes.Athlete_Obedoza;
import interfaces.Competitive_Obedoza;

public class BasketballPlayer_Arban extends Athlete_Obedoza implements Competitive_Obedoza {

    // attributes
    private double shootingAccuracy;
    private String position;
    private boolean defending;

    // default Constructor
    public BasketballPlayer_Arban() {
        super("Stephen Curry", "Basketball", 188, true, "cm");
        setShootingAccuracy(95);
        setPosition("Point Guard");
        this.defending = false;
    }

    // parameterized Constructor
    public BasketballPlayer_Arban(String name, int height, boolean activeStatus,
                                    double shootingAccuracy, String position) {
        super(name, "Basketball", height, activeStatus, "cm");
        setShootingAccuracy(shootingAccuracy);
        setPosition(position);
        this.defending = false;
    }

    // abstract method
    @Override
    public void performAcceleration() {
        System.out.println(getName() + " drive and floater high arc shot!");
    }

    @Override
    public void reactToGameEvent() {
        System.out.println(getName() + " reacts quickly and takes a shot!");
    }

    // custom role logic (like getRole)
    public String getPlayerLevel() {
        if (shootingAccuracy >= 90) {
            return "Sharpshooter " + position;
        } else if (shootingAccuracy >= 75) {
            return "Elite " + position;
        } else if (shootingAccuracy >= 50) {
            return "Skilled " + position;
        } else {
            return "Beginner " + position;
        }
    }

    // inteface method
    private void shoot(String defender) {
        System.out.println(getName() + " shoots over " + defender + "!");
        this.defending = false;
    }

    @Override
    public void compete(String focused, int adrenalineLevels) {
        System.out.println(getName() + " is playing with focus: " + focused +
                " and adrenaline level: " + adrenalineLevels);
    }

    // overloaded method (like attack overload)
    public void compete(String focused, int adrenalineLevels, int score) {
        compete(focused, adrenalineLevels);
        System.out.println("Scored " + score + " points!");
    }

    // defensive action
    public void defendPlayer(String opponent) {
        System.out.println(getName() + " is defending against " + opponent + "!");
        this.defending = true;
    }

    // action method
    public void playOffense(String defender) {
        shoot(defender);
    }

    // getters
    public double getShootingAccuracy() { return shootingAccuracy; }
    public String getPosition() { return position; }
    public boolean isDefending() { return defending; }

    // setters with validation
    public void setShootingAccuracy(double shootingAccuracy) {
        if (shootingAccuracy < 0 || shootingAccuracy > 100) {
            System.out.println("Invalid shooting accuracy!");
        } else {
            System.out.println("Shooting accuracy set to: " + shootingAccuracy);
            this.shootingAccuracy = shootingAccuracy;
        }
    }

    public void setPosition(String position) {
        if (position == null || position.isBlank()) {
            System.out.println("Position cannot be empty!");
        } else {
            System.out.println("Position set to: " + position);
            this.position = position;
        }
    }
}