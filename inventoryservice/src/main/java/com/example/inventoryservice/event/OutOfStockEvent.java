package com.example.inventoryservice.event;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutOfStockEvent {
    private String id;
    private String productId;
}
