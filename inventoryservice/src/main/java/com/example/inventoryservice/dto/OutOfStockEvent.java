package com.example.inventoryservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutOfStockEvent {
    private String eventId;
    private String orderId;
    private String productId;
}
