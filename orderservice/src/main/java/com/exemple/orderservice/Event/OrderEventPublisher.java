package com.exemple.orderservice.event;

import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.exemple.orderservice.entity.Order;
import com.exemple.orderservice.entity.OrderStatus;
// import com.exemple.orderservice.repository.OrderRepository;

import lombok.*;

@Component
@RequiredArgsConstructor
public class OrderEventPublisher {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    // private final OrderRepository  orderRepository;

    public void publishOrderPlaced(Order order) {
        order.setId(UUID.randomUUID().toString());
        order.setStatus(OrderStatus.PENDING);
        // orderRepository.save(order);

        kafkaTemplate.send("order-placed-events", order);
    }
}