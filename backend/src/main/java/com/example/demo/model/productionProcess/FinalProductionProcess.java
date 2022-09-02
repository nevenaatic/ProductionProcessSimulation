package com.example.demo.model.productionProcess;

import com.example.demo.model.users.ProcessEngineer;
import com.example.demo.model.users.QualityEngineer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class FinalProductionProcess {

    @Id
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="process_engineer_id")
    @JsonIgnoreProperties("processEngineer")
    private ProcessEngineer processEngineer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="production_process_id")
    @JsonIgnoreProperties("productionProcess")
    private ProductionProcess productionProcess;

    @OneToMany(mappedBy = "finalProductionProcess", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("finalProductionProcess")
    private List<FinalProcessStep> finalProcessStepList;

    public ProcessEngineer getProcessEngineer() {
        return processEngineer;
    }

    public void setProcessEngineer(ProcessEngineer processEngineer) {
        this.processEngineer = processEngineer;
    }

    public List<FinalProcessStep> getFinalProcessStepList() {
        return finalProcessStepList;
    }

    public void setFinalProcessStepList(List<FinalProcessStep> finalProcessStepList) {
        this.finalProcessStepList = finalProcessStepList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductionProcess getProductionProcess() {
        return productionProcess;
    }

    public void setProductionProcess(ProductionProcess productionProcess) {
        this.productionProcess = productionProcess;
    }
}
