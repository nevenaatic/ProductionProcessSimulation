package com.example.demo.dto.others;

import com.example.demo.model.others.Address;
import com.example.demo.model.others.Factory;

public class FactoryDto {

    public String name;
    public String description;
    public String email;
    public String pib;
    public String telephone;
    public Address address;

    public FactoryDto() {
    }

    public FactoryDto(Factory factory){
        this.name = factory.getName();
        this.address = factory.getAddress();
        this.email = factory.getEmail();
        this.pib = factory.getPib();
        this.telephone = factory.getTelephone();
        this.description = factory.getDescription();
    }
}
