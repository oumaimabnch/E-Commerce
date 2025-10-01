package com.example.inventoryservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products") 
public class Product {

    @Id
    private String Id;
    private int quantity;
    private String category;

    
}
