package com.exemple.orderservice.service;

import org.springframework.stereotype.Service;

import com.exemple.orderservice.entity.Order;
import com.exemple.orderservice.event.OrderEventPublisher;

import lombok.*;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderEventPublisher publisher;

    public void placeOrder(Order order) {
        publisher.publishOrderPlaced(order);
    }
}
