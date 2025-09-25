package com.example.inventoryservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class InventoryReservedEvent {
    private String eventId;
    private String orderId;
    private String productId;
    private int quantity;
}