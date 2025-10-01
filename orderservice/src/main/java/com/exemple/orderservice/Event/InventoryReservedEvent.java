package com.exemple.orderservice.event;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryReservedEvent {
    private String id;
    private String productId;
    private int quantity;
}
