package com.example.inventoryservice.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.inventoryservice.entity.Product;
import com.example.inventoryservice.event.*;
import com.example.inventoryservice.repository.InventoryRepository;

import lombok.*;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final InventoryRepository inventoryRepository ;

    public void processOrder(OrderPlacedEvent order) {
         Product product = inventoryRepository.findById(order.getProductId()).get();
         
            System.out.println("Received event product : " + product);

  if (product.getQuantity() >= order.getQuantity() ) {

            System.out.println("Received event: " + order);
             product.setQuantity(product.getQuantity()- order.getQuantity());
             inventoryRepository.save(product);
             sendReservedEvent(order);
           

        } else if (product.getQuantity() <= 0 || product.getQuantity() < order.getQuantity()){

                        System.out.println("Received order: " + order.getQuantity());

            sendOutOfStock(order);
            
        }
    }

     private void sendOutOfStock(OrderPlacedEvent order) {
        OutOfStockEvent outOfStockEvent = new OutOfStockEvent(
                order.getId(),
                order.getProductId()
        );
        kafkaTemplate.send("out-of-stock-events", outOfStockEvent);
    }
    private void sendReservedEvent (OrderPlacedEvent order) {
     InventoryReservedEvent reservedEvent = new InventoryReservedEvent(
                    order.getId(),
                    order.getProductId(),
                    order.getQuantity());
            kafkaTemplate.send("inventory-reserved-events", reservedEvent);

}}