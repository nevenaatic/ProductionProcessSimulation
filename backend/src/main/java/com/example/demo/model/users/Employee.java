package com.example.demo.model.users;

import com.example.demo.model.productionProcess.EmployeeWithEngagement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorColumn(name="EE")
public class Employee extends User{

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("employee")
    private List<EmployeeWithEngagement> engagementList;

}
