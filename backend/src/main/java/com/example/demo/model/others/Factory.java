package com.example.demo.model.others;

import com.example.demo.model.others.Address;
import com.example.demo.model.users.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Factory {
    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String pib;
    @OneToOne(fetch = FetchType.EAGER)
    private Address address;
    @Column(nullable = true)
    private String telephone;
    @Column(nullable = true)
    private String email;
    @Column(nullable = true, length = 1000000)
    private String description;

    @OneToMany(mappedBy = "factory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("factory")
    private List<User> users;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
