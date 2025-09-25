package com.exemple.orderservice.service;

import org.springframework.stereotype.Service;

import com.exemple.orderservice.Event.OrderEventPublisher;
import com.exemple.orderservice.entity.Order;

import lombok.*;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderEventPublisher publisher;

    public void placeOrder(Order order) {
        // Save order to DB (skipped for demo)
        publisher.publishOrderPlaced(order);
    }
}
