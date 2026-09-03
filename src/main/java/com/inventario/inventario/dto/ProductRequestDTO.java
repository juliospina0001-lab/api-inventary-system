package com.inventario.inventario.dto;

import java.math.BigDecimal;

public class ProductRequestDTO {

    private String name;
    private String description;
    private BigDecimal price;
    private Integer availableQuantity;
    private String category;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(String name, String description, BigDecimal price, Integer availableQuantity, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
