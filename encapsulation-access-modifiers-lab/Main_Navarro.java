public class Main_Navarro {

    public static void main(String[] args) {

        GunRack gun1 = new GunRack("M4", 1991, 900, "5.56mm", 50, "Colt");

        BankAccount acc1 = new BankAccount("John", "ID", 5000, true);
    	System.out.println("From Seth Go Class:");
        // Display Gun Info
        System.out.println("==== Gun Information ====");
        gun1.displayInfo();
        System.out.println("From Kyle Obedoza Class:");
        // Display Bank Info using getters
        System.out.println("==== Bank Account ====");
        System.out.println("Name: " + acc1.getUserName());
        System.out.println("ID: " + acc1.getUserId());
        System.out.println("Balance: " + acc1.getAccBalance());
        System.out.println("Active: " + acc1.isActive());

        System.out.println();

        // Behaviors
        System.out.println("Customer attempts to buy gun worth 3000");
        acc1.withdraw(3000);   
        gun1.setAvailable(false); 

        System.out.println("Gun availability: " + gun1.isAvailable());

        System.out.println();

        // GunRack behaviors
        gun1.displayInfo(); 
        GunRack.displayTotalStock();

        System.out.println("\n==== Testing Invalid Inputs ====");

        // Invalid GunRack inputs
        gun1.setYear(-1990);
        gun1.setRoundsPerMinute(-500);
        gun1.setPenetration(-10);

        // Invalid BankAccount inputs
        acc1.withdraw(-100);  
        acc1.withdraw(10000);  

    }
}