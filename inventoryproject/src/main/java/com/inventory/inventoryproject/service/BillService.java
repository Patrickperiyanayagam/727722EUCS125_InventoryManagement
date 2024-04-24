package com.inventory.inventoryproject.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.inventoryproject.model.Bill;
import com.inventory.inventoryproject.repository.BillRepository;

@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;
    public Bill savProduct(Bill order)
    {
        return billRepository.save(order);
    }
    public Bill getOrder(int id)
    {
        return billRepository.findById(id).orElse(null);
    }
    public List<Bill> getallbill(){
        return billRepository.findAll();
    }
    public void deleteProduct(int id)
    {
        billRepository.deleteById(id);
    }

    public double totalbill(){
        return billRepository.findByTotalPrice();
    }
    
}
