package com.inventory.inventoryproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.inventoryproject.model.BarCode;
import com.inventory.inventoryproject.repository.BarCodeRepository;

@Service
public class BarCodeService {
    @Autowired
    private BarCodeRepository barcodeRepository;
    public BarCode savebar(BarCode barcode)
    {
        return barcodeRepository.save(barcode);
    }
    public List<BarCode> getallbarcode(){
        return barcodeRepository.findAll();
    }
}
