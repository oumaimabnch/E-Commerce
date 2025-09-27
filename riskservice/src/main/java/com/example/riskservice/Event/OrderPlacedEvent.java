package com.example.riskservice.Event;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class OrderPlacedEvent {
    private String orderId;
    private String productId;
    private int quantity;
}
