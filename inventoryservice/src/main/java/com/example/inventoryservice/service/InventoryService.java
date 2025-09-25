package com.example.inventoryservice.service;

import java.util.UUID;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.inventoryservice.dto.*;

import lombok.*;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void processOrder(OrderPlacedEvent order) {
        boolean available = checkStock(order.getProductId(), order.getQuantity());

  if (available) {
            InventoryReservedEvent reservedEvent = new InventoryReservedEvent(
                    UUID.randomUUID().toString(),
                    order.getOrderId(),
                    order.getProductId(),
                    order.getQuantity());
            kafkaTemplate.send("inventory-reserved-events", reservedEvent);
        } else {
            OutOfStockEvent outOfStockEvent = new OutOfStockEvent(
                    UUID.randomUUID().toString(),
                    order.getOrderId(),
                    order.getProductId());
            kafkaTemplate.send("out-of-stock-events", outOfStockEvent);
        }
    }

    private boolean checkStock(String productId, int quantity) {
        // Simulate inventory check (in a real service, query DB)
        return Math.random() > 0.5; // 50% chance stock is available
    }
}