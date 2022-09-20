package com.example.demo.dto.products;

import com.example.demo.model.product.Product;

public class ProductDto {

    public int id;
    public String name;
    public double finalPrice;
    public String description;


    public ProductDto(){}

    public ProductDto(Product product){
        this.id= product.getId();
        this.name = product.getName();
        this.description= product.getUsageDescription();
        this.finalPrice = product.getFinalPrice();

    }
}
