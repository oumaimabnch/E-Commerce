package com.example.inventoryservice.event;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryReservedEvent {
    private String eventId;
    private String orderId;
    private String productId;
    private int quantity;
}