package com.example.demo.model.productionProcess;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProcessStepKind {
    @Id
    @SequenceGenerator(name = "processStepKindSeqGen", sequenceName = "processStepKindSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "processStepKindSeqGen")
    @Column(name = "id")
    private int id;
    @Column(name="numberOfPeople", nullable = true)
    private int numberOfPeople;
    @Column(nullable = true)
    private String name;

    @OneToMany(mappedBy = "processStepKind", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("processStepKind")
    private List<ProcessStep> processStepList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProcessStep> getProcessStepList() {
        return processStepList;
    }

    public void setProcessStepList(List<ProcessStep> processStepList) {
        this.processStepList = processStepList;
    }
}
