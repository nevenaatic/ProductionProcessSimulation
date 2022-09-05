package com.example.demo.dto.users;

import com.example.demo.model.others.Address;
import com.example.demo.model.users.Employee;

import java.util.Date;

public class EmployeePreviewDto {
    public int id;
    public String name;
    public String surname;
    public String email;
    public Date birthday;
    public String telephone;
    public Address address;
    public String profilePhoto;

    public EmployeePreviewDto(){}

    public EmployeePreviewDto(Employee employee){
        this.id = employee.getId();
        this.name = employee.getName();
        this.surname = employee.getSurname();
        this.address = employee.getAddress();
        this.birthday = employee.getBirthday();
        this.telephone = employee.getTelephone();
        this.email = employee.getEmail();
        this.profilePhoto = employee.getPicture();
    }
}
