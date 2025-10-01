package com.example.deliveryservice.Listener;

import java.util.UUID;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.deliveryservice.event.DeliveryCreatedEvent;
import com.example.deliveryservice.event.InventoryReservedEvent;

import lombok.*;

@Component
@RequiredArgsConstructor
public class DeliveryEventListener {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = "inventory-reserved-events", groupId = "delivery-service")
    public void listenInventoryReserved(InventoryReservedEvent event) {
        System.out.println("Received InventoryReservedEvent: " + event);

        DeliveryCreatedEvent deliveryEvent = new DeliveryCreatedEvent(
                event.getId(),
                event.getProductId(),
                event.getQuantity());

        kafkaTemplate.send("delivery-created-events", deliveryEvent);
    }
}
