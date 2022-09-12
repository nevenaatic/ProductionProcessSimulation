package com.example.demo.service.productionProcess;

import com.example.demo.repository.productionProcess.ProcessStepMaterialRepository;
import org.springframework.stereotype.Service;

@Service
public class ProcessStepMaterialService {

    private ProcessStepMaterialRepository processStepMaterialRepository;

    public ProcessStepMaterialService(ProcessStepMaterialRepository processStepMaterialRepository){
        this.processStepMaterialRepository = processStepMaterialRepository;
    }
}
