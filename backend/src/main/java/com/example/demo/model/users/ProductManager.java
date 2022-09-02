package com.example.demo.model.users;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "PM")
public class ProductManager extends User {


}
