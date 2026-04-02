package abstract_classes;

/**
 * @author Canillo, Diover Vincent L.
 * @TorekalanaeStudent 
 */

public abstract class Bender_Canillo{
    private String name; // Canillo (default)
    private String elementStyle; // Earth (default) 
    private int health;
    private int age;
    private boolean healthSet;
    private boolean ageSet;

    // Getters
    public String getName(){ return this.name; }

    public String getElementStyle(){ return this.elementStyle; }
    
    public int getHP(){ return this.health; }

    public int getAge(){ return this.age; }

    // Setters
    public void setName(String name){
        // rule validation (cannot be empty)
        if(name.isBlank() || name.equals(null)){ // if name is null or blanked
            System.out.println("Please input a name! Default name is: \"Canillo\".");
            this.name = "Canillo";
            return; // stops
        } 
        this.name = name;
    }

    public void setElementStyle(String element){
        // rule validation (cannot be empty)
        if(element.isBlank() || element.equals(null)){
            System.out.println("Input an element! Default element is: \"Earth\"");
            this.elementStyle = "Earth"; // default value
            return; // stops
        }
        this.elementStyle = element;
    }

    public void setHP(int health){
        // rule validation (health cant be negative and also be above 100)
        if(health > 100 || health < 0){
            System.out.println("Put a valid health! (0-100)!");
            this.health = (healthSet) ? this.health : 100; // default health = 100
            return;
        }
        this.health = health;
        healthSet = true;
    }

    public void setAge(int age){
        // rule validation (age cannot surpass 150 since it is the hardlocked age for them)
        if(age > 150 || age < 0){
            System.out.println("Input a valid age (0-150)!");
            this.health = (ageSet) ? this.age : 33; // default age = 33 
            return;
        }
        this.age = age;
        ageSet = true; 
    }

    // Concrete method
    public void takeDamage(int dmg){
        // rule validation (damage cannot be more than the health)
        if(dmg > this.health){
            System.out.println("Damage cannot be more than health.");
            return;
        }
        System.out.println(name +" took a hit and was damaged " + dmg + "HP");
        this.health -= dmg;
    }    

    // Abstract method
    public abstract void heal(int heal);
}