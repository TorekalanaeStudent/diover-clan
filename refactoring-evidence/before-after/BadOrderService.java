// ========================================
// ❌ BEFORE — BAD DESIGN (Original Code)
// ========================================

// Violates SRP: does validation + payment + saving + emailing in ONE class
// Violates OCP: adding new payment = editing this class
// Violates DIP: creates concrete dependency directly

public class BadOrderService {

    // ❌ DIP Violation - hardcoded concrete class
    private MySQLOrderRepository repository = new MySQLOrderRepository();

    public void processOrder(String customerName, double amount, String paymentType) {

        // ❌ SRP Violation - validation mixed with business logic
        if (customerName == null || customerName.isEmpty()) {
            System.out.println("Invalid customer name");
            return;
        }
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        // ❌ OCP Violation - must edit this method to add new payment type
        if (paymentType.equals("GCASH")) {
            System.out.println("Processing GCash payment of " + amount);
        } else if (paymentType.equals("CARD")) {
            System.out.println("Processing Card payment of " + amount);
        } else if (paymentType.equals("CASH")) {
            System.out.println("Processing Cash payment of " + amount);
        }

        // ❌ SRP Violation - saving AND emailing in same method
        repository.save(customerName, amount);
        System.out.println("Sending email to " + customerName);
    }
}