package sub_class;

import component_class.Gun_Magazine_Go;

/**
 * This is the Subclass
 * @author NavarroVinceJustine
 */
public class Musket_Navarro extends Gun_Magazine_Go {

    private String musketModel;

    // Constructor 
    public Musket_Navarro(String projectile, int projectileAmount, String musketModel) {
        super(projectile, projectileAmount);   
        this.musketModel = musketModel;
    }

    // Getter & Setter 
    public String getMusketModel() {
        return musketModel;
    }

    public void setMusketModel(String musketModel) {
        this.musketModel = musketModel;
    }

    // Overridden Behaviors 
    @Override
    public void launchProjectile() {
        if (getProjectileAmount() > 0) {
            System.out.println("HITTT! The dragoon loads and fires a " + getProjectile() 
            + " from their " + musketModel + "!!!!");
            System.out.println("A cloud of black powder smoke fills the air...");
            setProjectileAmount(getProjectileAmount() - 1);
        } else {
            System.out.println("The " + musketModel + " is now empty. The dragoon make his last stand as "
            		+ "he reaches for his sword!");
        }
    }

    @Override
    public void inspectProjectile() {
        System.out.println("The dragoon inspects their " + getProjectile() );
    }
    
    @Override
    public void describe() {
        System.out.println("[ Musket Ball Pouch Details ]");
        System.out.println("Musket Model : " + musketModel);
        System.out.println("Projectile   : " + getProjectile());
        System.out.println("Capacity     : 30");
        System.out.println("Amount left  : " + getProjectileAmount());
        System.out.println("Feeding Issue: " + hasFeedingIssue());
    }
}