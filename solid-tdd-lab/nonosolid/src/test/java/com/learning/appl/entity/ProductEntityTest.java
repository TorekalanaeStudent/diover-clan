package com.learning.appl.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

/**
 * ProductEntityTest
 * Tests the Information Expert behaviour on the entity:
 * isAvailable() and hasDiscount() logic.
 * Also tests ProductSnapshot immutability (Java record).
 */
class ProductEntityTest {

    // ─── isAvailable ─────────────────────────────────────────────────────────────

    @Test
    void isAvailable_stockGreaterThanZero_returnsTrue() {
        Product product = new Product("Phone", "Electronics", 300.0, 5, "");
        assertThat(product.isAvailable()).isTrue();
    }

    @Test
    void isAvailable_stockZero_returnsFalse() {
        Product product = new Product("Phone", "Electronics", 300.0, 0, "");
        assertThat(product.isAvailable()).isFalse();
    }

    // ─── hasDiscount ──────────────────────────────────────────────────────────────

    @Test
    void hasDiscount_priceAbove500_returnsTrue() {
        Product product = new Product("TV", "Electronics", 800.0, 1, "");
        assertThat(product.hasDiscount()).isTrue();
    }

    @Test
    void hasDiscount_priceAtExactly500_returnsFalse() {
        Product product = new Product("Camera", "Electronics", 500.0, 1, "");
        assertThat(product.hasDiscount()).isFalse();
    }

    @Test
    void hasDiscount_priceBelowThreshold_returnsFalse() {
        Product product = new Product("USB Hub", "Accessories", 20.0, 10, "");
        assertThat(product.hasDiscount()).isFalse();
    }

    // ─── Parameterized: stock and availability ────────────────────────────────────

    @ParameterizedTest
    @CsvSource({"0,false", "1,true", "100,true"})
    void isAvailable_parameterized(int stock, boolean expected) {
        Product product = new Product("Item", "Category", 100.0, stock, "");
        assertThat(product.isAvailable()).isEqualTo(expected);
    }

    // ─── ProductSnapshot (Immutability) ──────────────────────────────────────────

    @Test
    void productSnapshot_fromProduct_capturesAllFields() {
        Product product = new Product("Laptop", "Electronics", 999.99, 10, "");
        product.setId(1L);

        ProductSnapshot snapshot = ProductSnapshot.from(product);

        assertThat(snapshot.name()).isEqualTo("Laptop");
        assertThat(snapshot.price()).isEqualTo(999.99);
        assertThat(snapshot.category()).isEqualTo("Electronics");
        assertThat(snapshot.stockQuantity()).isEqualTo(10);
    }

    @Test
    void productSnapshot_isImmutable_equalsByValue() {
        Product p1 = new Product("Laptop", "Electronics", 999.99, 10, "");
        p1.setId(1L);
        Product p2 = new Product("Laptop", "Electronics", 999.99, 10, "");
        p2.setId(1L);

        ProductSnapshot s1 = ProductSnapshot.from(p1);
        ProductSnapshot s2 = ProductSnapshot.from(p2);

        // Records implement equals by value automatically
        assertThat(s1).isEqualTo(s2);
    }

    @Test
    void productSnapshot_modifyingOriginalProduct_doesNotAffectSnapshot() {
        Product product = new Product("Laptop", "Electronics", 999.99, 10, "");
        product.setId(1L);
        ProductSnapshot snapshot = ProductSnapshot.from(product);

        // Mutate the original
        product.setPrice(1500.0);
        product.setStockQuantity(0);

        // Snapshot remains unchanged — proves immutability
        assertThat(snapshot.price()).isEqualTo(999.99);
        assertThat(snapshot.stockQuantity()).isEqualTo(10);
    }
}
