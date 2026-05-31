package com.obedoza.app.service;

import com.obedoza.app.dto.OrderRequest;
import com.obedoza.app.dto.OrderResponse;

// SOLID: ISP - Clients that only write orders
public interface OrderCommandService {
    OrderResponse createOrder(OrderRequest request);
    OrderResponse confirmOrder(Long id);
    void cancelOrder(Long id);
}