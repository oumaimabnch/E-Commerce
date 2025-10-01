package com.exemple.orderservice.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.exemple.orderservice.entity.Order;
import com.exemple.orderservice.entity.OrderStatus;
import com.exemple.orderservice.event.OrderEventPublisher;
import com.exemple.orderservice.repository.OrderRepository;

import lombok.*;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderEventPublisher publisher;
    private final OrderRepository orderRepository;

    public void placeOrder(Order order) {
    
        order.setStatus(OrderStatus.PENDING);
     Order savedOrder =   orderRepository.save(order);
     
        publisher.publishOrderPlaced(savedOrder);
           
    }
}
