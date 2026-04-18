package implementations;

/**
 * @author Caneda, Ramil Jr M.
 * @Rcaneda
 */

import abstract_classes.GameCharacter_Navarro;
import interfaces.CombatSystem_Navarro;


public class CourierSix_Caneda extends GameCharacter_Navarro implements CombatSystem_Navarro{

//Attributes 
 private boolean isGettingAttacked;
 private String factionAlignment;
 private int karmaLevel;
 private int maxHealth;
 private int healthPoints; //Localized from health to healtpoints for much more familiar atttribut.
 private int playerDamage;

//Constructors

//Constructor #1 Default
public CourierSix_Caneda() {
    super("Courier Six", 100);
    setHealthPoints(getHealthPoints());
    setFactionAlignment("NCR");
    setKarmaLevel(1000);
}

//Constructor #2 Parameterized
public CourierSix_Caneda(String name, int health, String factionAlignment, int karmaLevel){
    super(name, health);
    setHealthPoints(getHealth());
    setFactionAlignment(factionAlignment);
    setKarmaLevel(karmaLevel);
}   

//Overrides

//Basically uses the karma level, then depending if player is good, neutral, or not.
@Override
public String getRole() {
    if(karmaLevel >= 749 && karmaLevel <= 1000 ){
        return "Very Good";
    }
    else if(karmaLevel >= 250 && karmaLevel <= 749) {
        return "Good";
    }
    else if(karmaLevel >= -250 && karmaLevel <= 249) {
        return "Neutral";
    }
    else if(karmaLevel >= -749 && karmaLevel <= -249) {
        return "Evil";
    }
    else if(karmaLevel >= -1000 && karmaLevel <= -749) {
        return "Very Evil";
    }
    return "Uknown";
}

//Basically checks the healthpoints and this method gives out current status of player depending on healthpoints
@Override
public String getStatus() {
    if (getHealthPoints() >= (1*getMaximumHealth())){
        return "Body In Perfect Condition";
    }
    else if(getHealthPoints() >= (0.75*getMaximumHealth())) {
        return "Body Condition intact";
    }
    else if(getHealthPoints() >= (0.50*getMaximumHealth())) {
        return "Minor Injuries";
    }
    else if (getHealthPoints() >= (0.25*getMaximumHealth())) {
        return "Critical Injuries";
    }
    else if (getHealthPoints() >= (0.05*getMaximumHealth())) {
        return "Death Imminent";
    }
    else {
        return "Dead";
    }
}

//Interface attacks the hostiles
@Override 
public void attack(GameCharacter_Navarro hostiles) {
    System.out.println(getName() + " Gets in position to attack" + hostiles.getName());
}

//Overloaded Attack (actual attack)
public void attack(GameCharacter_Navarro hostiles, int playerDamage) {
    setPlayerDamage(playerDamage);
    System.out.println(getName() + " Shoots The Enemy " + hostiles.getName());
    ((CombatSystem_Navarro)hostiles).defend();
}

@Override
public void defend() {
    int defendedPlayerAttack = (int)(getPlayerDamage()*0.80);
    setIsGettingAttacked(true);
    setHealthPoints(getHealthPoints() - (int)defendedPlayerAttack);
    if(getHealthPoints() <= 0) {
        System.out.println(getName() + "Is Dead ");
    }
    else {
        System.out.println(getName() + "Was Damaged by "+ defendedPlayerAttack+" only "+getHealthPoints()+"HP is Remaining");
        setIsGettingAttacked(false);
    }
   
}

//Getters

//Getter #1 Gets Factiong Alignment
public String getFactionAlignment() {
    return factionAlignment;
}

//Getter #2 Gets Karma Level
public int getKarmaLevel() {
    return karmaLevel;
}

//Getter #3 Gets Maximum Health
public int getMaximumHealth() {
    return maxHealth;
}

//Getter #4 Gets Healthpoints
public int getHealthPoints() {
    return healthPoints;
}
//Getter #5 Gets player damage
public int getPlayerDamage() {
    return playerDamage; 
}
 
//Setters

//Setter #1 Sets faction Alignment if there is no faction then it would directly be "no faction"
public void setFactionAlignment(String factionAlignment) {
    if(getFactionAlignment().isBlank() || getFactionAlignment().equals(" ")) {
        this.factionAlignment = "No Faction";
    }
    else {
        this.factionAlignment = factionAlignment;
    }
    
}

//Setters #2 Sets Karma level ranging from -1000 maximum negativity, and 1000 being maximum positivity
public void setKarmaLevel(int karmaLevel) {
    this.karmaLevel = karmaLevel;
}

//Setters #3 sets users maximum health, if user has inputed negative it will go change value to a preset of 100
public void setMaxHealth(int maxHealth) {
    if(maxHealth <= 0) {
        this.maxHealth = 100;
    }
    else {
        this.maxHealth = maxHealth;
    }
}

//Setter #4 sets users actual healtpoints, if user has inputed negative it will go change value to a preset of 100
public void setHealthPoints(int healthPoints) {
 if(isGettingAttacked) {
    this.healthPoints = healthPoints;
 }
 else {
    if(healthPoints <= 0) {
        this.healthPoints = 100;
    }
    else {
        this.healthPoints = healthPoints;
    }
 }
}
//Setter #5 
public void setIsGettingAttacked(boolean isGettingAttacked) {
    this.isGettingAttacked = isGettingAttacked;
} 
//Setter #6
public void setPlayerDamage(int playerDamage) {
    this.playerDamage = playerDamage;
}
}
