package com.inventory.inventoryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.inventoryproject.model.FetchPage;

public interface FetchRepository extends JpaRepository<FetchPage,Integer>{
    
}
