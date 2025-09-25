package com.example.riskservice;

import java.util.UUID;
import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.riskservice.dto.*;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RiskEventListener {

    @KafkaListener(topics = "order-placed-events", groupId = "risk-service")
    public void handleOrderPlaced(OrderPlacedEvent event) {
        log.info("[RiskService] Order placed: {}", event);
        // Demo logic: maybe flag risk if quantity is large
        if (event.getQuantity() > 10) {
            log.warn("[RiskService] High-risk order detected for product {}", event.getProductId());
        }
    }

    @KafkaListener(topics = "out-of-stock-events", groupId = "risk-service")
    public void handleOutOfStock(OutOfStockEvent event) {
        log.info("[RiskService] Out of stock: {}", event);
        // Demo logic: flag risk if critical product
        log.warn("[RiskService] Risk alert: product {} out of stock!", event.getProductId());
    }

    @KafkaListener(topics = "delivery-created-events", groupId = "risk-service")
    public void handleDeliveryCreated(DeliveryCreatedEvent event) {
        log.info("[RiskService] Delivery created: {}", event);
        // Demo: monitor if delivery delays could cause risk
    }

}
