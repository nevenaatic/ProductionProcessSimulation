package com.example.demo.model.others;

import com.example.demo.model.productionProcess.FinalProcessStep;
import com.example.demo.model.productionProcess.ProcessStep;
import com.example.demo.model.users.ProcessEngineer;
import com.example.demo.model.users.QualityEngineer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class FailureInProcessStep {
    //class for TP between Failure, ProcessStep and QualityEngineer
    @Id
    private int id;

    @OneToMany(mappedBy = "failureInPS", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("failureInPS")
    private List<FinalProcessStep> finalProcessStepList;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "failure_id")
    @JsonIgnoreProperties("failure")
    private Failure failure;

    @OneToMany(mappedBy = "failureInPS", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("failureInPS")
    private List<ProcessStep> processStepList;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "quality_engineer_id")
    @JsonIgnoreProperties("qualityEngineer")
    private QualityEngineer qualityEngineer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FinalProcessStep> getFinalProcessStepList() {
        return finalProcessStepList;
    }

    public void setFinalProcessStepList(List<FinalProcessStep> finalProcessStepList) {
        this.finalProcessStepList = finalProcessStepList;
    }

    public Failure getFailure() {
        return failure;
    }

    public void setFailure(Failure failure) {
        this.failure = failure;
    }

    public List<ProcessStep> getProcessStepList() {
        return processStepList;
    }

    public void setProcessStepList(List<ProcessStep> processStepList) {
        this.processStepList = processStepList;
    }
}
