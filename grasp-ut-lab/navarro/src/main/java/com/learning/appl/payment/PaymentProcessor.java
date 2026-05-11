package com.learning.appl.payment;

/**
 * GRASP: Polymorphism
 * The stable interface for payment processing.
 *
 * GRASP: Protected Variations
 * The service depends only on this contract.
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
