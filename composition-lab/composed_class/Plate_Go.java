package composed_class;

import component_class.Kulangot;
import component_class.Earwax_Cardeno;
import component_class.Handkerchief_Gedoria;

/*
* Composed Class
* Plate(Plate_Go) HAS A Kulangot(Kulangot)
* Plate(Plate_Go) HAS A(n) Earwax(Earwax_Cardeno)
* Plate(Plate_Go) HAS A Handkerchief(Handkerchief_Gedoria)
*
* Basically putting things on a plate.
*/ 

public class Plate_Go {
  
  // Attibutes
  private String plateDish;
  private Kulangot kulangot;
  private Earwax_Cardeno earwax;
  private Handkerchief_Gedoria handkerchief;
  
  // Constructor(Default)
  public Plate_Go(){
   
    this.plateDish = "Empty Plate";
    this.kulangot = new Kulangot("Green", "Large", true);
    this.earwax = new Earwax_Cardeno(1, "Dark Yellow","Mushy", true);
    this.handkerchief = new Handkerchief_Gedoria("Blue","Small", false);
    
  }
  
  // Parameterized Constructor
  public Plate_Go(String plateDish, Kulangot kulangot, Earwax_Cardeno earwax, Handkerchief_Gedoria handkerchief){
    
    this.plateDish = plateDish;
    this.kulangot = kulangot;
    this.earwax = earwax;
    this.handkerchief = handkerchief;
    
  }
  
  // Setters
  
  public void set_plateDish(String plateDish) { // there were duplicate return types thats why there was error T~T, void & String/Kulangot(Class name basically acting as return type of sorts, you're returning something to the class yknow?) in the same line.
    
    this.plateDish = plateDish;
    
  }
  
  public void set_kulangot(Kulangot kulangot) { // 
    
    this.kulangot = kulangot;
    
  }
  
  public void set_earwax(Earwax_Cardeno earwax) {
    
    this.earwax = earwax;
     
  }
  
  public void set_handkerchief(Handkerchief_Gedoria handkerchief) {
    
    this.handkerchief = handkerchief;
    
  }
  
  // Getters
  
  public String get_plateDish() {
    
    return plateDish;
    
  }
  
  public Kulangot get_kulangot() {
    
    return kulangot;
    
  }
  
  public Earwax_Cardeno get_earwax() {
    
    return earwax;
     
  }
  
  public Handkerchief_Gedoria get_handkerchief() {
    
    return handkerchief;
    
  }
    
   // Behaviors
  
  public void displayPlateContents() {

    System.out.println("On the plate lies a peculiar dish...");

    // Kulangot
    if (kulangot != null) {
        System.out.println(
            "A " + kulangot.getSize() + ", " + kulangot.getColor() +
            " kulangot rests on the plate, " +
            (kulangot.isSticky() ? "sticky to the touch." : "dry and crumbly.")
        );
    } else {
        System.out.println("Sike! Plate is empty.");
    }

    // Earwax
    if (earwax != null) {
        System.out.println("Beside it sits " + earwax.getAmount() + " earwax(s), " + earwax.getTexture() + " it really is and " + earwax.getColor() + " in color."
        );
    } else {
        System.out.println("Sike! Plate is empty.");
    }

    // Handkerchief
    if (handkerchief != null) {
        System.out.println(
            "A "+ handkerchief.getSize() + " " + handkerchief.getColor() + " handkerchief lies nearby, " +
            (handkerchief.isUsed() ? "fresh and clean, folded like a lotus flower." : "used and slightly soiled, not even a proper fold.")
        );
    } else {
        System.out.println("Sike! Plate is empty.");
    }

    System.out.println("\nAn Unusual Menu, to say the least.");
}
  
}
