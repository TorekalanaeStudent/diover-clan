// ❌ BEFORE - OCP Violation in original OrderService
// Every new payment type requires editing this method

private String resolvePaymentKey(String paymentType) {
    return switch (paymentType.toUpperCase()) {
        case "CASH" -> "cashPayment";
        case "CREDIT_CARD" -> "creditCardPayment";
        case "GCASH" -> "gcashPayment";
        // ❌ Adding "MAYA" means editing this existing code = OCP violation
        default -> throw new IllegalArgumentException("Unknown payment type: " + paymentType);
    };
}

// ✅ AFTER - PaymentResolver.java
// Adding new payment = just add a new @Component class, never touch this

@Component
public class PaymentResolver {
    private final Map<String, Payment> paymentMap;

    public PaymentResolver(Map<String, Payment> paymentMap) {
        this.paymentMap = paymentMap;
    }

    public Payment resolve(String paymentType) {
        // ✅ OCP - self-resolving via Spring bean names
        String key = paymentType.toLowerCase() + "Payment";
        Payment payment = paymentMap.get(key);
        if (payment == null) throw new IllegalArgumentException("Unknown: " + paymentType);
        return payment;
    }
}