package com.example.demo.service.productionProcess;

import com.example.demo.repository.productionProcess.MaterialRepository;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    private MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository){
        this.materialRepository = materialRepository;
    }
}
