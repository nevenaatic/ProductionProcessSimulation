package com.example.demo.model.others;

import com.example.demo.enums.FailureType;
import com.example.demo.model.productionProcess.FinalProcessStep;
import com.example.demo.model.productionProcess.StepOfProductionProcess;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Failure {
    @Id
    private int id;
    @Column(nullable = true)
    private String name;
    @Column(nullable = false)
    private FailureType failureType;
    @Column(nullable = true)
    private double probability;

    @OneToMany(mappedBy = "failure", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("failure")
    private List<FailureInProcessStep> failureInPSList;



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

    public FailureType getFailureType() {
        return failureType;
    }

    public void setFailureType(FailureType failureType) {
        this.failureType = failureType;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}