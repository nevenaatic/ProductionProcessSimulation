package com.example.demo.model.productionProcess;

import com.example.demo.model.product.Product;
import com.example.demo.model.users.ProcessEngineer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductionProcess {

    @Id
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties("product")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "engineer_id")
    @JsonIgnoreProperties("processEngineer")
    private ProcessEngineer processEngineer;

    @OneToMany(mappedBy = "productionProcess", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("productionProcess")
    private List<FinalProductionProcess> finalProductionProcessList;


    public List<FinalProductionProcess> getFinalProductionProcessList() {
        return finalProductionProcessList;
    }

    public void setFinalProductionProcessList(List<FinalProductionProcess> finalProductionProcessList) {
        this.finalProductionProcessList = finalProductionProcessList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProcessEngineer getProcessEngineer() {
        return processEngineer;
    }

    public void setProcessEngineer(ProcessEngineer processEngineer) {
        this.processEngineer = processEngineer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
