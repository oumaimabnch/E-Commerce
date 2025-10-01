package com.example.deliveryservice.event;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryReservedEvent {
    private String id;
    private String productId;
    private int quantity;
}