package com.inventory.inventoryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.inventoryproject.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Integer>{
    
}
