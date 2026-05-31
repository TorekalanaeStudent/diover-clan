package com.fullstack.gedoria.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

	private static final int DEFAULT_QUANTITY = 0;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal price;

	@Column(nullable = false)
	private Integer quantity;

	@Column(length = 500)
	private String description;

	protected Product() {
	}

	public Product(String name, BigDecimal price, Integer quantity, String description) {
		this.name = name;
		this.price = price;
		this.quantity = quantity == null ? DEFAULT_QUANTITY : quantity;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public String getDescription() {
		return description;
	}

	public void updateFrom(ProductRequest request) {
		this.name = request.name();
		this.price = request.price();
		this.quantity = request.quantity() == null ? DEFAULT_QUANTITY : request.quantity();
		this.description = request.description();
	}
}
