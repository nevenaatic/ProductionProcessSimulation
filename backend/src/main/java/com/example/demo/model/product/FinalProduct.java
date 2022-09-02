package com.example.demo.model.product;

import com.example.demo.enums.ProductType;
import com.example.demo.model.users.QualityEngineer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class FinalProduct {
    @Id
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="product_id")
    @JsonIgnoreProperties("productForFinal")
    private Product productForFinal;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="engineer_id")
    @JsonIgnoreProperties("qualityEngineer")
    private QualityEngineer qualityEngineer;

    @Column(nullable = true)
    private ProductType productType;

    @Column(nullable = true)
    private boolean checked;

    public Product getProductForFinal() {
        return productForFinal;
    }

    public void setProductForFinal(Product productForFinal) {
        this.productForFinal = productForFinal;
    }

    public QualityEngineer getQualityEngineer() {
        return qualityEngineer;
    }

    public void setQualityEngineer(QualityEngineer qualityEngineer) {
        this.qualityEngineer = qualityEngineer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return productForFinal;
    }

    public void setProduct(Product product) {
        this.productForFinal = product;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
