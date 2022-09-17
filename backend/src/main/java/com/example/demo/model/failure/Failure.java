package com.example.demo.model.failure;

import com.example.demo.dto.failures.FailuresPreviewDto;
import com.example.demo.enums.FailureType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Failure {
    @Id
    @SequenceGenerator(name = "failureSeqGen", sequenceName = "failureSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "failureSeqGen")
    @Column(name = "id")
    private int id;
    @Column(nullable = true)
    private String name;
    @Column(nullable = false)
    private FailureType failureType;
    @Column(nullable = true)
    private double probability;

    @OneToMany(mappedBy = "failure", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("failure")
    private List<FailureInProcessStep> failureInPSList;


    public Failure() {
    }
    public Failure(FailuresPreviewDto failure) {
        this.name = failure.name;
        this.probability = failure.probability;
        this.failureType = failure.type;
    }
    public List<FailureInProcessStep> getFailureInPSList() {
        return failureInPSList;
    }

    public void setFailureInPSList(List<FailureInProcessStep> failureInPSList) {
        this.failureInPSList = failureInPSList;
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
