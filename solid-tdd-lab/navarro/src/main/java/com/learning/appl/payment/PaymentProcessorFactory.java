package com.learning.appl.payment;

import com.learning.appl.exception.UnsupportedPaymentMethodException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * GRASP: Indirection - decouples OrderService from concrete processor classes.
 *
 * SOLID: OCP - new payment methods are added by creating another
 * PaymentProcessor bean, not by modifying OrderService or this lookup logic.
 *
 * SOLID: DIP - depends on the PaymentProcessor abstraction instead of concrete
 * payment implementations.
 */
@Component
public class PaymentProcessorFactory {

    private final Map<String, PaymentProcessor> processors;

    public PaymentProcessorFactory(List<PaymentProcessor> processorList) {
        this.processors = processorList.stream()
                .collect(Collectors.toUnmodifiableMap(
                        processor -> normalize(processor.getMethodKey()),
                        Function.identity()
                ));
    }

    public PaymentProcessor getProcessor(String methodKey) {
        PaymentProcessor processor = processors.get(normalize(methodKey));
        if (processor == null) {
            throw new UnsupportedPaymentMethodException(
                    "Payment method not supported: " + methodKey);
        }
        return processor;
    }

    // DRY: Shared reusable normalization method for registration and lookup.
    private String normalize(String methodKey) {
        if (methodKey == null || methodKey.isBlank()) {
            throw new UnsupportedPaymentMethodException("Payment method is required");
        }
        return methodKey.trim().toUpperCase(Locale.ROOT);
    }
}
