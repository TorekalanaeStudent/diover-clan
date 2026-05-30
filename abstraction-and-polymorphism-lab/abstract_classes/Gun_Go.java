package abstract_classes;

/*
* @author Go Sean Ethan G.
* @SethPlaysBadly
*/


public abstract class Gun_Go {

    private String name;
    private String caliber;
    private int magazineCapacity;
    private int magazineAmmoCount;
    private int durability;
    private boolean canJam;
  
    // Default Constructor
     public Gun_Go() {
      
        this.name = "";
        this.caliber = "";
        this.magazineCapacity = 0;
        this.magazineAmmoCount = 0;
        this.durability = 0;
        this.canJam = false;
      
    }
    // Parameterized Constructor
    public Gun_Go(String name, String caliber, int magazineCapacity, int magazineAmmoCount, int durability, boolean canJam) {
      
        this.name = name;
        this.caliber = caliber;
        this.magazineCapacity = magazineCapacity;
        this.magazineAmmoCount = magazineAmmoCount;
        this.durability = durability;
        this.canJam = canJam;
      
    }

    // Abstract Method 

    public abstract void reload (); // abstract here so reload can make use of the variable values here

    // Concrete Method
  
    public void inspect() {
      
    System.out.println(name + " is ready.");
      
    }
  
    // Getters
  
    public String getName(){
      
    return this.name; 
   
    }

    public String getCaliber(){
      
    return this.caliber; 
    
    }
      
    public int getMagazineCapacity(){
      
    return this.magazineCapacity; 
   
    }
  
    public int getMagazineAmmoCount(){
      
    return this.magazineAmmoCount; 
   
    }
      
    public int getDurability(){
      
    return this.durability; 
   
    }
  
    public boolean isCanJam() {
      
    return this.canJam;
      
    }
   
    // Setters
  
    public void setName(String name){
      
    this.name = name;
 
    }
  
    public void setCaliber(String caliber){
      
    this.caliber = caliber;
   
    }

    public void setMagazineCapacity(int magazineCapacity){
      // verification steps for unintended variables
    if (magazineCapacity <= 0) {
    this.magazineCapacity = 1;
    System.out.println("Magazine capacity must be at least 1.");
    } 
    else {
        this.magazineCapacity = magazineCapacity;
    }

    
    if (this.magazineAmmoCount > this.magazineCapacity) {
        this.magazineAmmoCount = this.magazineCapacity;
    
    }
      
    }  
  
    public void setMagazineAmmoCount(int magazineAmmoCount){
      
    this.magazineAmmoCount = magazineAmmoCount; 
     
    }
      
    public void setDurability(int durability){
      
    if (durability > 100) { // verification steps for unintended variables
    this.durability = 100;
    System.out.println("Durability value must not exceed 100, setting to maximum value...");
      
    } else if (durability < 0) {
    this.durability = 0;
    System.out.println("Durability value must not reach negative, setting to minimum value...");  
    
    } else {  
    this.durability = durability;
    System.out.println("Durability set...");
      
    }
      
    }  
      
    public void setCanJam(boolean canJam){
    this.canJam = canJam;
      
      
    }
  
}