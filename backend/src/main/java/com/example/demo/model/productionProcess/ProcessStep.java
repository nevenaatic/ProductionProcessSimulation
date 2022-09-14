package com.example.demo.model.productionProcess;

import com.example.demo.model.failure.FailureInProcessStep;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ProcessStep {
    @Id
    @SequenceGenerator(name = "processStepSeqGen", sequenceName = "processStepSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "processStepSeqGen")
    @Column(name = "id")
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private String description;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "process_step_kind_id")
    @JsonIgnoreProperties("processStepKind")
    private ProcessStepKind processStepKind;

    @OneToMany(mappedBy = "processStep", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("processStep")
    private List<FailureInProcessStep> failureInPSList;

    @Column(nullable = true)
    private Boolean finished;


    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProcessStepKind getProcessStepKind() {
        return processStepKind;
    }

    public void setProcessStepKind(ProcessStepKind processStepKind) {
        this.processStepKind = processStepKind;
    }

    public ProcessStep( String name, String description, ProcessStepKind processStepKind, List<FailureInProcessStep> failureInPS, Boolean finished) {
        this.name = name;
        this.description = description;
        this.processStepKind = processStepKind;
        this.failureInPSList = failureInPS;
        this.finished = finished;
    }

    public ProcessStep() {
    }

}
