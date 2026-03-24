package component_class;

public class Clothes_Obedoza {
    
    // Attributes 
    private String clotheType;
    private String clotheSize;
    private String clotheColor;
    private double clothePrice;

    // Constructors
    public Clothes_Obedoza (String clotheType, String clotheSize, String clotheColor, double clothePrice) {
        this.clotheType = clotheType;
        this.clotheSize = clotheSize;
        this.clotheColor = clotheColor;
        this.clothePrice = clothePrice;
    }

    // Getters
    public String getClotheType() {
        return clotheType;
    }

    public String getClotheSize() {
        return clotheSize;
    }

    public String getClotheColor() {
        return clotheColor;
    }

    public double getClothePrice() {
        return clothePrice;
    }

    // Setters
    public void setClotheType (String clotheType) {
        if (clotheType == null || clotheType.trim().isEmpty()) {
            System.out.println("Invalid Clothing Type!");
        return;
        }

        this.clotheType = clotheType;
    } 

    public void setClothePrice(double clothePrice) {
        if (clothePrice <= 0) {
            System.out.println("Invalid Pricing. Should be greater than zero!");
            return;
        }
        this.clothePrice = clothePrice;
    }

    // Methods/Behaviors
    public void buyClothing() {
        if (clothePrice <= 500.0) {
            System.out.println("Type: "+ clotheType);
            System.out.println("Size: " + clotheSize);
            System.out.println("Color: " + clotheColor);
            System.out.println("Price: " + clothePrice);
        } else {
            System.out.println("Too expensive!");
        }
    }

    public void chooseColor() {
        if (clotheColor.equalsIgnoreCase("Green")) {
            System.out.println("Buy this shirt!");
        } else {
            System.out.println("Try something else!");
        }
    }
}