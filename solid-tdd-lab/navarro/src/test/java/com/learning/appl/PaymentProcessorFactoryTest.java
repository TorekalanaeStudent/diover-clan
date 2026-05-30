package com.learning.appl;

import com.learning.appl.exception.UnsupportedPaymentMethodException;
import com.learning.appl.payment.PaymentProcessor;
import com.learning.appl.payment.PaymentProcessorFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PaymentProcessorFactoryTest {

    @Test
    @DisplayName("DIP proof: factory resolves mocked PaymentProcessor interfaces")
    void shouldResolveProcessorByInterfaceKey() {
        PaymentProcessor processor = mock(PaymentProcessor.class);
        when(processor.getMethodKey()).thenReturn("GCASH");

        PaymentProcessorFactory factory = new PaymentProcessorFactory(List.of(processor));

        assertThat(factory.getProcessor("gcash")).isSameAs(processor);
    }

    @Test
    @DisplayName("Should reject blank payment method instead of throwing NullPointerException")
    void shouldRejectBlankPaymentMethod() {
        PaymentProcessorFactory factory = new PaymentProcessorFactory(List.of());

        assertThatThrownBy(() -> factory.getProcessor(" "))
                .isInstanceOf(UnsupportedPaymentMethodException.class)
                .hasMessageContaining("Payment method is required");
    }

    @Test
    @DisplayName("Should reject unsupported payment method")
    void shouldRejectUnsupportedPaymentMethod() {
        PaymentProcessorFactory factory = new PaymentProcessorFactory(List.of());

        assertThatThrownBy(() -> factory.getProcessor("CRYPTO"))
                .isInstanceOf(UnsupportedPaymentMethodException.class)
                .hasMessageContaining("CRYPTO");
    }
}
