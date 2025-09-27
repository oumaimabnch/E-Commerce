package com.example.deliveryservice.event;

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
