package com.ovejera.app.grasp.util;

import com.ovejera.app.grasp.entity.Order;
import org.springframework.stereotype.Component;

// GRASP: High Cohesion
@Component
public class OrderValidator {

    public boolean isValid(Order order) {

        return order != null
                && order.getItems() != null
                && !order.getItems().isEmpty();
    }
}