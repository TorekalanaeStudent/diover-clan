package parent_class;

public class Wood_Canillo{

    // Static Attributes
    private static boolean flammable;

    // Normal Attributes
    private String woodType;
    private String woodColor;
    private String woodName;

    // Default Constructor
    public Wood_Canillo(){
        this.flammable = true;
        this.woodType = "Oak";
        this.woodColor = "Brown";
        this.woodName = "Canillo's Wood";
    }

    // 2 Behaviors
    public void burn(){
        System.out.println(flammable ? getWoodName() + " is burning." : getWoodName() + " is flame resistant.");
    }

    // Overridable Behavior
    public void knock(){
        System.out.println("You knocked on the wood for 3 times to avoid badluck");
    }

    // Getters
    public String getWoodName(){
        return this.woodName;
    }

}