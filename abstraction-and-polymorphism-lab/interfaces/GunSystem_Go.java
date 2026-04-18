package interfaces;

/*
* @author Go Sean Ethan G.
* @SethPlaysBadly
*/

import abstract_classes.Gun_Go;

public interface GunSystem_Go {

   void chamberRound(String caliber); // undetermined because guns each guns have multiple ways to chamber a round.
                                      // also overloading
   default void shoot() {
     
   System.out.println("Bang!");  
     
   }
  

  
}