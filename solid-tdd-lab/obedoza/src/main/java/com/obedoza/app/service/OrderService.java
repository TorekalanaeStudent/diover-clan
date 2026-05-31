package com.obedoza.app.service;

import com.obedoza.app.dto.OrderRequest;
import com.obedoza.app.dto.OrderResponse;

import java.util.List;

public interface OrderService extends OrderQueryService, OrderCommandService{
    OrderResponse createOrder (OrderRequest request);
    OrderResponse getOrder(Long id);
    List<OrderResponse> getAllOrders();
    OrderResponse confirmOrder(Long id);
    void cancelOrder(Long id);
}
