package implementations;

import abstract_classes.AvatarCore_Nono;
import interfaces.FireAvatarSystem_Nono;

public class FireAvatarSoldier_Cardeno extends AvatarCore_Nono implements FireAvatarSystem_Nono {

    // additional attribute (composition)
    private String militaryRole;

    // default constructor
    public FireAvatarSoldier_Cardeno() {
        super("RDA Soldier Avatar", "Fire-Tech Affinity", 120, 20);
        this.militaryRole = "Security Unit";
    }

    // parameterized constructor
    public FireAvatarSoldier_Cardeno(String avatarName, String affinity, int stamina, int experience, String militaryRole) {
        super(avatarName, affinity, stamina, experience);
        this.militaryRole = militaryRole;
    }

    // getter and setter
    public String getMilitaryRole() {
        return militaryRole;
    }
    public void setMilitaryRole(String militaryRole) {
        this.militaryRole = militaryRole;
    }

    // overloading methods
    public void useSkill(int cost) {   
        System.out.println(avatarName + " activates combat protocol in Pandora operations.");
    }
    public void useSkill(int cost, String target) {   
        System.out.println(avatarName + " engages target " + target + " in mission zone.");
    }
    public void performAttack() {   
        System.out.println(avatarName + " performs coordinated strike using advanced equipment.");
    }
    public void performAttack(String target) {  
        System.out.println(avatarName + " targets " + target + " during Pandora operation.");
    }

    // overriding methods
    @Override
    public void performDefense() {   
        System.out.println(avatarName + " activates defensive shield protocol.");
    }
    @Override
    public void performSpecialAttack() {   
        System.out.println(avatarName + " launches full tactical assault sequence.");
    }
    @Override
    public String getAvatarType() {  
        return "Fire Avatar Soldier";
    }
}