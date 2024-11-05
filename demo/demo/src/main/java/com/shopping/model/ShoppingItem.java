package com.shopping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShoppingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer quantity;
    private String category;
    private Boolean isPurchased;

    // Getters
    public String getName() { return name; }
    public Integer getQuantity() { return quantity; }
    public String getCategory() { return category; }
    public Boolean getIsPurchased() { return isPurchased; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setCategory(String category) { this.category = category; }
    public void setIsPurchased(Boolean isPurchased) { this.isPurchased = isPurchased; }
}
