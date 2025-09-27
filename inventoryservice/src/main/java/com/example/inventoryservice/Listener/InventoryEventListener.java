package com.example.inventoryservice.Listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.inventoryservice.event.*;
import com.example.inventoryservice.service.InventoryService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor

public class InventoryEventListener {
    
    private final InventoryService inventoryService;

    @KafkaListener(
        topics = "order-placed-events",
        groupId = "inventory-service", //  consumer group ID
        containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(OrderPlacedEvent orderPlacedEvent) {
        inventoryService.processOrder(orderPlacedEvent);
    }
}
