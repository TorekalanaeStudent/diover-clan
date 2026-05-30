package com.learning.appl;

import com.learning.appl.dto.OrderRequest;
import com.learning.appl.service.OrderService;
import com.learning.appl.dto.OrderResponse;
import com.learning.appl.entity.Order;
import com.learning.appl.entity.OrderStatus;
import com.learning.appl.exception.InvalidOrderException;
import com.learning.appl.exception.OrderNotFoundException;
import com.learning.appl.payment.PaymentProcessor;
import com.learning.appl.payment.PaymentProcessorFactory;
import com.learning.appl.repository.OrderRepository;
import com.learning.appl.util.OrderValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for OrderService.
 *
 * GRASP: Low Coupling — tests mock all dependencies so there are NO real DB calls.
 * Mockito replaces: OrderRepository, PaymentProcessorFactory, OrderValidator.
 */

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

	// ── Mocked dependencies ───────────────────────────────────────────────────

	@Mock
	private OrderRepository orderRepository;

	@Mock
	private PaymentProcessorFactory processorFactory;

	@Mock
	private PaymentProcessor paymentProcessor;

	@Mock
	private OrderValidator validator;

	// ── Subject under test ────────────────────────────────────────────────────

	@InjectMocks
	private OrderService orderService;

	// ── Helpers ───────────────────────────────────────────────────────────────

	private OrderRequest buildRequest(String customer, String payMethod) {
		OrderRequest req = new OrderRequest();
		req.setCustomerName(customer);
		req.setPaymentMethod(payMethod);

		OrderRequest.OrderItemRequest item = new OrderRequest.OrderItemRequest();
		item.setProductName("Widget");
		item.setQuantity(2);
		item.setUnitPrice(15.00);
		req.setItems(List.of(item));
		return req;
	}

	private Order buildSavedOrder(Long id, String customer) {
		Order o = new Order(customer);
		o.addItem("Widget", 2, 15.00);
		o.setStatus(OrderStatus.CONFIRMED);
		// Simulate JPA-assigned id via reflection
		try {
			var field = Order.class.getDeclaredField("id");
			field.setAccessible(true);
			field.set(o, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return o;
	}

	// ══════════════════════════════════════════════════════════════════════════
	// 1. createOrder — happy path
	// ══════════════════════════════════════════════════════════════════════════

	@Test
	@DisplayName("Should create order and return response when input is valid")
	void shouldCreateOrder() {
		// Arrange
		OrderRequest request = buildRequest("Alice", "CREDIT_CARD");
		Order saved = buildSavedOrder(1L, "Alice");

		doNothing().when(validator).validate(request);
		when(processorFactory.getProcessor("CREDIT_CARD")).thenReturn(paymentProcessor);
		when(paymentProcessor.process(anyDouble())).thenReturn("CC-TX-123");
		when(orderRepository.save(any(Order.class))).thenReturn(saved);

		// Act
		OrderResponse response = orderService.createOrder(request);

		// Assert
		assertThat(response).isNotNull();
		assertThat(response.getCustomerName()).isEqualTo("Alice");
		assertThat(response.getStatus()).isEqualTo(OrderStatus.CONFIRMED);
		verify(validator).validate(request);
		verify(paymentProcessor).process(anyDouble());
		verify(orderRepository).save(any(Order.class));
	}

	// ══════════════════════════════════════════════════════════════════════════
	// 2. createOrder — validator rejects bad input
	// ══════════════════════════════════════════════════════════════════════════

	@Test
	@DisplayName("Should throw InvalidOrderException when validator rejects request")
	void shouldThrowWhenValidationFails() {
		// Arrange
		OrderRequest bad = new OrderRequest(); // empty / invalid
		doThrow(new InvalidOrderException("Customer name is required"))
				.when(validator).validate(bad);

		// Act & Assert
		assertThatThrownBy(() -> orderService.createOrder(bad))
				.isInstanceOf(InvalidOrderException.class)
				.hasMessageContaining("Customer name is required");

		verifyNoInteractions(orderRepository, processorFactory);
	}

	// ══════════════════════════════════════════════════════════════════════════
	// 3. getOrderById — found
	// ══════════════════════════════════════════════════════════════════════════

	@Test
	@DisplayName("Should return order response when order exists")
	void shouldGetOrderById() {
		// Arrange
		Order order = buildSavedOrder(42L, "Bob");
		when(orderRepository.findById(42L)).thenReturn(Optional.of(order));

		// Act
		OrderResponse response = orderService.getOrderById(42L);

		// Assert
		assertThat(response.getId()).isEqualTo(42L);
		assertThat(response.getCustomerName()).isEqualTo("Bob");
		verify(orderRepository).findById(42L);
	}

	// ══════════════════════════════════════════════════════════════════════════
	// 4. getOrderById — not found
	// ══════════════════════════════════════════════════════════════════════════

	@Test
	@DisplayName("Should throw OrderNotFoundException when order does not exist")
	void shouldThrowWhenOrderNotFound() {
		// Arrange
		when(orderRepository.findById(99L)).thenReturn(Optional.empty());

		// Act & Assert
		assertThatThrownBy(() -> orderService.getOrderById(99L))
				.isInstanceOf(OrderNotFoundException.class)
				.hasMessageContaining("99");
	}

	// ══════════════════════════════════════════════════════════════════════════
	// 5. getAllOrders — empty repository
	// ══════════════════════════════════════════════════════════════════════════

	@Test
	@DisplayName("Should return empty list when no orders exist")
	void shouldReturnEmptyListWhenNoOrders() {
		// Arrange
		when(orderRepository.findAll()).thenReturn(List.of());

		// Act
		List<OrderResponse> result = orderService.getAllOrders();

		// Assert
		assertThat(result).isEmpty();
		verify(orderRepository).findAll();
	}

	// ══════════════════════════════════════════════════════════════════════════
	// 6. getAllOrders — multiple orders
	// ══════════════════════════════════════════════════════════════════════════

	@Test
	@DisplayName("Should return all orders mapped to responses")
	void shouldReturnAllOrders() {
		// Arrange
		when(orderRepository.findAll())
				.thenReturn(List.of(
						buildSavedOrder(1L, "Alice"),
						buildSavedOrder(2L, "Bob")
				));

		// Act
		List<OrderResponse> result = orderService.getAllOrders();

		// Assert
		assertThat(result).hasSize(2);
		assertThat(result).extracting(OrderResponse::getCustomerName)
				.containsExactlyInAnyOrder("Alice", "Bob");
	}

	// ══════════════════════════════════════════════════════════════════════════
	// 7. updateStatus
	// ══════════════════════════════════════════════════════════════════════════

	@Test
	@DisplayName("Should update order status successfully")
	void shouldUpdateOrderStatus() {
		// Arrange
		Order order = buildSavedOrder(1L, "Carol");
		when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
		when(orderRepository.save(order)).thenReturn(order);

		// Act
		OrderResponse response = orderService.updateStatus(1L, OrderStatus.SHIPPED);

		// Assert
		assertThat(response.getStatus()).isEqualTo(OrderStatus.SHIPPED);
		verify(orderRepository).save(order);
	}

	// ══════════════════════════════════════════════════════════════════════════
	// 8. cancelOrder
	// ══════════════════════════════════════════════════════════════════════════

	@Test
	@DisplayName("Should cancel order by setting status to CANCELLED")
	void shouldCancelOrder() {
		// Arrange
		Order order = buildSavedOrder(1L, "Dave");
		when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
		when(orderRepository.save(order)).thenReturn(order);

		// Act
		orderService.cancelOrder(1L);

		// Assert
		assertThat(order.getStatus()).isEqualTo(OrderStatus.CANCELLED);
		verify(orderRepository).save(order);
	}

	// ══════════════════════════════════════════════════════════════════════════
	// 9. cancelOrder — order not found
	// ══════════════════════════════════════════════════════════════════════════

	@Test
	@DisplayName("Should throw OrderNotFoundException when cancelling non-existent order")
	void shouldThrowWhenCancellingNonExistentOrder() {
		// Arrange
		when(orderRepository.findById(999L)).thenReturn(Optional.empty());

		// Act & Assert
		assertThatThrownBy(() -> orderService.cancelOrder(999L))
				.isInstanceOf(OrderNotFoundException.class);

		verify(orderRepository, never()).save(any());
	}

	// ══════════════════════════════════════════════════════════════════════════
	// 10. getOrdersByCustomer
	// ══════════════════════════════════════════════════════════════════════════

	@Test
	@DisplayName("Should return orders filtered by customer name")
	void shouldGetOrdersByCustomer() {
		// Arrange
		when(orderRepository.findByCustomerName("Eve"))
				.thenReturn(List.of(buildSavedOrder(5L, "Eve")));

		// Act
		List<OrderResponse> result = orderService.getOrdersByCustomer("Eve");

		// Assert
		assertThat(result).hasSize(1);
		assertThat(result.get(0).getCustomerName()).isEqualTo("Eve");
	}
}
