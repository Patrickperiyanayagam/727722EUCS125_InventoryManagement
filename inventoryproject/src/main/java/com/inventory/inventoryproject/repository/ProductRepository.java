package com.inventory.inventoryproject.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.inventoryproject.model.Product;
public interface ProductRepository extends JpaRepository<Product,Integer> {
    public List<Product> findByProductName(String productName);

    @Query("SELECT p FROM Product p WHERE p.price=?1")
    public List<Product> findByPrice(double price);

    @Query("SELECT p FROM Product p where p.price > :val1 and p.price < :val2")
    public List<Product> findByPriceBetween(@Param("val1") int a,@Param("val2") int b);

    @Query("SELECT p FROM Product p where p.price > :val1 and p.price < :val2")
    public Page<Product> findByPricePage(@Param("val1") int a,@Param("val2") int b,Pageable page);

    // @Modifying
    // @Query("delete p(*) from Product p")
    // public void deleteByTable();
}
