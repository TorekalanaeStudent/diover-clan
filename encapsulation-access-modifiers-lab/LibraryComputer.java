public class LibraryComputer{
    private static int libComputers = 12;
    private static String libraryStatus; // Open // Closed // Maintenance

    private boolean compUsed;
    private String compColor;
    private boolean compBroken;
    private int compNum;
    private int pricePerHour;

    // Default Constructor
    public LibraryComputer(){
        this.compUsed = false;
        this.compColor = "black";
        this.compBroken = false;
        this.compNum = 3;
        this.libraryStatus = "Open";
    }

    // Overloading Constructor
    public LibraryComputer(String color, int compNum, int status){
        this();
        this.compColor = color;
        this.compNum = compNum;
        status(status);
    }

    // Parameterized Constructor
    public LibraryComputer(boolean used, String color, boolean broken, int num, int status){
        this.compUsed = used;
        this.compColor = color;
        this.compBroken = broken;
        this.compNum = num;
        status(status);
    }

    // Behavior: Print details of the computer
    public void compDetails(){
        System.out.println(this.compUsed ? "This computer is being used." : "This computer is not being used.");
        System.out.println("The color of this computer is: " + this.compColor + ".");
        System.out.println(this.compBroken ? "This computer is broken." : "This computer is not broken.");
        System.out.println("The number of this computer is: " + compNum);
        System.out.println("The library is: " + this.libraryStatus);
    }

    // only used in this class
    private void status(int status){
        switch(status){
            case 1 : 
                this.libraryStatus = "Open";
                break;
            case 2 :
                this.libraryStatus = "Closed";
                break;
            case 3 :
                this.libraryStatus = "Maintenance";
                break;
            default :
                this.libraryStatus = "Closed";
                break;
        }
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

    public int getPrice(){
        return this.pricePerHour;
    }

    public String getLibStatus(){
        return this.libraryStatus;
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
    
    // rule validation 1:
    public void setQuantity(int quantity){
        if (quantity > 0 && quantity < 12) this.libComputers = quantity;
        // reason for 12 is becuase theres no more spaces in library hehe
    }

    // rule validation 2:
    public void setPrice(int price){
       if (price >= 10 ) this.pricePerHour = price; 
    }

    // rule validation 3:
    public void setLibStatus(int libStatus){
        // 1 = Open
        // 2 = Closed OR any other number
        // 3 = Maintenance
        status(libStatus);
    }
}
