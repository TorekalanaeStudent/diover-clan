package implementations;

import abstract_classes.AvatarCore_Nono;
import interfaces.FireAvatarSystem_Nono;

public class FireAvatarWarrior_Cardeno extends AvatarCore_Nono implements FireAvatarSystem_Nono {

    // additional attribute (composition)
    private String tribalWeapon;

    // default constructor 
    public FireAvatarWarrior_Cardeno() {
        super("Na'vi Warrior", "Fire-Earth Balance", 110, 10);
        this.tribalWeapon = "Bow of Pandora";
    }

    // parameterized constructor
    public FireAvatarWarrior_Cardeno(String avatarName, String affinity, int stamina, int experience, String tribalWeapon) {
        super(avatarName, affinity, stamina, experience);
        this.tribalWeapon = tribalWeapon;
    }

    // getter & setter
    public String getTribalWeapon() {
        return tribalWeapon;
    }
    public void setTribalWeapon(String tribalWeapon) {
        this.tribalWeapon = tribalWeapon;
    }

    // overloading methods
    public void useSkill(int cost) {  
        System.out.println(avatarName + " channels Pandora energy for a strike!");
    }
    public void useSkill(int cost, String target) {  
        System.out.println(avatarName + " strikes " + target + " using Pandora's flame energy!");
    }
    public void performAttack() {  
        System.out.println(avatarName + " attacks using " + tribalWeapon + " from Pandora forest!");
    }
    public void performAttack(String target) {  
        System.out.println(avatarName + " attacks " + target + " with a sacred Na'vi strike!");
    }

    // overriding methods
    @Override
    public void performDefense() {   
        System.out.println(avatarName + " connects with Eywa for protection!");
    }
    @Override
    public void performSpecialAttack() {   
        System.out.println(avatarName + " unleashes a Pandora Spirit Flame!");
    }
    @Override
    public String getAvatarType() {   
        return "Na'vi Fire Warrior";
    }
}