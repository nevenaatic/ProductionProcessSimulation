package com.example.demo.model.productionProcess;

import com.example.demo.model.users.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EmployeeWithEngagement {
    @Id
    @SequenceGenerator(name = "engagementSeqGen", sequenceName = "engagementSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "engagementSeqGen")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="finalPS_id")
    @JsonIgnoreProperties("finalProcessStep")
    private FinalProcessStep finalProcessStep;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column
    private double  hours;

    public FinalProcessStep getFinalProcessStep() {
        return finalProcessStep;
    }

    public void setFinalProcessStep(FinalProcessStep finalProcessStep) {
        this.finalProcessStep = finalProcessStep;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
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

    public EmployeeWithEngagement(FinalProcessStep finalProcessStep, Employee employee, double hours) {
        this.finalProcessStep = finalProcessStep;
        this.employee = employee;
        this.hours = hours;
    }

    public EmployeeWithEngagement() {}
}
