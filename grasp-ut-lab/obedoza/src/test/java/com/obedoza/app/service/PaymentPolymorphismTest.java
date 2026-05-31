package com.obedoza.app.service;

import com.obedoza.app.payment.CashPayment;
import com.obedoza.app.payment.CreditCardPayment;
import com.obedoza.app.payment.PaymentProcessor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentPolymorphismTest {

    @Test
    void creditCardPaymentShouldReturnCorrectType() {
        PaymentProcessor processor = new CreditCardPayment();
        assertEquals("CREDIT_CARD", processor.getPaymentType());
        assertDoesNotThrow(() -> processor.process(100.0));
    }

    @Test
    void cashPaymentShouldReturnCorrectType() {
        PaymentProcessor processor = new CashPayment();
        assertEquals("CASH", processor.getPaymentType());
        assertDoesNotThrow(() -> processor.process(50.0));
    }

    @Test
    void bothImplementationsSatisfySameInterface() {
        // Both can be used wherever PaymentProcessor is expected
        List<PaymentProcessor> processors = List.of(
                new CreditCardPayment(),
                new CashPayment()
        );
        processors.forEach(p -> assertNotNull(p.getPaymentType()));
    }

}
