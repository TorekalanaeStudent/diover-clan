package com.fullstack.gedoria.product;

import java.math.BigDecimal;

public record ProductRequest(
		String name,
		BigDecimal price,
		Integer quantity,
		String description
) {
}
