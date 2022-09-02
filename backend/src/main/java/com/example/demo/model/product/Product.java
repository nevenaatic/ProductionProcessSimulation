package com.example.demo.model.product;

import com.example.demo.model.productionProcess.ProductionProcess;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    private int id;
    @Column(nullable = true)
    private double finalPrice;
    @Column(nullable = true)
    private String usageDescription;

    @OneToMany(mappedBy = "productForFinal", fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("productForFinal")
    private List<FinalProduct> finalProductList;

    @OneToMany(mappedBy = "product", fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("product")
    private List<ProductionProcess> productionProcessList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getUsageDescription() {
        return usageDescription;
    }

    public void setUsageDescription(String usageDescription) {
        this.usageDescription = usageDescription;
    }

    public List<FinalProduct> getFinalProductList() {
        return finalProductList;
    }

    public void setFinalProductList(List<FinalProduct> finalProductList) {
        this.finalProductList = finalProductList;
    }

    public List<ProductionProcess> getProductionProcessList() {
        return productionProcessList;
    }

    public void setProductionProcessList(List<ProductionProcess> productionProcessList) {
        this.productionProcessList = productionProcessList;
    }
}
