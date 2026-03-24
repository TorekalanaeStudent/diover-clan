package component_class;

/**
 * The Component Class
 * @author NavarroVinceJustine
 */
public class Hands_Navarro {
	
	// Attributes 
				private String skinTone;
				private String handSize;
				private boolean haveHands;

    // Constructor
		    public Hands_Navarro(String skinTone, String handSize, boolean haveHands) {
		        this.skinTone = skinTone;
		        this.handSize = handSize;
		        this.haveHands = haveHands;
		    }

    // Getters and Setters
		    public String getSkinTone() {
		        return skinTone;
		    }
		    
	// Validation	    
		    public void setSkinTone(String skinTone) {
		        if (skinTone.isEmpty()) {
		            System.out.println("Error!!: The Skin tone must not be empty.");
		        } else {
		            this.skinTone = skinTone;
		        }
		    }

		    public String getHandSize() {
		        return handSize;
		    }

		    public void setHandSize(String handSize) {
		        this.handSize = handSize;
		    }

		    public boolean hasHands() {
		        return haveHands;
		    }

		    public void setHaveHands(boolean haveHands) {
		        this.haveHands = haveHands;
		    }

    // Behavior methods with Validations
		    public void usingHands() {
		        if (haveHands) {
		            System.out.println("You try to move one of your hands....");
		        } else {
		            System.out.println("You can't use your hands....");
		        }
		    }
    
		    public void pickingYourNose() {
		        if (haveHands) {
		            System.out.println("You use one of your " + handSize + " hands to pick your nose!");
		        } else {
		            System.out.println("You need hands to do that!");
		        }
		    }
		    
		    public void describe() {
		        System.out.println("=== Hand Details ===");
		        System.out.println("Skin Tone : " + skinTone);
		        System.out.println("Hand Size : " + handSize);
		        System.out.println("Has Hands : " + haveHands);
		    }
		    
		    
		    @Override
		    public String toString() {
		        return "Hands_Navarro{" +
		                "skinTone='" + skinTone + '\'' +
		                ", handSize='" + handSize + '\'' +
		                ", haveHands=" + haveHands +
		                '}';
		    }
		}
