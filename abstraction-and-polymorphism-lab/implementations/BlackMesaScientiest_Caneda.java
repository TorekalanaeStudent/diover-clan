package implementations;

/**
 * @author Caneda, Ramil Jr M.
 * @Rcaneda
 */

import abstract_classes.GameCharacter_Navarro;
import interfaces.CombatSystem_Navarro;

public class BlackMesaScientist_Caneda extends GameCharacter_Navarro implements CombatSystem_Navarro {

//Attributes 
 private boolean shieldIsDepleted;
 private boolean isGettingAttacked;
 private String BlackMesaRole;
 private int shield;
 private int maxHealth;
 


//Constructors

//Default 
public BlackMesaScientist_Caneda() {
super("Gordon Freeman", 100);
setShield(100);
setMaxHealth(100);
}

//Parametarized
public BlackMesaScientist_Caneda(String name, int health, int shield, int maxHealth) {
super(name, health);
setShield(shield);
setMaxHealth(maxHealth);
}

//Overrides

//getRole basically Gets 
@Override
public String getRole() {
    return getBlackMesaRole();
}

//getStatus basically first checks if shield is depleted, if it is then checks 
@Override
public String getStatus() {
 int getHealthPoints = getHealth();
if(shieldIsDepleted) {
        if (getHealthPoints >= (1*getMaxHealth())){
        return "Body In Perfect Condition";
    }
    else if(getHealthPoints >= (0.75*getMaxHealth())) {
        return "Body Condition intact";
    }
    else if(getHealthPoints >= (0.50*getMaxHealth())) {
        return "Minor Injuries";
    }
    else if (getHealthPoints >= (0.25*getMaxHealth())) {
        return "Critical Injuries";
    }
    else if (getHealthPoints >= (0.05*getMaxHealth())) {
        return "Death Imminent";
    }
    else {
        return "Dead";
    }
    }
else {
    return "Shield still active no damage";
    }
 
}
//Interface attacks the hostiles
@Override 
public void attack(GameCharacter_Navarro hostiles) {
    System.out.println(getName() + " Gets in position to attack" + hostiles.getName());
}

//Overloaded Attack (actual attack)
@Override
public void attack(GameCharacter_Navarro hostiles, int playerDamage) {
    System.out.println(getName() + " Shoots The Enemy " + hostiles.getName());
    hostiles.defend(playerDamage);
}
//Defend it basically chekcs if shield is depleted then it takes away healthpoints, if not it takes aways shield
@Override
public void defend(int playerDamage) {
    int defendedPlayerAttack = (getShield()- playerDamage);
    setShield(defendedPlayerAttack);
    setIsGettingAttacked(true);
    if(getShieldIsDepleted){
        setHealthPoints(getHealthPoints() - playerDamage); 
        if(getHealthPoints() <= 0){
            System.out.println(getName() + "Is Dead ");
        }
        else {
            System.out.println(getName() + "Was Damaged by "+ defendedPlayerAttack +" only "+getHealthPoints()+"HP is remaining");
        setIsGettingAttacked(false);
        }
    }
    else {
            System.out.println("Shield was damage by "+playerDamage+" only "+getShield()+" is remaining");
        setIsGettingAttacked(false);
    }  
}


//Getters

//Getter #1
public boolean getShieldIsDepleted(){
    return shieldIsDepleted;
}

//Getter #2
public String getBlackMesaRole(){
    return BlackMesaRole;
}

//Getter #3
public int getShield() {
    return shield;
}

//Getter #4
public int getMaxHealth() {
    return maxHealth; 
}
//Getter #5
public int getHealthPoints() {
    return healthPoints; 
}

//Setters

//Setter #1
public void setShieldIsDepleted(boolean shieldIsDepleted) {
    this.shieldIsDepleted = shieldIsDepleted;
}

//Setter #2
public void setBlackMesaRole(String BlackMesaRole) {
    if(getBlackMesaRole().isBlank() || getBlackMesaRole().equals(" ")){
        this.BlackMesaRole = "Scientist";
    }
    else {
    this.BlackMesaRole = BlackMesaRole;
    }
    
}

//Setters #3
public void setShield(int shield) {
 if(isGettingAttacked){
    this.shield = shield;
 }
 else {
       if(shield <= 0){
        this.shield = 100;
    }
    else{
    this.shield = shield;
    }
 }
}
//Setter #4
public void setMaxHealth(int maxHealth) {
    if(maxHealth <= 0) {
        this.maxHealth = 100;
    }
    else {
    this.maxHealth = maxHealth;
    }
}
//Setter #5
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
//Setter #6 
public void setIsGettingAttacked(boolean isGettingAttacked) {
    this.isGettingAttacked = isGettingAttacked;
} 
}
