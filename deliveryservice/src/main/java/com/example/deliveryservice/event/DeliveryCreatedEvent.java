package com.example.deliveryservice.event;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeliveryCreatedEvent {
    private String id;
    private String productId;
    private int quantity;
}
