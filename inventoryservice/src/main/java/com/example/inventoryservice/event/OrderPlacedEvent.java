package com.example.inventoryservice.event;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPlacedEvent {
    private String id;
    private String productId;
    private int quantity;
}

