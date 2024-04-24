package com.inventory.inventoryproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BarCode {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String barcode;
    private String productname;

    @OneToOne
    @JsonBackReference
    public Product products;
}
