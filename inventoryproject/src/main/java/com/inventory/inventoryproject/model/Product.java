package com.inventory.inventoryproject.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String category;
    private double price;
    private int quantity;
    private String availableStatus;

    @OneToOne(mappedBy = "prod",cascade = CascadeType.REMOVE)//1st product post
    @JsonManagedReference
    public Supplier supplier;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonManagedReference
    public List<Bill> bill;

    @OneToOne(mappedBy="products",cascade = CascadeType.REMOVE)
    @JsonManagedReference
    public BarCode barcode;
}
