package com.inventory.inventoryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.inventoryproject.model.BarCode;

public interface BarCodeRepository extends JpaRepository<BarCode,String>{
    
}
