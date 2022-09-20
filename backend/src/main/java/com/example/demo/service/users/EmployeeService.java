package com.example.demo.service.users;

import com.example.demo.model.productionProcess.EmployeeWithEngagement;
import com.example.demo.model.users.Employee;
import com.example.demo.repository.users.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesWithEngagements(){
        List<Employee> ret = new ArrayList<>();
        for(Employee e: getAll()){
            ret.add(employeeRepository.getEmployeeWithEngagements(e.getId()));
        }
        return ret;
    }

    public Employee getEmployeeWithEngagement(int id){
        return employeeRepository.getEmployeeWithEngagements(id);
    }
}
