

public class LibraryComputer{
    private static int libComputers = 12;

    private boolean compUsed;
    private String compColor;
    private boolean compBroken;
    private int compNum;

    // Default Constructor
    public LibraryComputer(){
        this.compUsed = false;
        this.compColor = "black";
        this.compBroken = false;
        this.compNum = 3;
    }

    // Overloading Constructor
    public LibraryComputer(String color, int compNum){
        this();
        this.compColor = color;
        this.compNum = compNum;
    }

    // Parameterized Constructor
    public LibraryComputer(boolean used, String color, boolean broken, int num){
        this.compUsed = used;
        this.compColor = color;
        this.compBroken = broken;
        this.compNum = num;
    }

    // Behavior: Print details of the computer
    public void compDetails(){
        System.out.println(this.compUsed ? "This computer is being used." : "This computer is not being used.");
        System.out.println("The color of this computer is: " + this.compColor + ".");
        System.out.println(this.compBroken ? "This computer is broken." : "This computer is not broken.");
        System.out.println("The number of this computer is: " + compNum);
    }

    // Getters:

    public boolean getUsed(){
        return this.compUsed;
    }

    public String getColor(){
        return this.compColor;
    }

    public boolean getStatus(){
        return this.compBroken;
    }

    public int getNum(){
        return this.compNum;
    }

    public int getQuantity(){
        return this.libComputers;
    }

    // Setters:

    public void setUsed(boolean used){
        this.compUsed = used;
    }

    public void setColor(String color){
        this.compColor = color;
    }
    
    public void setStatus(boolean status){
        this.compBroken = status;
    }
    
    public void setQuantity(int quantity){
        if (quantity > 0 && quantity < 12) this.libComputers = quantity;
        // reason for 12 is becuase theres no more spaces in library hehe
    }

}