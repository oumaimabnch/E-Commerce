package com.example.deliveryservice.event;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryReservedEvent {
    private String eventId;
    private String orderId;
    private String productId;
    private int quantity;
}