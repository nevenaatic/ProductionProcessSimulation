package com.example.demo.service.others;

import com.example.demo.dto.others.FactoryDto;
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

    public Factory editFactory(FactoryDto factoryDto){
        Factory factory = getAll();
        factory.setName(factoryDto.name);
        factory.setAddress(factoryDto.address);
        factory.setDescription(factoryDto.description);
        factory.setTelephone(factoryDto.telephone);
        factory.setPib(factoryDto.pib);
        return factoryRepository.save(factory);
    }
}
