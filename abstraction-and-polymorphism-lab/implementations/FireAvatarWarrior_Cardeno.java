package implementations;

import abstract_classes.AvatarCore_Nono;
import interfaces.FireAvatarSystem_Nono;

/**
 * @author @flcardeno (Cardeño, Faye L.) 
*/

public class FireAvatarWarrior_Cardeno extends AvatarCore_Nono implements FireAvatarSystem_Nono {

    // additional attribute (composition)
    private String weapon;

    // default constructor
    public FireAvatarWarrior_Cardeno() {
        super("Neytiri", "Fire", 100, 0);
        this.weapon = "Basic Sword";
    }

    // parameterized constructor
    public FireAvatarWarrior_Cardeno(String avatarName, String affinity, int stamina, int experience, String weapon) {
        super(avatarName, affinity, stamina, experience);
        this.weapon = weapon;
    }

    // getter and setter
    public String getWeapon() {
        return weapon;
    }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    // overloading methods
    public void useSkill(int cost) {   
        System.out.println(avatarName + " uses fire slash!");
    }
    public void useSkill(int cost, String target) {   
        System.out.println(avatarName + " attacks " + target + " with fire slash!");
    }
    public void performAttack() {   
        System.out.println(avatarName + " attacks using " + weapon);
    }
    public void performAttack(String target) {   
        System.out.println(avatarName + " attacks " + target + " using " + weapon);
    }

    // overriding methods
    @Override
    public void performDefense() {   
        System.out.println(avatarName + " creates fire shield!");
    }
    @Override
    public void performSpecialAttack() {  
        System.out.println(avatarName + " unleashes FIRE STORM!");
    }
    @Override
    public String getAvatarType() {  
        return "Fire Avatar Warrior";
    }
}