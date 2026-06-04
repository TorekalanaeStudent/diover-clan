package com.learning.appl;

import com.learning.appl.service.DiscountStrategy;
import com.learning.appl.service.PercentageDiscountStrategy;
import com.learning.appl.service.Notifier;
import com.learning.appl.service.LogNotifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig — Dependency Inversion Principle (DIP)
 * High-level modules depend on abstractions, not concrete classes.
 * We wire concrete implementations here so the service never imports them directly.
 */
@Configuration
public class AppConfig {

    @Bean
    public DiscountStrategy discountStrategy() {
        return new PercentageDiscountStrategy(10.0); // 10% default discount
    }

    @Bean
    public Notifier notifier() {
        return new LogNotifier(); // swap to EmailNotifier without touching service
    }
}
