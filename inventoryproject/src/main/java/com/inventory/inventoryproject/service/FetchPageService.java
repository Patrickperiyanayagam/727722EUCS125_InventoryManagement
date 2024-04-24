package com.inventory.inventoryproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.inventory.inventoryproject.model.FetchPage;
import com.inventory.inventoryproject.repository.FetchRepository;

@Service
public class FetchPageService {
    
    @Autowired
    public FetchRepository fetchRepository;

    public Page<FetchPage> getpage(int pageno,int size){
        return fetchRepository.findAll(PageRequest.of(pageno, size));
    }

    public String postpage(List<FetchPage> temp){
        fetchRepository.saveAll(temp);
        return "Stored in DB";
    }
}
