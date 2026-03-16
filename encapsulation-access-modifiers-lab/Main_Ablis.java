/*
 > java file made by Ablis, Margreleigne 
 > Object collaboration of Gedoria and ABlis
 > used Smartphone class by Gedoria
 > AI was used to correct errors
*/
public class Main_Ablis {
  public static void main (String[] args) {
    System.out.println("=== Smartphone Class by Gedoria ===");
        // Create objects
        Smartphone ph1 = new Smartphone("Samsung", "Galaxy S23", "09123456789");
        Smartphone ph2 = new Smartphone(); //default constructor

        // ph1 details
        System.out.println("PHONE 1 DETAILS");
        System.out.println("Brand: " + ph1.getBrand());
        System.out.println("Model: " + ph1.getModel());
        System.out.println("Phone Number: " + ph1.getPhoneNumber());
        System.out.println("Battery Level: " + ph1.getBatteryLevel()+ "%");
        System.out.println("Storage: " + ph1.getStorageGB() + "GB");
        System.out.println("Status: " + ph1.isLocked());
        // ph 2 details
        System.out.println("\nPHONE 2 DETAILS: ");
        System.out.println("Brand: " + ph2.getBrand());
        System.out.println("Model: " + ph2.getModel());
        System.out.println("Phone Number: " + ph2.getPhoneNumber());

        // setters
        System.out.println("\nUpdating Phone Information: ");
        ph2.setPhoneNumber("09987654321");
        ph2.setStorageGB(256);
        // getters
        System.out.println("Updated Phone Number: " + ph2.getPhoneNumber());
        System.out.println("Updated Storage: " + ph2.getStorageGB() + "GB");

        // validation rules
        System.out.println("\nValidation rules: ");	
        ph2.setStorageGB(16); // invalid storage if less than 32gb
        ph2.setBatteryLevel(150); // invalid battery if greater than 100%

        // behaviours of lock status and battery level
        System.out.println("\nPhone Status: ");
        ph1.unlockPhone();
        System.out.println("Phone unlocked?: " + !ph1.isLocked());
        ph1.useBattery(30);
        System.out.println("Battery after using: " + ph1.getBatteryLevel()+"%");
        ph1.chargeBattery(20);
        System.out.println("Battery after charging: " + ph1.getBatteryLevel()+"%");
        ph1.lockPhone();
        System.out.println("Phone locked?: " + ph1.isLocked());

        // static attribute
        System.out.println("\nTotal Smartphones Created: " + Smartphone.getTotalPhones());

          // BANK ACCOUNT CLASS BY OBEDOZA
    // second class created by Ablis
   // note: AI was used to correct and explain errors
        System.out.println("=== Bank Account Class by Obedoza ===");

        // create objects for bank account
        BankAccount acc1 = new BankAccount("Meme", "ACC001", 1000, true);
        BankAccount acc2 = new BankAccount("", "ACC002", -500, false);

        // ba1 details
        System.out.println("\nACCOUNT 1 DETAILS");
        System.out.println("Username: " + acc1.getUserName());
        System.out.println("User ID: " + acc1.getUserId());
        System.out.println("Balance: " + acc1.getAccBalance());
        System.out.println("Active: " + acc1.isActive());

        // ba2 details
        System.out.println("\nACCOUNT 2 DETAILS");
        System.out.println("Username: " + acc2.getUserName()); // becomes Unknown
        System.out.println("User ID: " + acc2.getUserId());
        System.out.println("Balance: " + acc2.getAccBalance()); // becomes 0
        System.out.println("Active: " + acc2.isActive());

        // setters
        System.out.println("\nUpdating Account 2 Information:");
        acc2.setUserName("Obedoza");
        acc2.setAccBalance(1500);
        acc2.setActive(true);

        // getters after updating bank account
        System.out.println("Updated Name: " + acc2.getUserName());
        System.out.println("Updated Balance: " +acc2.getAccBalance());
        System.out.println("Account Active: " + acc2.isActive());

        // transactions of bank sccount
        System.out.println("\nTRANSACTIONS: ");
        acc1.deposit(500);
        acc1.withdraw(200);

        // bank account validation fules
        System.out.println("\nVALIDATION RULES");
        acc1.deposit(-100);     // invalid deposit
        acc1.withdraw(5000);    // insufficient balance
        acc1.withdraw(-50);     // invalid withdrawal

        // final balance of bacnk account
        System.out.println("\nFINAL BALANCE: ");
        System.out.println("Account 1 Final Balance: " + acc1.getAccBalance());


    }
}
