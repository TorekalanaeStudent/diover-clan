package com.learning.appl;

import com.learning.appl.dto.OrderResponse;
import com.learning.appl.entity.Order;
import com.learning.appl.entity.OrderStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderImmutabilityTest {

    @Test
    @DisplayName("Order items collection cannot be modified from outside the aggregate")
    void orderItemsShouldBeReadOnlyFromOutside() {
        Order order = new Order("Alice");
        order.addItem("Widget", 1, 25.00);

        assertThatThrownBy(() -> order.getItems().clear())
                .isInstanceOf(UnsupportedOperationException.class);
        assertThat(order.getItems()).hasSize(1);
    }

    @Test
    @DisplayName("OrderResponse items are immutable snapshots")
    void orderResponseItemsShouldBeImmutable() {
        Order order = new Order("Bob");
        order.addItem("Cable", 2, 7.50);
        order.setStatus(OrderStatus.CONFIRMED);

        OrderResponse response = OrderResponse.from(order);

        assertThatThrownBy(() -> response.getItems().clear())
                .isInstanceOf(UnsupportedOperationException.class);
        assertThat(response.getTotal()).isEqualTo(15.00);
        assertThat(response.getItems()).hasSize(1);
    }
}
