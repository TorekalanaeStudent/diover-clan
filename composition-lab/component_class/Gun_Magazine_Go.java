package component_class;

public class Gun_Magazine_Go {
  
    private String projectile;
    private int capacity = 30;
    private int projectileAmount;
  
     // Constructor
    public Gun_Magazine_Go(String projectile, int projectileAmount) {
    this.projectile = projectile;
    this.projectileAmount = projectileAmount;
      
    }
  
    //Feeding Issue Checker 
    public boolean hasFeedingIssue() {
        return projectileAmount > capacity;
    }
  
    //Setters
    public void setProjectile(String projectile) {
        this.projectile = projectile;
      
    }
  
    public void setProjectileAmount(int projectileAmount) {
        this.projectileAmount = projectileAmount;
      
    }
   
    //Getters
    public String getProjectile() {
        return projectile;
      
    }
  
    public int getProjectileAmount() {
        return projectileAmount;
      
    }
  
    //Behaviors
    
    public void inspectProjectile() {
        System.out.println("The projectile being used is/are " + projectile + ".");
    }
  
    public void inspectProjectileAmount() {
        System.out.println("The amount of " + projectile + " in the magazine equates to " + projectileAmount + ".");
    }
  
    public void inspectFeedingIssue() {
        if (hasFeedingIssue()) {
        System.out.println("There are too many " + projectile + " there will be a feeding issue.");
        } else {
        System.out.println("Projectile amount does not exceed " + capacity + ", there will be no feeding issue.");
        }
      
    }

    public void launchProjectile() {
    if (projectileAmount > 0) {
        System.out.println("Pew! The " + projectile + " has been launched.");
        projectileAmount--;
    } else {
        System.out.println("No ammo left.");
    }
      
    }
    public void describe() {
        System.out.println("[ Gun Magazine Details ]");
        System.out.println("Projectile: " + projectile);
        System.out.println("Capacity: " + capacity);
        System.out.println("Amount of " + projectile + ": " + projectileAmount);
        System.out.println("Has Feeding Issue: " + hasFeedingIssue());
    }
      
}
