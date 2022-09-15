package com.example.demo.model.product;

import com.example.demo.model.productionProcess.ProductionProcess;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @SequenceGenerator(name = "productSeqGen", sequenceName = "productSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSeqGen")
    private int id;
    @Column(nullable = true)
    private double finalPrice;
    @Column(nullable = true)
    private String usageDescription;
    @Column(nullable = true)
    private String name;

    @OneToMany(mappedBy = "productForFinal", fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("productForFinal")
    private List<FinalProduct> finalProductList;

    @OneToMany(mappedBy = "product", fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("product")
    private List<ProductionProcess> productionProcessList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
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
