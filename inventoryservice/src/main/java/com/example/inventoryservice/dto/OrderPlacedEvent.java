package com.example.inventoryservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class OrderPlacedEvent {
    private String orderId;
    private String productId;
    private int quantity;
}
