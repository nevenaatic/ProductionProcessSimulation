package com.example.demo.model.users;

import com.example.demo.model.productionProcess.EmployeeWithEngagement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("EE")
public class Employee extends User{

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("employee")
    private List<EmployeeWithEngagement> engagementList;

    public Employee() { }

    public List<EmployeeWithEngagement> getEngagementList() {
        return engagementList;
    }

    public void setEngagementList(List<EmployeeWithEngagement> engagementList) {
        this.engagementList = engagementList;
    }
}
