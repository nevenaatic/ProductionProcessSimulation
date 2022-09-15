package com.example.demo.model.productionProcess;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class StepOfProductionProcess  {
    //this is table for TP between ProcessStep and ProductionProcess
    @Id
    @SequenceGenerator(name = "soppSeqGen", sequenceName = "soppSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "soppSeqGen")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "step_id")
    @JsonIgnoreProperties("processStep")
    private ProcessStep processStep;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "process_id")
    @JsonIgnoreProperties("productionProcess")
    private ProductionProcess productionProcess;

    @Column(nullable = false)
    private int processStepNumber;

    @OneToMany(mappedBy = "stepOfPP", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("stepOfPP")
    private List<FinalProcessStep> finalProcessStepList;

    public ProcessStep getProcessStep() {
        return processStep;
    }

    public void setProcessStep(ProcessStep processStep) {
        this.processStep = processStep;
    }

    public ProductionProcess getProductionProcess() {
        return productionProcess;
    }

    public void setProductionProcess(ProductionProcess productionProcess) {
        this.productionProcess = productionProcess;
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


    public int getProcessStepNumber() {
        return processStepNumber;
    }

    public void setProcessStepNumber(int processStepNumber) {
        this.processStepNumber = processStepNumber;
    }

}
