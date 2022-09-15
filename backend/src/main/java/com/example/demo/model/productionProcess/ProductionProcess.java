package com.example.demo.model.productionProcess;

import com.example.demo.model.product.Product;
import com.example.demo.model.users.ProcessEngineer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductionProcess {

    @Id
    @SequenceGenerator(name = "productionProcessSeqGen", sequenceName = "productionProcessSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productionProcessSeqGen")
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private Boolean finished;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties("product")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "engineer_id")
    @JsonIgnoreProperties("processEngineer")
    private ProcessEngineer processEngineer;

    @OneToMany(mappedBy = "productionProcess", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("productionProcess")
    private List<FinalProductionProcess> finalProductionProcessList;

    @OneToMany(mappedBy = "productionProcess", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("productionProcess")
    private List<StepOfProductionProcess> stepOfPPList;

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

    public ProductionProcess() {
    }

    public ProductionProcess(int id, String name, String description, Product product, ProcessEngineer processEngineer, List<FinalProductionProcess> finalProductionProcessList, Boolean finished) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.product = product;
        this.processEngineer = processEngineer;
        this.finalProductionProcessList = finalProductionProcessList;
        this.finished = finished;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }
}
