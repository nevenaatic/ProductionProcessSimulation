package com.example.demo.service.others;

import com.example.demo.model.others.Factory;
import com.example.demo.repository.others.FactoryRepository;
import org.springframework.stereotype.Service;

@Service
public class FactoryService {

    private FactoryRepository factoryRepository;

    public FactoryService(FactoryRepository factoryRepository) {
        this.factoryRepository = factoryRepository;
    }

    public Factory getAll(){
        return (factoryRepository.findAll()).get(0); //we have only one factory
    }
}
