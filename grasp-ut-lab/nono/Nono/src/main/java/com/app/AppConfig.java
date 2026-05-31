package com.app;

import com.app.util.DiscountStrategy;
import com.app.util.PercentageDiscountStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * GRASP: Protected Variations + Low Coupling
 * ───────────────────────────────────────────
 * We wire the default DiscountStrategy here so that ProductService
 * never references a concrete class — it only knows about the interface.
 * Swapping strategies requires changing only this file.
 */
@Configuration
public class AppConfig {

    @Bean
    @Primary
    public DiscountStrategy discountStrategy() {
        // Default: 10 % off. Change this line to swap the entire strategy.
        return new PercentageDiscountStrategy(10.0);
    }
}
