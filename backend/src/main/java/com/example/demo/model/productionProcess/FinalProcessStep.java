package com.example.demo.model.productionProcess;

import com.example.demo.model.failure.FailureInProcessStep;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//    @JoinColumn(name="finalPP_id")
//    @JsonIgnoreProperties("finalProductionProcess")
//    private FinalProductionProcess finalProductionProcess;

    @OneToMany(mappedBy = "finalProcessStep", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("finalProcessStep")
    private List<EmployeeWithEngagement> employeesWithEngagements;

    @Column
    private Date dateStart; //when first employee start
    @Column
    private Date dateEnd; //when last employee end

    public List<EmployeeWithEngagement> getEmployeesWithEngagements() {
        return employeesWithEngagements;
    }

    public void setEmployeesWithEngagements(List<EmployeeWithEngagement> employeesWithEngagements) {
        this.employeesWithEngagements = employeesWithEngagements;
    }


    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

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

//    public FinalProductionProcess getFinalProductionProcess() {
//        return finalProductionProcess;
//    }
//
//    public void setFinalProductionProcess(FinalProductionProcess finalProductionProcess) {
//        this.finalProductionProcess = finalProductionProcess;
//    }

}
