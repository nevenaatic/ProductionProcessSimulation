package com.example.demo.model.productionProcess;

import com.example.demo.model.others.FailureInProcessStep;
import com.example.demo.model.users.QualityEngineer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class FinalProcessStep {

    @Id
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="SOfPP_id")
    @JsonIgnoreProperties("stepOfPP")
    private StepOfProductionProcess stepOfPP;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="failureInPS_id")
    @JsonIgnoreProperties("failureInPS")
    private FailureInProcessStep failureInPS;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="finalPP_id")
    @JsonIgnoreProperties("finalProductionProcess")
    private FinalProductionProcess finalProductionProcess;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StepOfProductionProcess getStepOfPP() {
        return stepOfPP;
    }

    public void setStepOfPP(StepOfProductionProcess stepOfPP) {
        this.stepOfPP = stepOfPP;
    }

    public FailureInProcessStep getFailureInPS() {
        return failureInPS;
    }

    public void setFailureInPS(FailureInProcessStep failureInPS) {
        this.failureInPS = failureInPS;
    }

    public FinalProductionProcess getFinalProductionProcess() {
        return finalProductionProcess;
    }

    public void setFinalProductionProcess(FinalProductionProcess finalProductionProcess) {
        this.finalProductionProcess = finalProductionProcess;
    }

}
