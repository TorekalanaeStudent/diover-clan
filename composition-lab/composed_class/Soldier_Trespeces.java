package composed_class;

import component_class.Clothes_Obedoza;
import component_class.Gun_Magazine_Go;
import component_class.Kulangot;

public class Soldier_Trespeces {

    // attributes
    private String soldierName;
    private boolean isHealthy;
    private boolean isAlive;
   
    private Clothes_Obedoza clothes;
    private Gun_Magazine_Go gunMagazine;
    private Kulangot kulangot;

    // default constructor
    public Soldier_Trespeces() {
        soldierName = "Ayneedmo B. Lets";
        isHealthy = true;
        isAlive = true;
        clothes = new Clothes_Obedoza("green camo", "large", "green", 690.69);
        gunMagazine = new Gun_Magazine_Go("boolet", 30, 30);
        kulangot = new Kulangot("green", "large", true);
    }

    // constructor
    public Soldier_Trespeces(String soldierName, boolean isHealthy, boolean isAlive, Clothes_Obedoza clothes, Gun_Magazine_Go gunMagazine, Kulangot kulangot) {
        this.soldierName = soldierName;
        this.isHealthy = isHealthy;
        this.isAlive = isAlive;
        this.clothes = clothes;
        this.gunMagazine = gunMagazine;
        this.kulangot = kulangot;
    }

    // getters
    public String getSoldierName() {
        return soldierName;
    }

    public boolean getIsHealthy() {
        return isHealthy;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public Clothes_Obedoza getClothes() {
        return clothes;
    }

    public Gun_Magazine_Go getGunMagazine() {
        return gunMagazine;
    }

    public Kulangot getKulangot() {
        return kulangot;
    }

    // setters
    public void setSoldierName(String soldierName) {
        this.soldierName = soldierName;
    }

    public void setIsHealthy(boolean isHealthy) {
        this.isHealthy = isHealthy;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setClothes(Clothes_Obedoza clothes) {
        this.clothes = clothes;
    }

    public void setGunMagazine(Gun_Magazine_Go gunMagazine) {
        this.gunMagazine = gunMagazine;
    }

    public void setKulangot(Kulangot kulangot) {
        this.kulangot = kulangot;
    }

    // behaviours
    public void checkClothes() {
        if (!isAlive && !isHealthy) {
            System.out.println(soldierName + " has died!");
        } else if (isAlive && !isHealthy) {
            System.out.println(soldierName + " has been injured and his clothes damaged!");
        } else {
            System.out.println(soldierName + " is wearing " + clothes.getColor() + " " + clothes.getSize() + " " + clothes.getType() + "!");
        }
    }

    public void shoot() {
        if (isAlive && isHealthy) {
            if (gunMagazine.getProjectileAmount() > 0) {
                gunMagazine.setProjectileAmount(gunMagazine.getProjectileAmount() - 1);
                String ammoWord = gunMagazine.getProjectileAmount() == 1 ? "Boolet" : "Boolets"; // singular and plural ofc
                System.out.println(soldierName + " fired his gun! Remaining ammo: " + gunMagazine.getProjectileAmount() + " " + ammoWord);
            } else {
                System.out.println(soldierName + " has no ammo left!");
            }
        } else {
            if (!isAlive) {
                System.out.println(soldierName + " has perished!");
            } else if (isAlive && !isHealthy) {
                System.out.println(soldierName + " is too injured to shoot!");
            }
        }
    }

    public void eat() {
        if (isAlive) {
            System.out.println(soldierName + " ate " + kulangot.getColor() + " " + kulangot.getSize() + " kulangot. I need more protein sir!");
        } else {
            System.out.println(soldierName + " has perished! He doesn't need more protein sir!");
        }
    }

    public void die() {
        isAlive = false;
        isHealthy = false;
        System.out.println(soldierName + " has perished!");
    }

    public void respawn() {
        if (!isAlive) {
            isAlive = true;
            isHealthy = true;
            gunMagazine.setProjectileAmount(30); // respawned w/ max boolets
            System.out.println(soldierName + " has respawned!");
        } else {
            System.out.println(soldierName + " is still alive! He just needs more protein sir!");
        }
    }
}