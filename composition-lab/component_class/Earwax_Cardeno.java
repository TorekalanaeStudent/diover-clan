package component_class;

public class Earwax_Cardeno {
    
    private int amount;      
    private String color;
    private String texture;

    // constructor
    public Earwax_Cardeno(int amount, String color, String texture) {
        setAmount(amount);    
        this.color = color;
        this.texture = texture;
    }

    // getters
    public int getAmount() { 
        return amount; 
    }
    public String getColor() { 
        return color; 
    }
    public String getTexture() { 
        return texture; 
    }

    // setters
    public void setAmount(int amount) {
        if (amount < 0) {
            System.out.println("Amount cannot be negative.");
            this.amount = 0;
        } else {
            this.amount = amount;
        }
    }
    public void setColor(String color) { 
        this.color = color; 
    }
    public void setTexture(String texture) { 
        this.texture = texture; 
    }

    // behaviors
    public void add(int value) { 
        if (value > 0) {
            amount += value; 
        }
    }
    public void clean(int value) { 
        if (value > 0) {
            amount -= value; 
            if(amount < 0) amount = 0; 
        }
    }

    // is used to display 
    public void showInfo() {
        System.out.println("Earwax -> Amount: " + amount + "mg, Color: " + color + ", Texture: " + texture);
    }
}