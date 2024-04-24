package com.inventory.inventoryproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.inventoryproject.model.Supplier;
import com.inventory.inventoryproject.repository.SupplierRepository;

@Service
public class SupplierService {
    @Autowired
    public SupplierRepository supplierRepository;

    public Supplier postsupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }
    public Supplier getsupplier(int id){
        return supplierRepository.findById(id).orElse(null);
    }
    public List<Supplier> getallsupplier(){
        return supplierRepository.findAll();
    }
}
