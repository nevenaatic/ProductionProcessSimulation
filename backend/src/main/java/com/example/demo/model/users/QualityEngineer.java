package com.example.demo.model.users;

import com.example.demo.model.others.FailureInProcessStep;
import com.example.demo.model.product.FinalProduct;
import com.example.demo.model.productionProcess.ProcessStep;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorColumn(name = "QE")
public class QualityEngineer extends User {

    @OneToMany(mappedBy = "qualityEngineer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("qualityEngineer")
    private List<FinalProduct> finalProductList;

    @OneToMany(mappedBy = "qualityEngineer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("qualityEngineer")
    private List<FailureInProcessStep> failureInPSList;

    public List<FailureInProcessStep> getFailureInPSList() {
        return failureInPSList;
    }

    public void setFailureInPSList(List<FailureInProcessStep> failureInPSList) {
        this.failureInPSList = failureInPSList;
    }

    public List<FinalProduct> getFinalProductList() {
        return finalProductList;
    }

    public void setFinalProductList(List<FinalProduct> finalProductList) {
        this.finalProductList = finalProductList;
    }
}