package com.grasp.jagunap.util;

import com.grasp.jagunap.payment.CashPayment;
import com.grasp.jagunap.payment.CreditCardPayment;
import com.grasp.jagunap.payment.GcashPayment;
import com.grasp.jagunap.payment.Payment;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

// SOLID: LSP - All Payment implementations are substitutable for Payment interface
// SOLID: OCP - New payment types can be added without changing this test structure
class PaymentPolymorphismTest {

    // Bonus: Parameterized test covering all implementations
    static Stream<Payment> paymentProvider() {
        return Stream.of(new CashPayment(), new CreditCardPayment(), new GcashPayment());
    }

    @ParameterizedTest
    @MethodSource("paymentProvider")
    void allPaymentsShouldProcessWithoutException(Payment payment) {
        // LSP: Every implementation must work correctly when used as a Payment
        assertDoesNotThrow(() -> payment.process(100.0));
    }

    @ParameterizedTest
    @MethodSource("paymentProvider")
    void allPaymentsShouldReturnNonNullType(Payment payment) {
        assertNotNull(payment.getPaymentType());
        assertFalse(payment.getPaymentType().isBlank());
    }
}