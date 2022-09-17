package com.example.demo.dto.process;

import com.example.demo.enums.MaterialType;
import com.example.demo.enums.MaterialUnits;
import com.example.demo.model.others.Material;

public class MaterialDto {

    public  int id;
    public String name;
    public double price;
    public MaterialUnits unit;
    public String label;

    public MaterialDto() {
    }
    public MaterialDto(Material m) {
        this.id = m.getId();
        this.name =m.getName();
        this.price = m.getPrice();
        this.unit=m.getMaterialUnitType();
        this.label = m.getLabel_id();
    }
    public MaterialDto(int id, String name, double price, MaterialUnits type, String label) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = type;
        this.label = label;
    }


}
