//Main Class
public class Main_Caneda {
    public static void main (String args[]) {

        //BankAccount.java
        
        //object creation 
        BankAccount newBA = new BankAccount();

        BankAccount newBA2 = new BankAccount("Hatsune Miku","CV01",80.00, true);
        
        System.out.println("=== Bank Account === ");
        //Getters 

        //Getter #1
        System.out.println("User Name: "+newBA2.getUserName());
        
        //Getter #2
        System.out.println("User Id: "+newBA2.getUserId());

        //Getter #3
        System.out.println("User Balance: "+newBA2.getAccBalance());

        //Getter #4 
        if(newBA2.isActive()==true) {
        System.out.println("User is Active");
        }
        else{
        System.out.println("User is Not Active");
        }

        //BEHAVIORS 
        System.out.println("=== Bank Transactions === ");
        //Behvaior #1
        newBA2.withdraw(800.00);
        
        //Behavior #2 
        newBA2.deposit(8000.00);

        //Behavior #3
        newBA2.withdraw(800.00);
        

        System.out.println("=== Bank Account === ");
        //New Data after Behaviors:
        System.out.println("User Name: "+newBA2.getUserName());
        System.out.println("User Id: "+newBA2.getUserId());
        System.out.println("User Balance: "+newBA2.getAccBalance());
        if(newBA2.isActive() == true){
            System.out.println("User is Active");
        }
        else{
            System.out.println("User is Not Active");
        }
    
        System.out.println("\n");
        System.out.println("\n");
        //GunRack.java

        //Object creation

        GunRack newGR = new GunRack();

        GunRack newGR2 = new GunRack("MG42", 1942, 1500, "7.92×57mm", 8, "Maget (cra)");

        System.out.println("=== Gun Rack ===");
        //Getter and Setters

        //Getter #1
        System.out.println("Gun Model: "+newGR2.getModel());
        
        //Getter #2
        System.out.println("Batch Year Production: "+newGR2.getYear());

        //Getter #3
        System.out.println("Gun Rounds Per Minute: "+newGR2.getRoundsPerMinute()+" Rounds Per Minute");

        //Getter #4
        System.out.println("Ammunition Calliber: "+newGR2.getCaliber());

        //Getter #5
        System.out.println("Penetration Strenght: "+newGR2.getPenetration()+" MM of Armor");

        //Getter #6
        System.out.println("Manufacturer Code: "+newGR2.getManufacturer());

        //Getter #7
        if(newGR2.isAvailable() == true ){
            System.out.println("In Storage");
        }
        else {
            System.out.println("None in Storage");
        }
        //Setter #1
        newGR2.setManufacturer("Rheinmetal");

        //Setter #2
        newGR2.setCaliber("7.92×57mm");
        
        //Setter #3
        newGR2.setYear(-1940);


        //BEHAVIORS 

        //Behavior #1
        System.out.println("=== Gun Rack ===");
        newGR2.displayInfo();

        //Behavior #2 
        System.out.println("=== In Stock ===");
        newGR2.displayTotalStock();

       
    }
}