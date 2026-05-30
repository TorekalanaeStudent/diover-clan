package abstract_classes;

public abstract class Athlete_Obedoza {
    // Attributes
    private String name; 
    private String sport;
    private int height;
    private boolean activeStatus;
    private String heightSymbol = "cm";

    // Default Construcor
    public Athlete_Obedoza () {
        this.name = "Cristiano Ronaldo";
        this.sport = "Football";
        this.height = 187;
        this.activeStatus = true;
        this.heightSymbol = "cm";
    }

    // Parameterized Constructor
    public Athlete_Obedoza (String name, String sport, int height, boolean activeStatus, String heightSymbol) {
        this.name = name;
        this.sport = sport;
        this.height = height;
        this.activeStatus = activeStatus;
        this.heightSymbol = heightSymbol;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getSport() {
        return this.sport;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean isActive() {
        return this.activeStatus;
    }

    public String getHeightSymbol() {
        return this.heightSymbol;
    }

    // Setters
    public void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
             System.out.println("You need to enter a name.");
        }
    }

    public void setSport(String sport) {
        if (!sport.trim().isEmpty()) {
            this.sport = sport;
        } else {
             System.out.println("You need to enter a sport.");
        }
    }

    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Number must not be less than zero.");
        }
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public void setHeightSymbol(String heightSymbol) {
        this.heightSymbol = heightSymbol;
    } 

    // Abstract methods
    public abstract void performAcceleration();
    public abstract void reactToGameEvent();

    // Concrete methods 
    public void rest() {
        System.out.println(sport + " athlete " + name + " is " +
            (activeStatus ? "Active" : "Inactive"));

    }




}