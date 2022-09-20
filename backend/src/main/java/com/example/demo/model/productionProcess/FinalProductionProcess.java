package com.example.demo.model.productionProcess;

import com.example.demo.model.users.ProcessEngineer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class FinalProductionProcess {

    @Id
    @SequenceGenerator(name = "finalProductionSeqGen", sequenceName = "finalProductionSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "finalProductionSeqGen")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="process_engineer_id")
    @JsonIgnoreProperties("processEngineer")
    private ProcessEngineer processEngineer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="production_process_id")
    @JsonIgnoreProperties("productionProcess")
    private ProductionProcess productionProcess;

    @OneToMany(mappedBy = "finalProductionProcess", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("finalProductionProcess")
    private List<FinalProcessStep> finalProcessStepList = new ArrayList<>();

    @Column
    private  String label;

    @Column
    private Date dateStart;

    public Date getDateStart() {
        return dateStart;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

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
