package abstract_classes;

/*
* @author Ablis, Margreleigne M.
* @matidagreat
*/

public abstract class Superhero_Ablis {
    private String name;
    private int age;
    private int speed; // MPH
    private String ability; // flying, time travel, webbing, etc...

    // Default Constructor
    public Superhero_Ablis() {
        setName("Ablis");
        setAge(19);
        setSpeed(700);
        setAbility("flying");
    }

    // Parameterized Constructor
    public Superhero_Ablis(String name, int age, int speed, String ability) {
        setName(name);
        setAge(age);
        setSpeed(speed);
        setAbility(ability);
    }

    // abstract methods
    public abstract void usePower();
    public abstract void saveTheDay();

    // concrete method
    public void introduce() {
        System.out.println("Greetings! I'm " + name + ", a superhero with the power of " + ability + " and speed of " + speed + " MPH!");
    }

    // Getters and Setters
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getSpeed() { return speed; }
    public String getAbility() { return ability; }

    public void setName(String name) {
        if(name.isBlank()) { // rule validation for  name
            System.out.println("Name cannot be blank. Setting to default name 'Ablis'.");
            name = "Ablis"; // default name
        }
        this.name = name;
    }

    public void setAge(int age) { 
        if (age <= 0) { // rule validation for age
            System.out.println("Age cannot be zero or negative. Setting to default age 19.");
            age = 19; // default age
        }
        this.age = age; 
    }

    public void setSpeed(int speed) { 
        if (speed <= 0) { // rule validation for speed
            System.out.println("Speed cannot be zero or negative. Setting to default speed 700.");
            speed = 700; // default speed
        }
        this.speed = speed; 
    }

    public void setAbility(String ability) { 
        if(ability.isBlank()) { // rule validation for ability
            System.out.println("Ability cannot be blank. Setting to default ability 'flying'.");
            ability = "flying"; // default ability
        }
        this.ability = ability; 
    }
}
