package com.learning.appl;

import com.learning.appl.payment.BankTransferPaymentProcessor;
import com.learning.appl.payment.CreditCardPaymentProcessor;
import com.learning.appl.payment.PayPalPaymentProcessor;
import com.learning.appl.payment.PaymentProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentProcessorPolymorphismTest {

    static Stream<PaymentProcessor> processors() {
        return Stream.of(
                new CreditCardPaymentProcessor(),
                new PayPalPaymentProcessor(),
                new BankTransferPaymentProcessor()
        );
    }

    @ParameterizedTest
    @MethodSource("processors")
    @DisplayName("LSP proof: all payment processors work through the same abstraction")
    void allProcessorsShouldBehaveThroughSameContract(PaymentProcessor processor) {
        String transactionId = processor.process(125.50);

        assertThat(transactionId).isNotBlank();
        assertThat(transactionId).startsWith(expectedPrefix(processor.getMethodKey()));
    }

    private String expectedPrefix(String methodKey) {
        return switch (methodKey) {
            case "CREDIT_CARD" -> "CC-";
            case "PAYPAL" -> "PP-";
            case "BANK_TRANSFER" -> "BT-";
            default -> throw new IllegalArgumentException("Unexpected method key: " + methodKey);
        };
    }
}
