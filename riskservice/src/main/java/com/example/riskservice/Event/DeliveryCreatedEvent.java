package com.example.riskservice.Event;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class DeliveryCreatedEvent {
    private String deliveryId;
    private String orderId;
    private String productId;
    private int quantity;
}
