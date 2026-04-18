package abstract_classes;

/**
 * @author Nono, Mary Angeline B.
 */

public abstract class AvatarCore_Nono {
    protected String avatarName;
    protected String affinity;
    protected int stamina;
    protected int experience;

    // =========================
    // Constructor
    // =========================
    public AvatarCore_Nono(String avatarName, String affinity, int stamina, int experience) {
        setAvatarName(avatarName);
        setAffinity(affinity);
        setStamina(stamina);
        setExperience(experience);
    }

    // =========================
    // Setters 
    // =========================
    public void setAvatarName(String avatarName) {
        if (avatarName == null || avatarName.isBlank()) {
            System.out.println("Invalid name. Default is 'Unknown Avatar'.");
            this.avatarName = "Unknown Avatar";
        } else {
            this.avatarName = avatarName;
        }
    }

    public void setAffinity(String affinity) {
        if (affinity == null || affinity.isBlank()) {
            System.out.println("Invalid affinity. Default is 'Neutral'.");
            this.affinity = "Neutral";
        } else {
            this.affinity = affinity;
        }
    }

    public void setStamina(int stamina) {
        if (stamina < 0 || stamina > 120) {
            System.out.println("Stamina must be between 0–120. Default is 80.");
            this.stamina = 80;
        } else {
            this.stamina = stamina;
        }
    }

    public void setExperience(int experience) {
        if (experience < 0 || experience > 1000) {
            System.out.println("Experience must be between 0–1000. Default is 100.");
            this.experience = 100;
        } else {
            this.experience = experience;
        }
    }

    // =========================
    // Abstract Methods
    // =========================
    public abstract void useSkill(int cost);
    public abstract String getAvatarType();

    // =========================
    // Concrete Method
    // =========================
    public void receiveAttack(int damage) {
        if (damage <= 0) {
            System.out.println("Damage must be positive.");
            return;
        }

        if (damage > stamina) {
            damage = stamina;
        }

        stamina -= damage;
        System.out.println(avatarName + " received " + damage + " damage. Remaining stamina: " + stamina);
    }

    // =========================
    // Getters
    // =========================
    public String getAvatarName() {
        return avatarName;
    }

    public String getAffinity() {
        return affinity;
    }

    public int getStamina() {
        return stamina;
    }

    public int getExperience() {
        return experience;
    }
}