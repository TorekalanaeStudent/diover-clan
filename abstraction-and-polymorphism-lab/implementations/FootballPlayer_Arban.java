package implementations;

import abstract_classes.Athlete_Obedoza;
import interfaces.Competitive_Obedoza;

public class FootballPlayer_Arban extends Athlete_Obedoza implements Competitive_Obedoza {

    // attributes
    private double passingAccuracy;
    private String position;
    private boolean defending;

    // default Constructor
    public FootballPlayer_Arban() {
        super("Lionel Messi", "Football", 170, true, "cm");
        setPassingAccuracy(94);
        setPosition("Forward");
        this.defending = false;
    }

    // parameterized Constructor
    public FootballPlayer_Arban(String name, int height, boolean activeStatus,
                                double passingAccuracy, String position) {
        super(name, "Football", height, activeStatus, "cm");
        setPassingAccuracy(passingAccuracy);
        setPosition(position);
        this.defending = false;
    }

    // abstract methods
    @Override
    public void performAcceleration() {
        System.out.println(getName() + " bursts forward with incredible pace!");
    }

    @Override
    public void reactToGameEvent() {
        System.out.println(getName() + " reacts instantly and creates a scoring chance!");
    }

    // custom role logic
    public String getPlayerLevel() {
        if (passingAccuracy >= 90) {
            return "Playmaker " + position;
        } else if (passingAccuracy >= 75) {
            return "Elite " + position;
        } else if (passingAccuracy >= 50) {
            return "Skilled " + position;
        } else {
            return "Beginner " + position;
        }
    }

    // private helper method
    private void passBall(String teammate) {
        System.out.println(getName() + " passes the ball to " + teammate + "!");
        this.defending = false;
    }

    // interface method
    @Override
    public void compete(String focused, int adrenalineLevels) {
        System.out.println(getName() + " is competing with focus: " + focused +
                " and adrenaline level: " + adrenalineLevels);
    }

    // overloaded method
    public void compete(String focused, int adrenalineLevels, int assists) {
        compete(focused, adrenalineLevels);
        System.out.println("Made " + assists + " assists!");
    }

    // defensive action
    public void defendPlayer(String opponent) {
        System.out.println(getName() + " is marking " + opponent + " closely!");
        this.defending = true;
    }

    // action method
    public void playOffense(String teammate) {
        passBall(teammate);
    }

    // getters
    public double getPassingAccuracy() { return passingAccuracy; }
    public String getPosition() { return position; }
    public boolean isDefending() { return defending; }

    // setters with validation
    public void setPassingAccuracy(double passingAccuracy) {
        if (passingAccuracy < 0 || passingAccuracy > 100) {
            System.out.println("Invalid passing accuracy!");
        } else {
            System.out.println("Passing accuracy set to: " + passingAccuracy);
            this.passingAccuracy = passingAccuracy;
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