public class Main_Go {
    public static void main(String[] args) {


        System.out.println("Navarro's Product Class ");
        System.out.println("===== Creating Product Objects =====\n");

        // Default constructor
        E_Product p1 = new E_Product();
        p1.displayDetails();
        System.out.println();


        // Constructor 1
        E_Product p2 = new E_Product("Xiaomi Redmi Note 4", 39999.0, "Phones", 10);
        p2.displayDetails();
        System.out.println();

        // Constructor 2
        E_Product p3 = new E_Product("USB Cable", 149.0);
        p3.displayDetails();
        System.out.println();

        System.out.println("===== Using Getters =====\n");
        System.out.println("Name     : " + p2.getName());
        System.out.println("Price    : P" + p2.getPrice());
        System.out.println("Category : " + p2.getCategory());
        System.out.println("Stock    : " + p2.getStock());
        System.out.println();

        System.out.println("===== Using Setters =====\n");
        p3.setName("USB-C Cable");
        p3.setPrice(299.0	);
        p3.setCategory("Accessories");
        p3.setStock(50);
        p3.displayDetails();
        System.out.println();

        System.out.println("===== Behaviors =====\n");
        p2.applyDiscount(10);       // valid discount
        p1.restock(5);              // valid restock
        System.out.println();

        System.out.println("===== Testing Invalid Inputs =====\n");
        p2.setPrice(-500);          // negative price
        p3.setStock(-10);           // negative stock
        p1.setName("");             // empty name
        p1.applyDiscount(110);      // invalid discount
        System.out.println();

        System.out.println("===== Static Counter =====\n");
        E_Product.displayTotalProducts();
System.out.println(" ");


System.out.println("Kyles's BankAccount Class ");

        // Default account
        BankAccount b1 = new BankAccount();
       
      System.out.println("======Input Validation=======");

        // Use b1 methods
        System.out.println("b1 Balance before deposit: " + b1.getAccBalance());
System.out.println("======Deposit Attempt=======");
        b1.deposit(600);  
        System.out.println(b1.getAccBalance());
System.out.println("======Wrong Withdraw Attempt=======");
        b1.withdraw(700);
        System.out.println(b1.getAccBalance());

        // Parameterized account
        BankAccount b2 = new BankAccount("Sean Go", "SG3217", 200.00, true);

        System.out.println("UserName: " + b2.getUserName());
        System.out.println("User ID: " + b2.getUserId());
        System.out.println("Account Balance: " + b2.getAccBalance());
        System.out.println("Active: " + b2.isActive());

        b2.withdraw(50);
        System.out.println(b2.getAccBalance());
    }

}

