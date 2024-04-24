package com.inventory.inventoryproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FetchPage {
    @Id
    private int productId;
    private String productName;
    private String category;
    private double price;
    private int quantity;
    private String availableStatus;
}
