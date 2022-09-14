package com.example.demo.model.productionProcess;

import com.example.demo.model.failure.Failure;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class StepOfProductionProcess implements Serializable {
    //this is table for TP between ProcessStep and ProductionProcess
    @Id
    @SequenceGenerator(name = "soppSeqGen", sequenceName = "soppSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "soppSeqGen")
    private int id;
    @Column(nullable = false)
    private int id_production_process; //strani kljuc
    @Column(nullable = false)
    private int id_production_step;  //strani kljuc
    @Column(nullable = false)
    private int processStepNumber;

   // @OneToMany(mappedBy = "stepOfPP", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
   // @JsonIgnoreProperties("stepOfPP")
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//    private FinalProcessStep finalProcessStep;


//   public FinalProcessStep getFinalProcessStep() {
//        return finalProcessStep;
//    }

//    public void setFinalProcessStepList(FinalProcessStep finalProcessStep) {
//        this.finalProcessStep = finalProcessStep;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_production_process() {
        return id_production_process;
    }

    public void setId_production_process(int id_production_process) {
        this.id_production_process = id_production_process;
    }

    public int getId_production_step() {
        return id_production_step;
    }

    public void setId_production_step(int id_production_step) {
        this.id_production_step = id_production_step;
    }

    public int getProcessStepNumber() {
        return processStepNumber;
    }

    public void setProcessStepNumber(int processStepNumber) {
        this.processStepNumber = processStepNumber;
    }

}
