package com.example.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventoryservice.entity.Product;

public interface InventoryRepository extends JpaRepository <Product,String> {
    
}
