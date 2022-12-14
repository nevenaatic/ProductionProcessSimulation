package com.example.demo.service.others;

import com.example.demo.model.others.Address;
import com.example.demo.repository.users.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public  AddressService(AddressRepository repository){ this.addressRepository=repository;}

    public Address save(Address course) {
        return addressRepository.save(course);
    }

}
