package com.fullstack.gedoria.product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTests {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@BeforeEach
	void cleanDatabase() {
		productRepository.deleteAll();
	}

	@Test
	void createsUpdatesAndDeletesProduct() {
		Product product = productService.create(new ProductRequest(
				"Keyboard",
				new BigDecimal("1499.00"),
				8,
				"Mechanical keyboard"
		));

		assertThat(product.getId()).isNotNull();
		assertThat(productService.findAll()).hasSize(1);

		Product updatedProduct = productService.update(product.getId(), new ProductRequest(
				"Wireless Keyboard",
				new BigDecimal("1899.00"),
				5,
				"Compact wireless keyboard"
		));

		assertThat(updatedProduct.getName()).isEqualTo("Wireless Keyboard");
		assertThat(updatedProduct.getQuantity()).isEqualTo(5);

		productService.delete(product.getId());

		assertThat(productService.findAll()).isEmpty();
	}

	@Test
	void throwsWhenProductDoesNotExist() {
		assertThatThrownBy(() -> productService.delete(99L))
				.isInstanceOf(ProductNotFoundException.class);
	}
}
