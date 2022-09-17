package com.example.demo.model.failure;

import com.example.demo.model.failure.Failure;
import com.example.demo.model.productionProcess.FinalProcessStep;
import com.example.demo.model.productionProcess.ProcessStep;
import com.example.demo.model.users.QualityEngineer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class FailureInProcessStep {
    //class for TP between Failure, ProcessStep and QualityEngineer
    @Id
    @SequenceGenerator(name = "failureipsSeqGen", sequenceName = "failureipsSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "failureipsSeqGen")
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "failure_id")
    @JsonIgnoreProperties("failure")
    private Failure failure;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("processStep")
    private ProcessStep processStep;

    @OneToMany(mappedBy = "failureInPS", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("failureInPS")
    private List<FinalProcessStep> finalProcessStepList;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "quality_engineer_id")
    @JsonIgnoreProperties("qualityEngineer")
    private QualityEngineer qualityEngineer;



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

    public Failure getFailure() {
        return failure;
    }

    public void setFailure(Failure failure) {
        this.failure = failure;
    }

    public ProcessStep getProcessStepList() {
        return processStep;
    }

    public void setProcessStepList(ProcessStep processStep) {
        this.processStep = processStep;
    }

    public ProcessStep getProcessStep() {
        return processStep;
    }

    public void setProcessStep(ProcessStep processStep) {
        this.processStep = processStep;
    }

    public List<FinalProcessStep> getFinalProcessStepList() {
        return finalProcessStepList;
    }

    public void setFinalProcessStepList(List<FinalProcessStep> finalProcessStepList) {
        this.finalProcessStepList = finalProcessStepList;
    }
}
