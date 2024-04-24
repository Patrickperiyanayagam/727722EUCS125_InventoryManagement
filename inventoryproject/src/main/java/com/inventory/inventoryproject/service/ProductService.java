package com.inventory.inventoryproject.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.inventory.inventoryproject.model.Product;
import com.inventory.inventoryproject.repository.ProductRepository;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;
    public Product savProduct(Product product)
    {
        return productRepository.save(product);
    }
    public Product getProductID(int id)
    {
        return productRepository.findById(id).orElse(null);
    }
    public List<Product> getProductName(String name)
    {
        return productRepository.findByProductName(name);
    }
    public void deleteProduct(int id)
    {
        productRepository.deleteById(id);
    }
    public List<Product> getProductByPrice(double price)
    {
    return productRepository.findByPrice(price);
    }

    public List<Product> getallproducts(){
        return productRepository.findAll();
    }


    public Page<Product> getPage(int pageno,int size){
        return productRepository.findAll( PageRequest.of(pageno, size) );
    }
    public List<Product> getpagecontent(int pageno, int size){
        Page<Product> pg = productRepository.findAll( PageRequest.of(pageno, size));
        return pg.getContent();
    }

    public Page<Product> getpagesorted(int pageno,int size,String colname){
        return productRepository.findAll( PageRequest.of(pageno, size, Sort.by(Direction.DESC,colname)) );
    }
    
    public List<Product> getpriceBetweenRepo(int value1,int value2){
        return productRepository.findByPriceBetween(value1, value2);
    }

    public Page<Product> getPageBetweenPrice(int value1,int value2,Pageable page){
        return productRepository.findByPricePage(value1, value2, page);
    }

    // public void deleteTotal(){
    //     productRepository.deleteByTable();
    // }

    public List<Product> getall(){
        return productRepository.findAll();
    }
}
