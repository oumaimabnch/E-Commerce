package com.example.riskservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class DeliveryCreatedEvent {
    private String deliveryId;
    private String orderId;
    private String productId;
    private int quantity;
}
