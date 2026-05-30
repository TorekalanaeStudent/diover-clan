package abstract_classes;

/**
 * @author Caneda, Ramil Jr M.
 * @Rcaneda
 */
 
 public abstract class CharacterSpeed_Caneda {

    //Attributes
   private int time;
   private int acceleration;
   private int speed;

    //Setters

    //Setter #1 sets time, if time is negative, time will simply be 0
   public void setTime (int time) {
     if(time <= 0) {
         System.out.println("Time Cannot be negative");
         this.time = 0;
     }
     else {
         this.time = time;
     }
      
   }

   //Setters #2 sets acceleration, if acceleration is negative, acceleration will simply be 0
   public void setAcceleration (int acceleration) {
      if(acceleration <= 0) {
         System.out.println("Acceleration Cannot be Negative");
         this.acceleration = 0;
     }
     else {
         this.acceleration = acceleration;
     }
   }
   //Getters

   //Getter #1 Gets Acceleration ¯\_(ツ)_/¯
   public int getTime () {
      return time;
   }

   //Getter #2 Gets Velocity ¯\_(ツ)_/¯
   public int getAcceleration () {
      return acceleration;
   }
   //Abstract methods that will be overriden 
   
   public abstract int getDistance();
   public abstract int getVelocity();


   //Concrete method

   //Concrete method #1 Simply calculates and returns the speed
   public int showSpeed(int time, int acceleration) {
      speed = (time*acceleration);
      return speed;
   }



 }