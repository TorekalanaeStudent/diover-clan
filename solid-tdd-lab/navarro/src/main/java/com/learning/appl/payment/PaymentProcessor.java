package com.learning.appl.payment;

/**
 * GRASP: Polymorphism
 * The stable interface for payment processing.
 *
 * GRASP: Protected Variations
 * The service depends only on this contract.
 *
 * SOLID: ISP - this interface stays small and focused: process payment and
 * expose the lookup key needed by the factory.
 *
 * SOLID: LSP - every implementation must be usable anywhere a PaymentProcessor
 * is expected.
 */
public interface PaymentProcessor {

    /**
     * Process a payment for the given amount.
     *
     * @param amount the amount to charge
     * @return a transaction reference string
     */
    String process(double amount);

    /**
     * Returns the method key that identifies this processor.
     * Used by the factory to look up the right implementation.
     */
    String getMethodKey();
}
