package com.example.demo.model.productionProcess;

import com.example.demo.model.users.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EmployeeWithEngagement {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="finalPS_id")
    @JsonIgnoreProperties("finalProcessStep")
    private FinalProcessStep finalProcessStep;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column
    private Date dateStart;
    @Column
    private Date dateEnd;

    public FinalProcessStep getFinalProcessStep() {
        return finalProcessStep;
    }

    public void setFinalProcessStep(FinalProcessStep finalProcessStep) {
        this.finalProcessStep = finalProcessStep;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
