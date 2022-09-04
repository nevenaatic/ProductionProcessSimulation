package com.example.demo.dto.users;

import com.example.demo.enums.EmployeeType;
import com.example.demo.enums.Gender;
import com.example.demo.model.others.Address;
import com.example.demo.model.users.User;

import java.util.Date;

public class UserProfileInfoDto {

    public int id;
    public String name;
    public String surname;
    public String email;
    public Date birthday;
    public String profilePhoto;
    public String telephone;
    public Gender gender;
   public Address address;
    public EmployeeType type;

    public UserProfileInfoDto() {
    }

    public UserProfileInfoDto(User user) {
        this.id= user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.birthday = user.getBirthday();
        this.address = user.getAddress();
        this.email = user.getEmail();
        this.profilePhoto = user.getPicture();
        this.gender = user.getGender();
        this.telephone = user.getTelephone();
        this.type = user.getType();
    }
}
