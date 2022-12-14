package com.example.demo.model.product;

import com.example.demo.enums.ProductType;
import com.example.demo.model.users.QualityEngineer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class FinalProduct {
    @Id
    @SequenceGenerator(name = "finalProductSeqGen", sequenceName = "finalProductSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "finalProductSeqGen")
    private int id;

    @Column
    private String label;

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


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

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
