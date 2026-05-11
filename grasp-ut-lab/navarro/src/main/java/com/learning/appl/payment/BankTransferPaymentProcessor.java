package com.learning.appl.payment;

import org.springframework.stereotype.Component;
import java.util.UUID;

/**
 * GRASP: Polymorphism — third concrete PaymentProcessor implementation.
 * GRASP: Protected Variations — adding this implementation required zero
 * changes to OrderService.
 */
@Component
public class BankTransferPaymentProcessor implements PaymentProcessor {

    @Override
    public String process(double amount) {
        String txId = "BT-" + UUID.randomUUID();
        System.out.printf("[BankTransfer] Initiated $%.2f  txId=%s%n", amount, txId);
        return txId;
    }

    @Override
    public String getMethodKey() {
        return "BANK_TRANSFER";
    }
}