package com.learning.appl.payment;

import com.learning.appl.exception.UnsupportedPaymentMethodException;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * GRASP: Pure Fabrication
 * PaymentProcessorFactory doesn't represent a domain concept; it exists purely
 * to improve design.
 *
 * GRASP: Indirection
 * Decouples OrderService from concrete processor classes.
 *
 * GRASP: Protected Variations
 * OrderService never changes when a new payment method is added.
 */

@Component
public class PaymentProcessorFactory {

    private final Map<String, PaymentProcessor> processors;

    // Spring injects ALL PaymentProcessor beans — zero changes needed for new ones
    public PaymentProcessorFactory(List<PaymentProcessor> processorList) {
        this.processors = processorList.stream()
                .collect(Collectors.toMap(
                        PaymentProcessor::getMethodKey,
                        Function.identity()
                ));
    }

    public PaymentProcessor getProcessor(String methodKey) {
        PaymentProcessor processor = processors.get(methodKey.toUpperCase());
        if (processor == null) {
            throw new UnsupportedPaymentMethodException(
                    "Payment method not supported: " + methodKey);
        }
        return processor;
    }
}