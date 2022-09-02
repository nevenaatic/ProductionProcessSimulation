package com.example.demo.model.others;

import com.example.demo.enums.MaterialUnits;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Material {
    @Id
    private int id;

    @Column(unique = true)
    private String label_id;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private MaterialUnits materialUnitType;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel_id() {
        return label_id;
    }

    public void setLabel_id(String label_id) {
        this.label_id = label_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaterialUnits getMaterialUnitType() {
        return materialUnitType;
    }

    public void setMaterialUnitType(MaterialUnits materialUnitType) {
        this.materialUnitType = materialUnitType;
    }
}
