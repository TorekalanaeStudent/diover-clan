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

        System.out.println("=== Bank Account Class by Obedoza ===");
        // bank account objects
        BankAccount ba1 = new BankAccount("Meme", "ACC001", 1000, true);
        BankAccount ba2 = new BankAccount("", "ACC002", -500, false);
        // ba1 details
        System.out.println("\nACCOUNT 1 DETAILS");
        System.out.println("Username: " + ba1.getUserName());
        System.out.println("User ID: " + ba1.getUserId());
        System.out.println("Balance: " + ba1.getAccBalance());
        System.out.println("Active: " + ba1.isActive());
      // ba2 details
        System.out.println("\nACCOUNT 2 DETAILS");
        System.out.println("Username: " + ba2.getUserName());
        System.out.println("User ID: " + ba2.getUserId());
        System.out.println("Balance: " + ba2.getAccBalance());
        System.out.println("Active: " + ba2.isActive());
        // setters 
        System.out.println("\nUpdating Account 2 Information:");
        ba2.setUserName("Obedoza");
        ba2.setAccBalance(1500);
        ba2.setActive(true);
          // getters
        System.out.println("Updated Name: " + ba2.getUserName());
        System.out.println("Updated Balance: " + ba2.getAccBalance());
        System.out.println("Account Active: " + ba2.isActive());
        // behaviour
        System.out.println("\nTRANSACTIONS: ");
        ba1.deposit(500);
        ba1.withdraw(200);
        // bank account validation
        System.out.println("\nVALIDATION RULES");
        ba1.deposit(-100);
        ba1.withdraw(5000);
        ba1.withdraw(-50);
        // final output
        System.out.println("\nFINAL BALANCE:");
        System.out.println("Account 1 Final Balance: " + ba1.getAccBalance());
    }
}
// note: AI was used to correct and explain errors.
// methods was used to avoid the compile java error
//methods
// Smartphone class
class Smartphone {
    private String brand;
    private String model;
    private String phoneNumber;
    private int batteryLevel;
    private int storageGB;
    private boolean locked;
    private static int totalPhones = 0;

    public Smartphone() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.phoneNumber = "N/A";
        this.batteryLevel = 100;
        this.storageGB = 128;
        this.locked = true;
        totalPhones++;
    }

    public Smartphone(String brand, String model, String phoneNumber) {
        this.brand = brand;
        this.model = model;
        this.phoneNumber = phoneNumber;
        this.batteryLevel = 100;
        this.storageGB = 128;
        this.locked = true;
        totalPhones++;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getPhoneNumber() { return phoneNumber; }
    public int getBatteryLevel() { return batteryLevel; }
    public int getStorageGB() { return storageGB; }
    public boolean isLocked() { return locked; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setStorageGB(int storageGB) { if (storageGB > 0) this.storageGB = storageGB; }

    public static int getTotalPhones() { return totalPhones; }
}

// BankAccount class
class BankAccount {
    private String userName;
    private String userId;
    private double accBalance;
    private boolean active;

    public BankAccount(String userName, String userId, double accBalance, boolean active) {
        this.userName = (userName == null || userName.equals("")) ? "Unknown" : userName;
        this.userId = userId;
        this.accBalance = (accBalance < 0) ? 0 : accBalance;
        this.active = active;
    }

    public String getUserName() { return userName; }
    public String getUserId() { return userId; }
    public double getAccBalance() { return accBalance; }
    public boolean isActive() { return active; }

    public void setUserName(String userName) { if (userName != null && !userName.equals("")) this.userName = userName; }
    public void setAccBalance(double accBalance) { if (accBalance >= 0) this.accBalance = accBalance; }
    public void setActive(boolean active) { this.active = active; }

    public void deposit(double amount) {
        if (amount <= 0) System.out.println("Invalid deposit amount.");
        else { accBalance += amount; System.out.println("Deposited: " + amount); }
    }

    public void withdraw(double amount) {
        if (amount <= 0) System.out.println("Invalid withdrawal amount.");
        else if (amount > accBalance) System.out.println("Insufficient balance.");
        else { accBalance -= amount; System.out.println("Withdrawn: " + amount); }
    }
}
