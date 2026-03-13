public class Sorcerer {

    private String name;
    private String codeName;
    private String cursedTechnique;
    // Object Invariant - A sorcerer should always have an affiliation
    private boolean isEvil = false;

    private boolean canOpenDomain = false;

    private double cursedEnergy = 100;

    private static String school = "NU Laguna";

    private String grade;

    public Sorcerer() {
        this.name = "Unknown Sorcerer";
        this.isEvil = true;
        this.cursedTechnique = "Unknown";
    }

    public Sorcerer(String name, String cursedTechnique, boolean isEvil) {
        this.name = name;
        this.cursedTechnique = cursedTechnique;
        this.isEvil = false;
    }

    public String getName() { return this.name; }

    public double getEnergy() { return this.cursedEnergy; }

    public boolean isEvil() { return this.isEvil; }

    public String getGrade() { return this.grade; }

    public void setGrade(String grade) {
        if(grade == "1" && this.cursedEnergy > 1000) {
            this.grade = "1";
        }
        if(grade == "special" && this.cursedEnergy > 10000) {
            this.grade = "special";
        }
        System.out.println(this.name + "'s grade was changed to " + this.grade);
    }

    public void changeAffiliation() {
        this.isEvil = !isEvil;
    }

    public void setCursedTechnique(String cursedTechnique) {
        if(cursedTechnique != "")
            this.cursedTechnique = cursedTechnique;
    }

    public void setCodeName(String codeName) {
        if(name != "" && codeName != "")
            this.codeName = codeName;
    }

    public void setCanOpenDomain(boolean canOpenDomain) {
        if(canOpenDomain == true && cursedEnergy > 1000)
            this.canOpenDomain = true;
        if(cursedEnergy < 1000)
            this.canOpenDomain = false;
        
    }

    public void setCursedEnergy(double cursedEnergy) {
        //Object Invariant - sorcerers should at least have 100 cursed energy
        if(cursedEnergy < 100) {
            System.out.println("Invalid! A sorcerer must have at least 100 CE.");
            return;
        }
        this.cursedEnergy = cursedEnergy;       
    }

}