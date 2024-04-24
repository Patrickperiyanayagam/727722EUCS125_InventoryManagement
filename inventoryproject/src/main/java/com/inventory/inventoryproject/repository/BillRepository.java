package com.inventory.inventoryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventory.inventoryproject.model.Bill;

public interface BillRepository extends JpaRepository<Bill,Integer>{
    
    @Query("SELECT SUM(p.totalPrice) FROM Bill p")
    public double findByTotalPrice();
}
