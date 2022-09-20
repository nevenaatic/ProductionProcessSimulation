package com.example.demo.dto.products;

import com.example.demo.enums.ProductType;

public class FinalProductDto {

    public int id;
    public String label;
    public String name;
    public ProductType type;
    public boolean checked;

    public FinalProductDto(int id, String label, String name, ProductType type, boolean checked) {
        this.id = id;
        this.label = label;
        this.name = name;
        this.type = type;
        this.checked = checked;
    }

    public FinalProductDto() {
    }
}
