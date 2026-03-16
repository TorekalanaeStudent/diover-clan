public class BankAccount{

    // Fields
    private String userName;
    private String userId;
    private double accBalance;
    private boolean activeStatus;

    // Static attribute
    private static int totalAccounts = 0;

    // Default constructor
    public BankAccount(){
        userName = "Unknown";
        userId = userName;
        accBalance = 0;
        activeStatus = false;
        ++totalAccounts;
    }

    // Parameterized constructor
    public BankAccount(String userName, String userId, double accBalance,boolean activeStatus){
        // username validation (Implement Validation Logic)
        if(userName == null || userName.isEmpty()){
        this.userName = "Unknown";
        } else {
        this.userName = userName;
        }

        this.userId = userId + totalAccounts;

        // validation of initial balance (Implement Validation Logic)
        if(accBalance < 0){
        this.accBalance = 0;
        } else {
        this.accBalance = accBalance;
        }
        this.activeStatus = activeStatus;
        ++totalAccounts;
    }

    // Deposite method
    public void deposit(double amount){
        if(amount <= 0) {
            System.out.println("Amount Must be positive!");
            return;
        } else {
            accBalance += amount; // Makes sure that accBalance is never negative
            System.out.println("Deposit successful. New balance: " + accBalance);
        } // Makes sure that accBalance is never negative
    }


    // Withdrawal Method
    public void withdraw(double amount){
    // Implement Validation Logic
    if(amount <= 0){
        System.out.println("Invalid withdrawal amount!"); // prevent negative or zero withdrawal
    } else if(amount > accBalance){
        System.out.println("Account balance not enough!"); // prevent overdraft
    } else {
        accBalance -= amount; // safe withdrawal 
        System.out.println("Withdrawal successful. New balance: " + accBalance);
    }
}

    // Getters
    
    public String getUserName (){
        return userName;
    }

    public String getUserId (){
        return userId;
    }

    public double getAccBalance (){
        return accBalance;
    }

    public boolean isActive (){
        return activeStatus;
    }
}