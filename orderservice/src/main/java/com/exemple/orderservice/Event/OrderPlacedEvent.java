package com.exemple.orderservice.Event;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlacedEvent {
    private String orderId;
    private String productId;
    private int quantity;
}
