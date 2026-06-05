package com.learning.appl.mapper;

import com.learning.appl.dto.ProductRequest;
import com.learning.appl.dto.ProductResponse;
import com.learning.appl.entity.Product;
import com.learning.appl.service.DiscountStrategy;
import com.learning.appl.service.FlatDiscountStrategy;
import com.learning.appl.service.PercentageDiscountStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * ProductMapperTest
 * Tests Pure Fabrication: mapper has no state and only transforms data.
 * Tests that discount strategy is correctly applied during mapping.
 */
class ProductMapperTest {

    private ProductMapper productMapper;

    @BeforeEach
    void setUp() {
        productMapper = new ProductMapper();
    }

    // ─── toEntity ─────────────────────────────────────────────────────────────────

    @Test
    void toEntity_mapsAllFieldsCorrectly() {
        ProductRequest request = new ProductRequest("Monitor", "Electronics",
                250.0, 15, "4K display");

        Product entity = productMapper.toEntity(request);

        assertThat(entity.getName()).isEqualTo("Monitor");
        assertThat(entity.getCategory()).isEqualTo("Electronics");
        assertThat(entity.getPrice()).isEqualTo(250.0);
        assertThat(entity.getStockQuantity()).isEqualTo(15);
        assertThat(entity.getDescription()).isEqualTo("4K display");
    }

    @Test
    void toEntity_noIdSet_idIsNull() {
        ProductRequest request = new ProductRequest("Keyboard", "Peripherals",
                80.0, 20, "Mechanical");

        Product entity = productMapper.toEntity(request);

        // ID is set only after persisting — should be null from mapper
        assertThat(entity.getId()).isNull();
    }

    // ─── toResponse ───────────────────────────────────────────────────────────────

    @Test
    void toResponse_withPercentageDiscount_calculatesDiscountedPrice() {
        Product product = new Product("Laptop", "Electronics", 1000.0, 5, "Fast");
        product.setId(1L);
        DiscountStrategy strategy = new PercentageDiscountStrategy(10.0); // 10% off

        ProductResponse response = productMapper.toResponse(product, strategy);

        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getName()).isEqualTo("Laptop");
        assertThat(response.getPrice()).isEqualTo(1000.0);
        assertThat(response.getDiscountedPrice()).isEqualTo(900.0);
        assertThat(response.isAvailable()).isTrue();
    }

    @Test
    void toResponse_withFlatDiscount_calculatesDiscountedPrice() {
        Product product = new Product("Headphones", "Audio", 200.0, 3, "Wireless");
        product.setId(2L);
        DiscountStrategy strategy = new FlatDiscountStrategy(50.0); // flat ₱50 off

        ProductResponse response = productMapper.toResponse(product, strategy);

        assertThat(response.getDiscountedPrice()).isEqualTo(150.0);
    }

    @Test
    void toResponse_outOfStock_availableIsFalse() {
        Product product = new Product("Tablet", "Electronics", 500.0, 0, "");
        product.setId(3L);
        DiscountStrategy strategy = new PercentageDiscountStrategy(0.0);

        ProductResponse response = productMapper.toResponse(product, strategy);

        assertThat(response.isAvailable()).isFalse();
    }

    @Test
    void toResponse_zeroDiscount_discountedPriceEqualsOriginal() {
        Product product = new Product("Mouse", "Peripherals", 30.0, 50, "Wireless mouse");
        product.setId(4L);
        DiscountStrategy strategy = new PercentageDiscountStrategy(0.0); // no discount

        ProductResponse response = productMapper.toResponse(product, strategy);

        assertThat(response.getDiscountedPrice()).isEqualTo(30.0);
    }
}
