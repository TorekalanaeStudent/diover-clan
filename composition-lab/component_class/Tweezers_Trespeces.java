package component_class;

public class Tweezers_Trespeces {
    
    // attributes
    private String material;
    private float length;
    private boolean isClean;

    // default constructor    
     public Tweezers_Trespeces() {
        material = "Stainless Steel";
        length = 67.0f;
        isClean = true;
     }
    
    // constructor
    public Tweezers_Trespeces(String material, float length, boolean isClean) {
    this.material = material;
    this.length = length;
    this.isClean = isClean;
    }

    // getters
    public String getMaterial(){
        return material;
    }
    public float getLength(){
        return length;
    }
    public boolean getIsClean(){
        return isClean;
    }
    // setters
    public void setMaterial(String material) {
        this.material = material;
    }
    public void setLength(float length) {
        this.length = length;
    }
    public void setIsClean(boolean isClean) {
        this.isClean = isClean;
    }

    // behaviours / methods
    public void grab() {
        System.out.println("The " + material + " tweezers successfully grabbed the nasal mucous secretion!");
    }

    public void dirtyOrNah() {
        if (isClean ==  true) {
            System.out.println("You can use the "+ material + " tweezers!");
        } else {
            System.out.println("Nah bro.");
        }
    }
}