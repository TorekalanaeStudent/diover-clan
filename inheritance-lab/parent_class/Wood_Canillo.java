package parent_class;

public class Wood_Canillo{

    // Static Attributes
    protected static boolean flammable;

    // Normal Attributes
    protected String woodType;
    protected String woodColor;
    protected String woodName;

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
