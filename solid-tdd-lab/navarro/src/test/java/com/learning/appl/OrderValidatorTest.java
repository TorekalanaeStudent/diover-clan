package com.learning.appl;

import com.learning.appl.dto.OrderRequest;
import com.learning.appl.exception.InvalidOrderException;
import com.learning.appl.util.OrderValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderValidatorTest {

    private final OrderValidator validator = new OrderValidator();

    @Test
    @DisplayName("Should accept valid order request")
    void shouldAcceptValidRequest() {
        assertThatCode(() -> validator.validate(validRequest()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Should reject null request")
    void shouldRejectNullRequest() {
        assertThatThrownBy(() -> validator.validate(null))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessageContaining("must not be null");
    }

    @Test
    @DisplayName("Should reject empty items")
    void shouldRejectEmptyItems() {
        OrderRequest request = validRequest();
        request.setItems(List.of());

        assertThatThrownBy(() -> validator.validate(request))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessageContaining("at least one item");
    }

    @Test
    @DisplayName("Should reject invalid item values")
    void shouldRejectInvalidItemValues() {
        OrderRequest request = validRequest();
        request.getItems().get(0).setQuantity(0);

        assertThatThrownBy(() -> validator.validate(request))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessageContaining("quantity");
    }

    @Test
    @DisplayName("Should reject missing payment method")
    void shouldRejectMissingPaymentMethod() {
        OrderRequest request = validRequest();
        request.setPaymentMethod(" ");

        assertThatThrownBy(() -> validator.validate(request))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessageContaining("Payment method");
    }

    private OrderRequest validRequest() {
        OrderRequest request = new OrderRequest();
        request.setCustomerName("Alice");
        request.setPaymentMethod("CREDIT_CARD");

        OrderRequest.OrderItemRequest item = new OrderRequest.OrderItemRequest();
        item.setProductName("Widget");
        item.setQuantity(2);
        item.setUnitPrice(10.00);
        request.setItems(List.of(item));

        return request;
    }
}
