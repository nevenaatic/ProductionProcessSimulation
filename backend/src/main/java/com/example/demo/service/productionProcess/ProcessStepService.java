package com.example.demo.service.productionProcess;

import com.example.demo.model.productionProcess.ProcessStep;
import com.example.demo.repository.productionProcess.ProcessStepRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessStepService{

    private ProcessStepRepository processStepRepository;

    public  ProcessStepService(ProcessStepRepository processStepRepository){
        this.processStepRepository = processStepRepository;
    }

    public List<ProcessStep> getAll(){
        return  processStepRepository.findAll();
    }

    public ProcessStep save(ProcessStep processStep){
        ProcessStep newProcessStep = new ProcessStep();
        newProcessStep.setProcessStepKind(processStep.getProcessStepKind());
        newProcessStep.setDescription(processStep.getDescription());
        newProcessStep.setName(processStep.getName());
        return processStepRepository.save(newProcessStep);
    }
}
