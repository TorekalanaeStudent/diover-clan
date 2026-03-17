package parent_class;

  public class Gun_Go {

  // Variables
  protected String name;
  protected String caliber;
  protected int capacity;
  
  public Gun_Go()	 {
    
   //Attribute of Parent Class
   name = "AK-47";
   caliber = "7.62x39mm";
   capacity = 30;
    
  }
  // Behavior Methods
  public void shoot() {
    
   System.out.println(name + " shoots " + capacity + " rounds of " + caliber);
    
  }
  
  public void reload() {
    
   System.out.println(name + " reloads a " + capacity + " round magazine of " + caliber);
    
  }
  
  }