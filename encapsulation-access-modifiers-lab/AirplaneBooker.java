public class AirplaneBooker {
    
    //private attributes
    private String passengerName;
    private String passengerSeatNumber;
    private String passengerDeparturetime;
    private int passengerPassportNumb;
    private int passengerWeight;
    private int passengerLuggageWeight;

    //static attributes
    private static int totalPassengersOnFlight;

    //default constructor 
    public AirplaneBooker ()  {
    passengerName = "Obedoza Bin Laden";
    passengerSeatNumber = "33F";
    passengerDeparturetime = "2:00pm"; 
    passengerPassportNumb  = 483920175; 
    passengerWeight = 90; //weight in kilos
    totalPassengersOnFlight++;
    }
    //parametized constructor 
    public AirplaneBooker (String passengerName, String passengerDeparturetime, int passengerPassportNumb, int passengerWeight, int passengerLuggageWeight) {
        this.passengerName = passengerName;
        this.passengerDeparturetime = passengerDeparturetime;
        this.passengerPassportNumb = passengerPassportNumb;
        this.passengerWeight = passengerWeight;
        this.passengerLuggageWeight = passengerLuggageWeight;
        totalPassengersOnFlight++;
    }
    //GETTERS
    public String getPassengerName() {
        return passengerName;
    }
    public String getPassengerSeatNumber(){
        return passengerSeatNumber;
    }
    public String getDepartureTime(){
        return passengerDeparturetime;
    }
    public int getPassengerPassportNumb(){
        return passengerPassportNumb;
    }
    public int getPassengerWeight(){
        return passengerWeight;
    }
    public int getPassengerLuggageWeight(){
        return passengerLuggageWeight;
    }
    //SETTERS

    //validation logics

    //Validation logic #1
    public void setPassengerName (String passengerName) {
        if (passengerName != null) {
        this.passengerName = passengerName;
        System.out.println(passengerName+ " Was Inputed");
        return;
        }
        else {
        System.out.println("No Name Was Inputed");
        return;
        }
    }     
    //Validation logic #2 
    public void setPassengerPassportNumb (int passengerPassportNumb) {
        if (passengerPassportNumb >= 100_000_000 && passengerPassportNumb <= 999_999_999) {
         System.out.println(passengerPassportNumb+ " is Valid");
         this.passengerPassportNumb = passengerPassportNumb;
         return;
        }
        else {
         System.out.println(passengerPassportNumb+ " is Not Valid");
         return;
        }
    }  
    //Validation logic #3
    public void setPassengerWeight (int passengerWeight) {
        if (passengerWeight >= 0 && passengerWeight <= 300) {
         System.out.println(passengerName + "is fit enough for this flight");
         this.passengerWeight = passengerWeight;
         return;
        }
        else {
         System.out.println(passengerName + "is Not fit enough for this flight");
         return;
        }
    }
    // Behaviors

    // Behavior #1 
    public void displayPassengersInfo() {
        System.out.println("Name: "+ passengerName);
        System.out.println("Seat Number: "+passengerSeatNumber);
        System.out.println("Departure Time: "+passengerDeparturetime);
        System.out.println("Passport Numb: "+passengerPassportNumb);
        System.out.println("Weight: "+passengerWeight);
        System.out.println("Luggage Weight: "+passengerLuggageWeight);
    }
    // Behavior #2
    public void displayTotalPassengersOnFlight () {
        System.out.println("Total Passengers On Flight: "+totalPassengersOnFlight);
    }
    
    
   
    }

