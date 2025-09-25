package com.exemple.orderservice.Event;

import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.exemple.orderservice.entity.Order;

import lombok.*;

@Component
@RequiredArgsConstructor
public class OrderEventPublisher {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishOrderPlaced(Order order) {
        OrderPlacedEvent event = new OrderPlacedEvent(UUID.randomUUID().toString(), order.getProductId(),
                order.getQuantity());
        kafkaTemplate.send("order-placed-events", event);
    }
}