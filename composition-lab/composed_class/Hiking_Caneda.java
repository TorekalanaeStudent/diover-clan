package composed_class;

import component_class.Hands_Navarro;
import component_class.Kulangot;
import component_class.Clothes_Obedoza;

/**
 * Composed Class
 * Hiking_Caneda HAS-A Hands_Navarro
 * Hiking_Caneda HAS-A Kulangot
 * Hiking_Caneda HAS-A Clothes_obedoza
 * @author CanedaRamilJrM
 */

public class Hiking_Caneda {

    private String currentElevation;
    private String mountainHeight;
    private Hands_Navarro handSize;
    private Clothes_Obedoza clotheType;
    private Kulangot kulangot;
    int numChoice;

    //constructors
    public Hiking_Caneda(String mountainHeight, Hands_Navarro handSize, Clothes_Obedoza clotheType, Kulangot kulangot) {
        this.mountainHeight = mountainHeight;
        this.handSize = handSize;
        this.clotheType = clotheType;
        this.kulangot = kulangot;
    }

    //Getters

    public String getMountainHeight() {
        return mountainHeight;
    }

    public String getCurrentElevation() {
        return currentElevation;
    }

    public Hands_Navarro getHandSize() {
        return handSize;
    }

    public Clothes_Obedoza getClotheType() {
        return clotheType;
    }

    public Kulangot getKulangot() {
        return kulangot;
    }

    //Setters

    public void setMountainHeight(String mountainHeight) {
        this.mountainHeight = mountainHeight;
    }

    public void setCurrentElavetion(String currentElevation) {
        this.currentElevation = currentElevation;
    }

    public void setHandSize(Hands_Navarro handSize) {
        this.handSize = handSize;
    }

    public void setClotheType(Clothes_Obedoza clotheType) {
        this.clotheType = clotheType;
    }

    public void setKulangot(Kulangot kulangot) {
        this.kulangot = kulangot;
    }

    //Behaviors

    public void checkingCurrentGear() {
        System.out.println("Checking Hiking gear on hand");
        System.out.println("I touch my " + getClotheType() + " and sees it's in decent condition");
        System.out.println("I rub my two " + getHandSize() + " before the ascend");
        System.out.println("I look one last time at the highest peak of this mountain with the height of " + getMountainHeight());
    }

    public void climbingLedges(int numChoice) {
        switch(numChoice) {
            case 1: {System.out.println("I use my " + getHandSize() + "hands to grab the ledges");
                     System.out.println("I pull myself up to the ledges");}
            break;
            case 2: {System.out.println("I jump and use my " + getHandSize() + "hands to catch and grab the ledges while a burst of wind shows up");
                     System.out.println("I pull myself up to the ledges");}
        }
    }

    public void climbingRopes() {
        System.out.println("I hold on to the rope with my " + getHandSize() + " Hands");
        System.out.println("After reaching the end i rest a bit");
    }

    public void walkInTheTrail(int numChoice) {
        switch (numChoice) {
            case 1: {
                System.out.println("I Start to walk");
            }
            break;
            case 2: {
                System.out.println("I move slowly");
            }
            break;
            case 3: {
                System.out.println("I run");
            }
            break;
            default: {
                System.out.println("Error");
            }
        }
    }
    public void restForNow(int numChoice) {
        switch (numChoice) {
            case 1: {
                System.out.println("I sit and rest for a bit");
            }
            break;
            case 2: {
                System.out.println("I laydown my body to rest");
            }
            break;
            default: {
                System.out.println("Error");
            }
        }
    }
    public void checkCurrentElevation (String currentElevation) {
        setCurrentElavetion(currentElevation);
        System.out.println("After resting a bit i check my new elevation which is " + getCurrentElevation());
    }
    public void flickHiddenKulangot() {
        System.out.println("I notice a huge kulangot in my " + getClotheType());
        System.out.println("I grabbed it");
        kulangot.flick();
        System.out.println("after flicking the kulangot i realized i finally reached the top");
    }







}
