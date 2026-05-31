package com.obedoza.app.service;

import com.obedoza.app.dto.OrderResponse;

// SOLID: ISP - Clients that only read orders
// don't need to know about create/cancel operations
public interface OrderQueryService {
    OrderResponse getOrder(Long id);
    java.util.List<OrderResponse> getAllOrders();
}