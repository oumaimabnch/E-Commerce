package com.example.riskservice.Event;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutOfStockEvent {
    private String id;
    private String orderId;
    private String productId;
}
