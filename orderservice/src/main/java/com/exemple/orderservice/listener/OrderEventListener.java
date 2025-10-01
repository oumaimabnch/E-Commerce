package com.exemple.orderservice.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.exemple.orderservice.entity.OrderStatus;
import com.exemple.orderservice.repository.OrderRepository;
import com.exemple.orderservice.event.DeliveryCreatedEvent;
import com.exemple.orderservice.event.InventoryReservedEvent;
import com.exemple.orderservice.event.OutOfStockEvent;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j

public class OrderEventListener {

    private final OrderRepository orderRepository;

    @KafkaListener(topics = "inventory-reserved-events", groupId = "order-service",
                       containerFactory = "orderPlacedKafkaListenerFactory")

    public void handleInventoryReserved(InventoryReservedEvent event) {
        log.info("[OrderService] Inventory reserved: {}", event);

        orderRepository.findById(event.getId()).ifPresent(order -> {
            order.setStatus(OrderStatus.RESERVED);
            orderRepository.save(order);
        });
    }

    @KafkaListener(topics = "out-of-stock-events", groupId = "order-service",
   containerFactory = "outOfStockKafkaListenerFactory")
    public void handleOutOfStock(OutOfStockEvent event) {
        log.info("[OrderService] Out of stock: {}", event);

        orderRepository.findById(event.getOrderId()).ifPresent(order -> {
            order.setStatus(OrderStatus.OUT_OF_STOCK);
            orderRepository.save(order);
        });
    }

    @KafkaListener(topics = "delivery-created-events", groupId = "order-service",
                   containerFactory = "deliveryCreatedKafkaListenerFactory")
    public void handleDeliveryCreated(DeliveryCreatedEvent event) {
        log.info("[OrderService] Delivery created: {}", event);
        
orderRepository.findById(event.getId()).ifPresent(order -> {
            order.setStatus(OrderStatus.DELIVERED);
            orderRepository.save(order);
        });    }

}
